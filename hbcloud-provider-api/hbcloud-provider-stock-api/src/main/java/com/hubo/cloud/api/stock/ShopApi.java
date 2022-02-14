package com.hubo.cloud.api.stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ShopApi {
    
    @GetMapping("/shop/get/{name}")
    String getShop(@PathVariable String name);
}
