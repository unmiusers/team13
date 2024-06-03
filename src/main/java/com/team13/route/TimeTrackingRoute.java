package com.team13.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TimeTrackingRoute {

    @Bean(name = "TimeTrackingRoute")
    public RouterFunction<ServerResponse> route(TimeTrackingHandler handler) {
        return RouterFunctions.route()
                .GET("/timetracking", handler::getAllTimeTrackings)
                .GET("/timetracking/{id}", handler::getTimeTrackingById)
                .POST("/timetracking", handler::createTimeTracking)
                .PUT("/timetracking/{id}", handler::updateTimeTracking)
                .DELETE("/timetracking/{id}", handler::deleteTimeTracking)
                .build();
    }
}
