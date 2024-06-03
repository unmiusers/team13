package com.team13.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class VersionRoute {

    @Bean(name = "VersionRoute")
    public RouterFunction<ServerResponse> route(VersionHandler handler) {
        return RouterFunctions.route()
                .GET("/versions", handler::getAllVersions)
                .GET("/versions/{id}", handler::getVersionById)
                .POST("/versions", handler::createVersion)
                .PUT("/versions/{id}", handler::updateVersion)
                .DELETE("/versions/{id}", handler::deleteVersion)
                .build();
    }
}
