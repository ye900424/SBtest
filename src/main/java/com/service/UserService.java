package com.service;

import com.domain.User;

/**
 * Created by C.A.O on 2017/12/28.
 */
public interface UserService {
    public User getUser();

    public User getUser(String username,String password);

    public boolean addUser(String username, String password);

    public User addUserWithBackId(String username, String password);

    public void selectByInfo();
}
