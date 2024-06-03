package com.team13.route;

import com.team13.model.TimeTrackingModel;
import com.team13.service.TimeTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class TimeTrackingHandler {

    @Autowired
    private TimeTrackingService timeTrackingService;

    public Mono<ServerResponse> getAllTimeTrackings(ServerRequest request) {
        List<TimeTrackingModel> timeTrackings = timeTrackingService.getAllTimeTrackings();
        return ServerResponse.ok().bodyValue(timeTrackings);
    }

    public Mono<ServerResponse> getTimeTrackingById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        TimeTrackingModel timeTracking = timeTrackingService.getTimeTrackingById(id);
        return timeTracking != null ? ServerResponse.ok().bodyValue(timeTracking) : ServerResponse.notFound().build();
    }

    public Mono<ServerResponse> createTimeTracking(ServerRequest request) {
        Mono<TimeTrackingModel> timeTrackingMono = request.bodyToMono(TimeTrackingModel.class);
        return timeTrackingMono.flatMap(timeTracking -> {
            TimeTrackingModel createdTimeTracking = timeTrackingService.createTimeTracking(timeTracking);
            return ServerResponse.ok().bodyValue(createdTimeTracking);
        });
    }

    public Mono<ServerResponse> updateTimeTracking(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<TimeTrackingModel> timeTrackingMono = request.bodyToMono(TimeTrackingModel.class);
        return timeTrackingMono.flatMap(timeTracking -> {
            TimeTrackingModel updatedTimeTracking = timeTrackingService.updateTimeTracking(id, timeTracking);
            return ServerResponse.ok().bodyValue(updatedTimeTracking);
        });
    }

    public Mono<ServerResponse> deleteTimeTracking(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        timeTrackingService.deleteTimeTracking(id);
        return ServerResponse.ok().build();
    }
}
