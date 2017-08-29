package com.Controller;

import com.TEST.SpringConfig;
import com.Util.AppUtil;
import com.common.MyBatisConfig;
import com.config.ConfigTest;
import com.redis.JedisConfig;
import com.service.FunInter;
import com.tmp.MybatisesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by caoyang on 2017/4/10.
 */
@RestController
public class FunController {

    @Value("${name}")
    private String name;

    @Value("${test}")
    private String test;

    @Autowired
    MyBatisConfig myBatisConfig;


    @Autowired
    ConfigTest configTest;

    @Autowired
    SpringConfig springConfig;

    @Autowired
    MybatisesProperties mybatisesProperties;

    @Resource(name = "funInterImpl1")
    FunInter funInter;

    @Autowired
    JedisConfig jedisConfig;

    @RequestMapping("/config")
    public String config(){
//        System.out.println(mybatisesProperties.getMybatises().toString());


        myBatisConfig.getTypeAliasesPackage();
        System.out.println(configTest.getConfigs().size());
        System.out.println(configTest.getAddress());
        return "test:"+this.test;
    }

    @RequestMapping("/tsession/{age}")
    @ResponseBody
    public String TestSession(HttpServletRequest req, HttpServletResponse resp, @PathVariable String age){
        System.out.println("###########Session_id="+req.getSession().getId());
//        req.getSession().setAttribute("age", age);
//        String a = (String) req.getSession().getAttribute("age");
        return age;
    }

    @RequestMapping("/getBean")
    public String TestConfig(){
        System.out.println(funInter.helloWorld());
        FunInter funInter = (FunInter)AppUtil.getBean("FunInter");
//        return springConfig.counter().;
        return null;
    }

    @RequestMapping("/redisTest")
    public String TestRedis(){
        Jedis jedis = jedisConfig.getJedisSource();
        jedis.set("1","test_ok!");
        return jedis.get("1");
    }
}
