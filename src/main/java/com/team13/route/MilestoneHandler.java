package com.team13.route;

import com.team13.model.MilestoneModel;
import com.team13.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class MilestoneHandler {

    @Autowired
    private MilestoneService milestoneService;

    public Mono<ServerResponse> getAllMilestones(ServerRequest request) {
        List<MilestoneModel> milestones = milestoneService.getAllMilestones();
        return ServerResponse.ok().bodyValue(milestones);
    }

    public Mono<ServerResponse> getMilestoneById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        MilestoneModel milestone = milestoneService.getMilestoneById(id);
        return milestone != null ? ServerResponse.ok().bodyValue(milestone) : ServerResponse.notFound().build();
    }

    public Mono<ServerResponse> createMilestone(ServerRequest request) {
        Mono<MilestoneModel> milestoneMono = request.bodyToMono(MilestoneModel.class);
        return milestoneMono.flatMap(milestone -> {
            MilestoneModel createdMilestone = milestoneService.createMilestone(milestone);
            return ServerResponse.ok().bodyValue(createdMilestone);
        });
    }

    public Mono<ServerResponse> updateMilestone(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<MilestoneModel> milestoneMono = request.bodyToMono(MilestoneModel.class);
        return milestoneMono.flatMap(milestone -> {
            MilestoneModel updatedMilestone = milestoneService.updateMilestone(id, milestone);
            return ServerResponse.ok().bodyValue(updatedMilestone);
        });
    }

    public Mono<ServerResponse> deleteMilestone(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        milestoneService.deleteMilestone(id);
        return ServerResponse.ok().build();
    }
}
