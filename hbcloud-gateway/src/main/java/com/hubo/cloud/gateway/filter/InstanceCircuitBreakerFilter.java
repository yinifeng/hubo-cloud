package com.hubo.cloud.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.core.ConfigurationNotFoundException;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.ReactiveLoadBalancerClientFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

/**
 * 实例级别的断路器
 * 
 * 
 * Spring Cloud Gateway 不用做线程隔离，因为 reactor 框架不是同步框架，某个实例发生阻塞对它影响不至于很大。
 * 我们只在其中做实例级别的熔断，每个微服务都会做这个实例级别的熔断。所以需要加一个GlobalFilter。
 * 这个熔断需要在负载均衡器选择实例并重写调用 url 之后，也就是在 ReactiveLoadBalancerClientFilter 之后
 * 
 */
@Log4j2
//@Component
public class InstanceCircuitBreakerFilter implements GlobalFilter, Ordered {

    private static final String SERVICE_NAME = "SERVICE-NAME";

    private final CircuitBreakerRegistry circuitBreakerRegistry;
    ObjectMapper objectMapper = new ObjectMapper();


    public InstanceCircuitBreakerFilter(CircuitBreakerRegistry circuitBreakerRegistry) {
        this.circuitBreakerRegistry = circuitBreakerRegistry;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        URI url = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);
        ServerHttpRequest request = exchange.getRequest();
        String serviceName = request.getHeaders().getFirst(SERVICE_NAME);
        String instanceId = url.getHost() + url.getPort();
        CircuitBreaker circuitBreaker;
        try {
            //使用实例id新建或者获取现有的CircuitBreaker,使用serviceName获取配置
            circuitBreaker = circuitBreakerRegistry.circuitBreaker(instanceId, serviceName);
        } catch (ConfigurationNotFoundException e) {
            circuitBreaker = circuitBreakerRegistry.circuitBreaker(instanceId);
        }

        try {
            log.info("try to send request to: {}: stats: {}", url, objectMapper.writeValueAsString(circuitBreaker.getMetrics()));
        } catch (JsonProcessingException e) {
        }

        return chain.filter(exchange).transform(CircuitBreakerOperator.of(circuitBreaker));
    }

    @Override
    public int getOrder() {
        try {
            //必须在负载均衡器选择实例并重写调用 url 之后，也就是在 `ReactiveLoadBalancerClientFilter` 之后。
            return (Integer) ReactiveLoadBalancerClientFilter.class.getDeclaredField("LOAD_BALANCER_CLIENT_FILTER_ORDER").get(null) + 1;
        } catch (Exception e) {
            return 10151;
        }
    }

}


