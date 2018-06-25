package com.domain;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by C.A.O on 2018/4/26.
 */
public class TestBean implements Serializable{
    private static final long serialVersionUID = 4611180701034524543L;
    private int id;

    private String username;

    private String password;

    private User user;

    private HashMap<String,Object> testMap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HashMap<String, Object> getTestMap() {
        return testMap;
    }

    public void setTestMap(HashMap<String, Object> testMap) {
        this.testMap = testMap;
    }
}
