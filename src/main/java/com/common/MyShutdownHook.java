package com.common;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.BitSet;

/**
 * Created by C.A.O on 2018/5/8.
 */
@Component
public class MyShutdownHook extends Thread{

    /**
     * jvm结束是调用
     */
    @PostConstruct
    public void hook(){
        System.out.println("hook_name");
        this.setName("hook_name");
        Runtime.getRuntime().addShutdownHook(this);



    }


    @Override
    public void run() {
        ThreadGroup threadGroup = new ThreadGroup("ThreadGroupName");

        System.out.println("GAME_OVER!");
        threadGroup.uncaughtException(this,null);
    }

    public static void main(String[] args) {
        BitSet bitSet = new BitSet(1111111111);
        bitSet.set(100000);
        bitSet.set(1000);
        bitSet.set(10000);
        bitSet.set(12000);
        bitSet.set(10003300);
        System.out.println(bitSet.nextSetBit(10003301));

    }



}
