package com.service;

import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by caoyang on 2017/7/26.
 */
@Service
public class FunInterImpl1 implements FunInter{
    @Autowired
    TestService testService;

    @Autowired
    UserService userService;



    @Override
    public String helloWorld() {
        testService.toString();
        User user = userService.getUser();
        return "helloWorld_1";
    }
}
