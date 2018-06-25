package com.Controller;

import com.domain.TestBean;
import com.domain.User;
import com.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by C.A.O on 2017/10/30.
 */
@RestController
public class MysqlController {
    @Autowired
    UserService userService;

    @ApiOperation("mysql测试")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/sqlTest", method = RequestMethod.POST)
    public boolean sqlTest() {

        TestBean testBean = new TestBean();
        testBean.setId(100);
        testBean.setPassword("cao890809");
        testBean.setUsername("<>caoyanng");
        User user = new User();
        user.setId(99);
        user.setUsername("yejiani");
        user.setPassword("123123");
        testBean.setUser(user);

        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("1","qwert");
        map.put("2","3123");
        map.put("13","qw312321ert");
        testBean.setTestMap(map);

        List<TestBean> testBeans = new ArrayList<>();
        TestBean testBean1 = new TestBean();
        testBean1.setId(102220);
        testBean1.setPassword("cao831231290809");
        testBean1.setUsername("caoy3123123anng");
        user.setId(99);
        user.setUsername("ye3213jiani");
        user.setPassword("1233213123123");
        testBean1.setUser(user);
        testBeans.add(testBean1);
        testBeans.add(null);


         userService.selectByInfo(testBean,"qwertyui",testBeans);
         return true;
    }

}
