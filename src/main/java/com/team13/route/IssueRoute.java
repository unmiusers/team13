package com.team13.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class IssueRoute {

    @Bean(name = "IssueRoute")
    public RouterFunction<ServerResponse> route(IssueHandler handler) {
        return RouterFunctions.route()
                .GET("/issues", handler::getAllIssues)
                .GET("/issues/{id}", handler::getIssueById)
                .POST("/issues", handler::createIssue)
                .PUT("/issues/{id}", handler::updateIssue)
                .DELETE("/issues/{id}", handler::deleteIssue)
                .build();
    }
}
