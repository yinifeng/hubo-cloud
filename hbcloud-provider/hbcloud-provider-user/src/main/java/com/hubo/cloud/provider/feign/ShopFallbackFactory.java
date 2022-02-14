package com.hubo.cloud.provider.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ShopFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable cause) {
        return new ShopFallback(cause);
    }
}
