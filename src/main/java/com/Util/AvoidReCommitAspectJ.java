/*
package com.Util;

import cn.gov.zcy.fixed.aspect.avoid.recommit.annotation.AvoidReCommit;
import cn.gov.zcy.fixed.aspect.avoid.recommit.exception.ReCommitException;
import com.Annotation.AvoidReCommit;
import com.dtdream.vanyar.redis.jedis.ms.JedisClientUtil;
import com.google.common.collect.Maps;
import io.terminus.common.exception.JsonResponseException;
import io.terminus.pampas.common.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Map;

*/
/**
 * Created by zhouzongkun on 2017/4/27.
 *//*

@Aspect
@Slf4j
@Order(1)
public class AvoidReCommitAspectJ {

    @Autowired
    private JedisClientUtil jedisClientUtil;

    private static final String KEY_SEPARATOR = "/";

    private static final String REDIS_REPSONSE_OK = "OK";

    private static final String REDIS_PREFIX = "fixed";

    */
/** class 对应的url地址*//*

    private Map<Class<?>, String> classToUrlMap = new ConcurrentReferenceHashMap<>();

    */
/** method对应的url地址*//*

    private Map<Method,String> methodToUrlMap = Maps.newConcurrentMap();

    @Pointcut("@annotation(cn.gov.zcy.fixed.aspect.avoid.recommit.annotation.AvoidReCommit)")
    public void avoidReCommitMethod() {
        throw new UnsupportedOperationException();
    }

    @Around(value = "avoidReCommitMethod()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            Long userId = UserUtil.getUserId();

            if (userId == null) {
                throw new ReCommitException("防重提交获取用户失败");
            }

            // 获取当前类
            Class<?> clazz = proceedingJoinPoint.getTarget().getClass();

            // 获取方法
            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            Method method = methodSignature.getMethod();

            // 用于redisKey组装
            StringBuilder sb = new StringBuilder();

            // 对redisKey预处理
            preProcessorForKey(clazz, method, sb);

            // 获取方法上的注解
            AvoidReCommit avoidReCommit = getAvoidReCommit(method, clazz);

            // 对redisKey后处理
            postProcessorForKey(avoidReCommit, sb);

            // 添加用户到key
            sb.append(proceedUrl(userId.toString()));

            // 获取key的过期时间
            int expiredTime = avoidReCommit.expiredTime();

            // 加锁处理
            return doProceed(proceedingJoinPoint, sb.toString(), expiredTime);
        } catch (ReCommitException e) {
            log.warn(e.getMessage(), e);
        }
        return null;
    }

    private String getClassUrl(Class<?> clazz) {

        if (classToUrlMap.containsKey(clazz)) {
            return classToUrlMap.get(clazz);
        }
        RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
        if (requestMapping == null) {
            throw new ReCommitException("防重提交获取controller上RequestMapping为空");
        }
        String[] rootUrlArr = requestMapping.value();
        String rootUrl = "";
        if (rootUrlArr.length > 0) {
            rootUrl = proceedUrl(rootUrlArr[0]);
        }
        classToUrlMap.put(clazz,rootUrl);
        return rootUrl;
    }

    private String getMethodUrl(Method method) {
        if (methodToUrlMap.containsKey(method)) {
            return methodToUrlMap.get(method);
        }
        RequestMapping methodRequestMapping = method.getDeclaredAnnotation(RequestMapping.class);
        if (methodRequestMapping == null) {
            throw new ReCommitException("防重提交获取controller里方法上RequestMapping为空");
        }
        String[] methodUrlArr = methodRequestMapping.value();
        String methodUrl = "";
        if (methodUrlArr.length > 0) {
            methodUrl = proceedUrl(methodUrlArr[0]);
        }
        methodToUrlMap.put(method,methodUrl);
        return methodUrl;
    }

    */
/**
     * 获取方法上或者类上的AvoidReCommit注解
     *
     * @param method
     * @param clazz
     * @return
     *//*

    private AvoidReCommit getAvoidReCommit(Method method, Class<?> clazz) {
        // 优先使用方法上的注解
        AvoidReCommit avoidReCommit = method.getAnnotation(AvoidReCommit.class);
        // 如果方法上无该注解，则获取类上的注解
        if (avoidReCommit == null) {
            avoidReCommit = clazz.getAnnotation(AvoidReCommit.class);
        }
        if (avoidReCommit == null) {
            throw new ReCommitException("方法或者类上无AvoidReCommit注解");
        }
        return avoidReCommit;
    }

    private void preProcessorForKey(Class<?> clazz, Method method, StringBuilder sb) {

        // 获取类上RequestMapping地址
        String rootUrl = getClassUrl(clazz);
        sb.append(proceedUrl(rootUrl));

        // 获取类上RequestMapping地址
        String methodUrl = getMethodUrl(method);
        sb.append(proceedUrl(methodUrl));
    }

    private void postProcessorForKey(AvoidReCommit avoidReCommit, StringBuilder sb) {

        // 获取key的前缀
        String lockedPrefix = avoidReCommit.lockedPrefix();

        // 判断是否有前缀
        if (StringUtils.isNotBlank(lockedPrefix)) {
            sb.insert(0,proceedUrl(lockedPrefix));
        }
    }

    private String proceedUrl(String originUrl) {
        String url = originUrl;
        if (StringUtils.isBlank(url)) {
            return "";
        }
        if (!url.startsWith(KEY_SEPARATOR)) {
            url = KEY_SEPARATOR + url;
        }

        if (url.endsWith(KEY_SEPARATOR)) {
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }


    private Object doProceed(ProceedingJoinPoint proceedingJoinPoint, String redisKey, int expiredTime) {
        if (StringUtils.isBlank(redisKey)) {
            return null;
        }
        redisKey = REDIS_PREFIX + redisKey;
        try {
            // 锁不存在时，设置锁并设置锁过期时间
            if (REDIS_REPSONSE_OK.equalsIgnoreCase(jedisClientUtil.set(redisKey, "1", JedisClientUtil.SetPremise.NX,
                    JedisClientUtil.ExpireType.Seconds,expiredTime))) {
                // 实际方法处理
                return proceedingJoinPoint.proceed();
            } else {
                throw new ReCommitException("出现用户同时多次提交事件：" + redisKey);
            }
        } catch (ReCommitException re) {
            log.warn("出现用户同时多次提交事件：{}", re.getMessage(), re);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
*/
