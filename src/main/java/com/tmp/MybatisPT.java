package com.tmp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by caoyang on 2017/4/13.
 */
@Component
@ConfigurationProperties(prefix = "configTest")
public class MybatisPT {
    private String user;
    private String name;
//    private String[] age;
    private List<String> age;

    public List<String> getAge() {
        return age;
    }

    public void setAge(List<String> age) {
        this.age = age;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
