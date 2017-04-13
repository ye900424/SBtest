package com.service;

import com.dao.UserDao;
import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by caoyang on 2017/4/10.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private User user;

    public User getUser(){
        return user;
    }

    public User getUser(String username,String password){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        return user;
    }

    public boolean addUser(String username, String password){
        return userDao.insertUser(username, password)==1?true:false;
    }

    public User addUserWithBackId(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.insertUserWithBackId(user);//该方法后，主键已经设置到user中了
        return user;
    }

}
