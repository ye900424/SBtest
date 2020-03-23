package com.model;

import io.searchbox.annotations.JestId;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by caoyang on 2017/6/7.
 */
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = -6838680554727006134L;

    @JestId
    private Long id;
    private String name;
    private Integer sex;
    private Integer age;

    private School school;
    private List<School> schoolList;

    public Person() {
    }

    public Person(Long id) {
        this.id = id;
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }



    public void print(){
        System.out.println("1234");
    }


}
