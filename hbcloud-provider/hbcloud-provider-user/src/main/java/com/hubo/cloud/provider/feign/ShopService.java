package com.hubo.cloud.provider.feign;

import com.hubo.cloud.api.stock.ShopApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "hbcloud-stock",fallbackFactory = ShopFallbackFactory.class)
public interface ShopService extends ShopApi {
}
