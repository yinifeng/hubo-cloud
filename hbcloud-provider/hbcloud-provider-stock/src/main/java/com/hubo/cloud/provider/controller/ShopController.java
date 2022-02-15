package com.hubo.cloud.provider.controller;

import com.hubo.cloud.api.stock.ShopApi;
import com.hubo.cloud.api.stock.domain.Student;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ShopController implements ShopApi {
    
    @Override
    public String getShop(String name) {
        System.out.println("--->feign request");

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello Stock " + name;
    }

    @Override
    public void saveStudent(Student student) {
        try {
            TimeUnit.SECONDS.sleep(student.getNo());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--->feign save stundet = " + student);
    }
}
