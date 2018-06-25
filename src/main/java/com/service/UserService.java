package com.service;

import com.Annotation.XSSFilter;
import com.domain.TestBean;
import com.domain.User;

import java.util.List;

/**
 * Created by C.A.O on 2017/12/28.
 */
public interface UserService {
    User getUser();

    User getUser(String username, String password);

    boolean addUser(String username, String password);

    User addUserWithBackId(String username, String password);

    @XSSFilter("2")
    void selectByInfo(TestBean testBean, String str, List<TestBean> testBeans);
}
