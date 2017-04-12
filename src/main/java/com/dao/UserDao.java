package com.dao;

import com.domain.User;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by caoyang on 2017/4/10.
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(String username, String password){
        return userMapper.insertUser(username, password);
    }

    public int insertUserWithBackId(User user){
        return userMapper.insertUserWithBackId(user);
    }

}
