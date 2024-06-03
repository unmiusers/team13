package com.team13.route;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
@Configuration
public class ProjectRoute {

    @Bean(name = "ProjectRoute")

    public RouterFunction<ServerResponse> route(ProjectHandler handler) {
        return RouterFunctions.route()
                .GET("/projects", handler::getAllProjects)
                .GET("/projects/{id}", handler::getProjectById)
                .POST("/projects", handler::createProject)
                .PUT("/projects/{id}", handler::updateProject)
                .DELETE("/projects/{id}", handler::deleteProject)
                .build();
    }
}
