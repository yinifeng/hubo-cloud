package com.hubo.cloud.provider.feign;

import com.hubo.cloud.api.stock.ShopApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 当配置了 contextId = "tom" 以 tom为配置组，线程隔离 线程池名称 bulkhead-tom-线程号
 * 否则，以 serviceName为配置组，线程隔离 线程池名称 hbcloud-stock-线程号
 * 
 */
@FeignClient(name = "hbcloud-stock",contextId = "tom",fallbackFactory = ShopFallbackFactory.class)
public interface ShopService extends ShopApi {
}
