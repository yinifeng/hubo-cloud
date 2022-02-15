package com.hubo.cloud.api.stock;

import com.hubo.cloud.api.stock.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ShopApi {
    
    @GetMapping("/shop/get/{name}")
    String getShop(@PathVariable String name);

    @PostMapping("/shop/save-student")
    void saveStudent(@RequestBody Student student);
}
