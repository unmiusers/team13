package com.team13.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CommentRoute {

    @Bean(name = "CommentRoute")
    public RouterFunction<ServerResponse> route(CommentHandler handler) {
        return RouterFunctions.route()
                .GET("/comments", handler::getAllComments)
                .GET("/comments/{id}", handler::getCommentById)
                .POST("/comments", handler::createComment)
                .PUT("/comments/{id}", handler::updateComment)
                .DELETE("/comments/{id}", handler::deleteComment)
                .build();
    }
}
