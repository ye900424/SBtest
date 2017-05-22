package com.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caoyang on 2017/4/26.
 */
@RestController
@RequestMapping("/sbRemote")
public class SpringRemotingTest {

    @RequestMapping()
    public String sbRemoteTest(){
        return "sbRemoteTest_OK!";
    }
}
