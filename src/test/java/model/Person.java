package model;

import lombok.Data;

/**
 * Created by caoyang on 2017/6/7.
 */
@Data
public class Person {
    private Long id;
    private String name;
    private Integer sex;
    private Integer age;

    public Person(){}

    public Person(Long id,String name){
        this.id = id;
        this.name = name;
    }
}
