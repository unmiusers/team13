package com.team13.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRoute {

    @Bean(name = "UserRoute")
    public RouterFunction<ServerResponse> route(UserHandler handler) {
        return RouterFunctions.route()
                .GET("/users", handler::getAllUsers)
                .GET("/users/{id}", handler::getUserById)
                .POST("/users", handler::createUser)
                .PUT("/users/{id}", handler::updateUser)
                .DELETE("/users/{id}", handler::deleteUser)
                .build();
    }
}
