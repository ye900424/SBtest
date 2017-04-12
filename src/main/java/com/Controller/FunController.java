package com.Controller;

import com.config.ConfigTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caoyang on 2017/4/10.
 */
@RestController
public class FunController {

    @Value("${name}")
    private String name;

    @Autowired
    ConfigTest configTest;

    @RequestMapping("/config")
    public String config(){
        System.out.println(configTest.getConfigs().size());
        System.out.println(configTest.getAddress());
        return "config:"+name;
    }
}
