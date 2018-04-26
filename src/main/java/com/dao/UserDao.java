package com.dao;

import com.Annotation.CaoCache;
import com.Annotation.CheckDao;
import com.common.MyBatisFactory;
import com.common.MySqlSessionFactory;
import com.domain.User;
import com.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
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

    @Autowired
    MySqlSessionFactory mySqlSessionFactory;

    public int insertUser(String username, String password){
        return userMapper.insertUser(username, password);
//        return 1;
    }

    @CaoCache
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

    @CaoCache
    public Long selectTableTest(User user){
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            Thread.sleep(1000);
            sqlSessionFactory = myBatisFactory.sqlSessionFactory(myBatisFactory.getDataSource());
//            sqlSession = mySqlSessionFactory.sqlSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return (Long)  sqlSessionTemplate.selectOne("user.count",user);
//        return (Long)sqlSessionFactory.openSession().selectOne("user.count",user);
//        return (Long)sqlSession.selectOne("user.count",user);
    }

}
