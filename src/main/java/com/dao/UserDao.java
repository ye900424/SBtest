package com.dao;

import com.common.MyBatisFactory;
import com.domain.User;
import com.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by caoyang on 2017/4/10.
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    MyBatisFactory myBatisFactory;

    public int insertUser(String username, String password){
        return userMapper.insertUser(username, password);
//        return 1;
    }

    public int insertUserWithBackId(User user){
//        SqlSessionFactory sqlSessionFactory = null;
//        try {
//            sqlSessionFactory = myBatisFactory.sqlSessionFactory(myBatisFactory.getDataSource());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sqlSessionFactory.openSession().insert("com.mapper.UserMapper.insertUserWithBackId",user);
        userMapper.getAll();
        return userMapper.insertUserWithBackId(user);

    }

}