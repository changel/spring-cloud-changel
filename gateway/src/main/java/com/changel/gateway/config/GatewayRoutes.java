package com.changel.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Chang.Tong
 * @Date 2021/2/6 17:18
 * @Version 1.0
 */
//@Configuration
public class GatewayRoutes {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(
                r -> r.path("/frontend/api/gateway/**")
                        .uri("http://localhost:9000/")
        ).build();
    }
}
