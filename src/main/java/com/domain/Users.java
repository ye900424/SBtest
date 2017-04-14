package com.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoyang on 2017/4/13.
 */
@ConfigurationProperties(prefix = "user")
public class Users extends User{
    private static List<User> list = null;


    public static List<User> getList() {
        return list;
    }

    public static void setList(List<User> list) {
        Users.list = list;
    }
}
