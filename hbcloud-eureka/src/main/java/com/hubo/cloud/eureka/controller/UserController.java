package com.hubo.cloud.eureka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    @ResponseBody
    public Map<String,Object> getUser() {
        System.out.println(Thread.currentThread().getName() + ": 请求成功...");
        Map<String,Object> user = new HashMap<>();
        user.put("id",1001L);
        user.put("name","jack");
        user.put("age",21);
        return user;
    }
}
