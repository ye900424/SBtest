package com.Controller;

import com.common.MyBatisConfig;
import com.config.ConfigTest;
import com.tmp.MybatisesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    MybatisesProperties mybatisesProperties;

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
}
