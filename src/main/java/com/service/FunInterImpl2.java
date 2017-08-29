package com.service;

import org.springframework.stereotype.Service;

/**
 * Created by caoyang on 2017/7/26.
 */
@Service
public class FunInterImpl2 implements FunInter{
    @Override
    public String helloWorld() {
        return "helloWorld_2";
    }
}
