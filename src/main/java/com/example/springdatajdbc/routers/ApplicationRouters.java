package com.example.springdatajdbc.routers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class ApplicationRouters {

    @Bean
    RouterFunction<ServerResponse> applicationRoutes() {
        return RouterFunctions
                .route()
                .GET("/hello", request -> {
                    return ServerResponse.ok().bodyValue("Hello, World!");
                })
                .build();
    }
}
