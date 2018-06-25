package com.aop;

import com.Annotation.XSSFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 用于处理web安全相关切面
 *
 * @author 老曹
 * @since 2018/04/26
 */
@Component
@Aspect
@Slf4j
public class XssFilterAspectj {
    private String CHECK_FLAG = "1"; //校验
    private String REPLACE_FLAG = "2"; //替换

    @Pointcut(value = "@annotation(com.Annotation.XSSFilter)")
    private void xssFilterPointcut() {
        // Do nothing just pointcut
        throw new UnsupportedOperationException("This method is just for @Pointcut!");
    }

    /**
     * aop-Around 拦截方法，过滤入参
     *
     * @param joinPoint
     * @return
     */
    @Around("xssFilterPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String value = CHECK_FLAG;


        /**获取实现类方法上的注解 */
//        Class<?> classTarget=joinPoint.getTarget().getClass();
//        Class<?>[] par=((MethodSignature) joinPoint.getSignature()).getParameterTypes();
//        Method objMethod=classTarget.getMethod(joinPoint.getSignature().getName(), par);
//        Annotation targetAnnotation = objMethod.getAnnotation(XSSFilter.class);

        /**获取接口方法上的注解 */
        Annotation annotation = method.getDeclaredAnnotation(XSSFilter.class);
        method.getDeclaredAnnotation(XSSFilter.class);
        if (Objects.nonNull(annotation)) {
            value = ((XSSFilter) annotation).value();
        }

        Object[] args = joinPoint.getArgs();

        if (REPLACE_FLAG.equals(value)) {
            //xss敏感字符替换
            args = (Object[]) recuReplace(args);
        } else {
            //xss校验
            recuCheck(args);
        }


        //用过滤好的参数继续执行
        Object obj = null;
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return obj;
    }

    /**
     * 递归检查
     *
     * @param obj
     * @return
     */
    public Object recuCheck(Object obj) {
        if (Objects.isNull(obj)) return obj;

        if (obj.getClass().isArray() && Array.getLength(obj) > 0) {
            //数组
            for (int i = 0; i < Array.getLength(obj); i++) {
                recuCheck(Array.get(obj, i));
            }
        }
        if (obj instanceof String) {
            //String
            doCheck((String) obj);
        } else if (obj instanceof Map) {
            //map
            ((Map) obj).forEach((k, v) -> {
                recuCheck(v);
            });

        } else if (obj instanceof List) {
            //list
            ((List) obj).forEach(x -> recuCheck(x));
        } else if (obj instanceof Integer || obj instanceof Long) {
            //不做任何处理
        } else {
            //对象
            Class clazz = obj.getClass();
            Field[] allFields = getAllFields(clazz);
            for (Field field : allFields) {
                field.setAccessible(true);
                try {
                    recuCheck(field.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }

    /**
     * 获取class及其父类的fields
     *
     * @param clazz
     * @return
     */
    public Field[] getAllFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();

        Class superClazz = clazz.getSuperclass();
        while (!"Object".equals(superClazz.getSimpleName())) {
            fields = ArrayUtils.addAll(fields, superClazz.getDeclaredFields());
            superClazz = superClazz.getSuperclass();

        }

        return fields;
    }

    /**
     * 递归处理
     *
     * @param obj
     * @return
     */
    public Object recuReplace(Object obj) {
        if (Objects.isNull(obj)) return obj;

        if (obj.getClass().isArray() && Array.getLength(obj) > 0) {
            //数组
            for (int i = 0; i < Array.getLength(obj); i++) {
                Array.set(obj, i, recuReplace(Array.get(obj, i)));
            }
        }
        if (obj instanceof String) {
            //String
            obj = doReplace((String) obj);
        } else if (obj instanceof Map) {
            //map
            for (Object key : ((Map) obj).keySet()) {
                Object value = ((Map) obj).get(key);
                ((Map) obj).put(key, recuReplace(value));
            }
        } else if (obj instanceof List) {
            //list
            for (int i = 0; i < ((List) obj).size(); i++) {
                ((List) obj).set(i, recuReplace(((List) obj).get(i)));
            }
        } else if (obj instanceof Integer || obj instanceof Long) {
            //不做任何处理
        } else {
            //对象
            Class clazz = obj.getClass();
            Field[] allFields = getAllFields(clazz);
            for (Field field : allFields) {
                field.setAccessible(true);
                Object subObj = null;
                try {
                    subObj = field.get(obj);

                    //判断是否用final修饰
                    if (!Modifier.isFinal(field.getModifiers())) {
                        field.set(obj, recuReplace(subObj));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }

    /**
     * （校验）过滤特殊字符
     *
     * @param sourceArg
     * @return
     */
    public void doCheck(String sourceArg) {
        Pattern pattern = Pattern.compile(".*<(\"[^\"]*\"|'[^']*'|[^'\">0-9])+>.*");

        //todo 具体校验规则还待补充
        if (pattern.matcher(sourceArg).matches()) {
            log.warn("XSS校验未通过，参数：" + sourceArg);
            throw new RuntimeException("argument.invalid.xss");
        }
    }

    /**
     * （替换）过滤特殊字符
     *
     * @param sourceArg
     * @return
     */
    public String doReplace(String sourceArg) {
        //todo 具体校验规则还待补充
//        return sourceArg.replaceAll("<", "").replaceAll(">", "");
        return "替换";
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(".*<([^\"]|[^'>\\d])+>.*");
        System.out.println(pattern.matcher("<dfgh>dfg").matches());
        System.out.println(Pattern.matches(".*</?[A-za-z]+>.*", "aasd</asdfghj>"));
        System.out.println(Pattern.matches(".*<(\"[^\"]*\"|'[^']*'|[^'\">0-9])+>.*", "<input value=\"123d123\">"));
    }
}
