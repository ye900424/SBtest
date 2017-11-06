package com.Controller;

import com.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
         userService.selectByInfo();
         return true;
    }

}
