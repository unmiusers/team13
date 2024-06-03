package com.team13.route;

import com.team13.model.NotificationModel;
import com.team13.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class NotificationHandler {

    @Autowired
    private NotificationService notificationService;

    public Mono<ServerResponse> getAllNotifications(ServerRequest request) {
        List<NotificationModel> notifications = notificationService.getAllNotifications();
        return ServerResponse.ok().bodyValue(notifications);
    }

    public Mono<ServerResponse> getNotificationById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        NotificationModel notification = notificationService.getNotificationById(id);
        return notification != null ? ServerResponse.ok().bodyValue(notification) : ServerResponse.notFound().build();
    }

    public Mono<ServerResponse> createNotification(ServerRequest request) {
        Mono<NotificationModel> notificationMono = request.bodyToMono(NotificationModel.class);
        return notificationMono.flatMap(notification -> {
            NotificationModel createdNotification = notificationService.createNotification(notification);
            return ServerResponse.ok().bodyValue(createdNotification);
        });
    }

    public Mono<ServerResponse> updateNotification(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<NotificationModel> notificationMono = request.bodyToMono(NotificationModel.class);
        return notificationMono.flatMap(notification -> {
            NotificationModel updatedNotification = notificationService.updateNotification(id, notification);
            return ServerResponse.ok().bodyValue(updatedNotification);
        });
    }

    public Mono<ServerResponse> deleteNotification(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        notificationService.deleteNotification(id);
        return ServerResponse.ok().build();
    }
}
