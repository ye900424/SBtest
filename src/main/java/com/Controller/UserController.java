package com.Controller;

import com.alibaba.fastjson.JSON;
import com.common.MyConstants;
import com.domain.User;
import com.redis.MyRedisTemplate;
import com.service.UserService;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caoyang on 2017/4/10.
 */
@RestController
@RequestMapping("/user")
@Api("userController相关api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MyRedisTemplate myRedisTemplate;

    @RequestMapping("/getUser")
    public User getUser() {
        return userService.getUser();
    }

    @RequestMapping("/testJedisCluster")
    public User testJedisCluster(@RequestParam("username") String username){
        String value =  myRedisTemplate.get(MyConstants.USER_FORWARD_CACHE_PREFIX, username);
        if(StringUtils.isBlank(value)){
            myRedisTemplate.set(MyConstants.USER_FORWARD_CACHE_PREFIX, username, JSON.toJSONString(getUser()));
            return null;
        }

        return JSON.parseObject(value, User.class);
    }

    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value = "用户的姓名", defaultValue = "zhaojigang"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "wangna")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public boolean addUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        return userService.addUser(username, password);
    }

    @ApiOperation("添加用户且返回已经设置了主键的user实例")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value = "用户的姓名", defaultValue = "zhaojigang"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "wangna")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/addUserWithBackId", method = RequestMethod.POST)
    public User addUserWithBackId(@RequestParam("username") String username,
                                  @RequestParam("password") String password) {
        return userService.addUserWithBackId(username, password);
    }
}
