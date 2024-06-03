package com.team13.route;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class NotificationRoute {

    @Bean(name = "NotificationRoute")
    public RouterFunction<ServerResponse> route(NotificationHandler handler) {
        return RouterFunctions.route()
                .GET("/notifications", handler::getAllNotifications)
                .GET("/notifications/{id}", handler::getNotificationById)
                .POST("/notifications", handler::createNotification)
                .PUT("/notifications/{id}", handler::updateNotification)
                .DELETE("/notifications/{id}", handler::deleteNotification)
                .build();
    }
}
