package com.team13.route;

import com.team13.model.VersionModel;
import com.team13.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class VersionHandler {

    @Autowired
    private VersionService versionService;

    public Mono<ServerResponse> getAllVersions(ServerRequest request) {
        List<VersionModel> versions = versionService.getAllVersions();
        return ServerResponse.ok().bodyValue(versions);
    }

    public Mono<ServerResponse> getVersionById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        VersionModel version = versionService.getVersionById(id);
        return version != null ? ServerResponse.ok().bodyValue(version) : ServerResponse.notFound().build();
    }

    public Mono<ServerResponse> createVersion(ServerRequest request) {
        Mono<VersionModel> versionMono = request.bodyToMono(VersionModel.class);
        return versionMono.flatMap(version -> {
            VersionModel createdVersion = versionService.createVersion(version);
            return ServerResponse.ok().bodyValue(createdVersion);
        });
    }

    public Mono<ServerResponse> updateVersion(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<VersionModel> versionMono = request.bodyToMono(VersionModel.class);
        return versionMono.flatMap(version -> {
            VersionModel updatedVersion = versionService.updateVersion(id, version);
            return ServerResponse.ok().bodyValue(updatedVersion);
        });
    }

    public Mono<ServerResponse> deleteVersion(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        versionService.deleteVersion(id);
        return ServerResponse.ok().build();
    }
}
