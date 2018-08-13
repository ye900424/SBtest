package com.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by caoyang on 2017/6/7.
 */
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = -6838680554727006134L;


    private Long id;
    private String name;
    private Integer sex;
    private Integer age;

    public Person() {
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void print(){
        System.out.println("1234");
    }


}
