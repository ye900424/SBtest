package com.dao;

import com.Annotation.CheckDao;
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
@CheckDao
public class UserDao {

    @Autowired(required=false)
    private UserMapper userMapper;

    @Autowired
    MyBatisFactory myBatisFactory;

    public int insertUser(String username, String password){
        return userMapper.insertUser(username, password);
//        return 1;
    }

    public int insertUserWithBackId(User user){
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = myBatisFactory.sqlSessionFactory(myBatisFactory.getDataSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory.openSession().insert("user.insertUserWithBackId",user);
//        userMapper.getAll();
//        return userMapper.insertUserWithBackId(user);

    }

    public Long selectTableTest(User user){
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = myBatisFactory.sqlSessionFactory(myBatisFactory.getDataSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Long)sqlSessionFactory.openSession().selectOne("user.count",user);
    }

}
