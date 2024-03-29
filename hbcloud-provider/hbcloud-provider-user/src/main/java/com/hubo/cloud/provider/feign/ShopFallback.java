package com.hubo.cloud.provider.feign;

import com.hubo.cloud.api.stock.ShopApi;
import com.hubo.cloud.api.stock.domain.Student;

public class ShopFallback implements ShopApi {

    private final Throwable cause;

    public ShopFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public String getShop(String name) {
        System.err.println("错误:" + name);
        cause.printStackTrace();
        return "error";
    }

    @Override
    public void saveStudent(Student student) {
        System.err.println("保存学生错误:" + student);
        cause.printStackTrace();
    }
}
