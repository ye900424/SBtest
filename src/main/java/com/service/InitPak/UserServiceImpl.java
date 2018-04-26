package com.service.InitPak;

import com.Annotation.CaoCache;
import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by caoyang on 2017/4/10.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private User user;

    public User getUser(){
        System.out.println("****");
        return user;
    }

    public User getUser(String username,String password){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        return user;
    }

    @CaoCache
    public boolean addUser(String username, String password){
        System.out.println("execute");
        return userDao.insertUser(username, password)==1?true:false;
    }

    protected void fun(){
        System.out.println("12345");
    }

    public User addUserWithBackId(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.insertUserWithBackId(user);//该方法后，主键已经设置到user中了
        return user;
    }

    /**
     * 查询列表测试
     */
    public void selectByInfo(){
        for(int i = 0 ; i < 1000 ; i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(i + ":" + userDao.selectTableTest(null));
        }
        ConcurrentHashMap cMap = new ConcurrentHashMap();
        cMap.putIfAbsent("","");

        System.out.println("selectTableTest:=" + userDao.selectTableTest(null));

        System.out.println("ok!");



    }

}
