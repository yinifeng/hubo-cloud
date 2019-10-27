package com.hubo.cloud.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {
    
    @GetMapping("/hello")
    public String helloAccount(){
        System.out.println("===============>gateway request");
        return UUID.randomUUID().toString();
    }
}
