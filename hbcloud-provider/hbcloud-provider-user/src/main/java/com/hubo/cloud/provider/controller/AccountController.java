package com.hubo.cloud.provider.controller;

import com.hubo.cloud.api.stock.domain.Student;
import com.hubo.cloud.provider.feign.ShopService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private ShopService shopService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    
    @GetMapping("/hello")
    public String helloAccount(){
        System.out.println("===============>gateway request");
        String shop = shopService.getShop("hbcloud-user");
        System.out.println("------>"+shop);
        System.err.printf("Redis k1 = " + stringRedisTemplate.opsForValue().get("k1"));
        //stringRedisTemplate.delete()

        return UUID.randomUUID().toString();
    }

    @GetMapping("/echo/{no}")
    public String echo(@PathVariable Integer no){
        Student student = new Student(no,"hubo",18);
        shopService.saveStudent(student);
        System.out.println("------>"+student);
        return "save student = " + student;
    }
}
