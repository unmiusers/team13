package com.team13.route;

import com.team13.route.MilestoneHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MilestoneRoute {

    @Bean
    public RouterFunction<ServerResponse> route(MilestoneHandler handler) {
        return RouterFunctions.route()
                .GET("/api/milestones", handler::getAllMilestones)
                .GET("/api/milestones/{id}", handler::getMilestoneById)
                .POST("/api/milestones", handler::createMilestone)
                .PUT("/api/milestones/{id}", handler::updateMilestone)
                .DELETE("/api/milestones/{id}", handler::deleteMilestone)
                .build();
    }
}
