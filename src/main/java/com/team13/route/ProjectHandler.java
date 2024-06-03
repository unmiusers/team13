package com.team13.route;

import com.team13.model.ProjectModel;
import com.team13.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ProjectHandler {

    @Autowired
    private ProjectService projectService;

    public Mono<ServerResponse> getAllProjects(ServerRequest request) {
        List<ProjectModel> projects = projectService.getAllProjects();
        return ServerResponse.ok().bodyValue(projects);
    }

    public Mono<ServerResponse> getProjectById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        ProjectModel project = projectService.getProjectById(id);
        return project != null ?
                ServerResponse.ok().bodyValue(project) :
                ServerResponse.notFound().build();
    }

    public Mono<ServerResponse> createProject(ServerRequest request) {
        Mono<ProjectModel> projectMono = request.bodyToMono(ProjectModel.class);
        return projectMono.flatMap(project -> {
            ProjectModel createdProject = projectService.createProject(project);
            return ServerResponse.ok().bodyValue(createdProject);
        });
    }

    public Mono<ServerResponse> updateProject(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<ProjectModel> projectMono = request.bodyToMono(ProjectModel.class);
        return projectMono.flatMap(project -> {
            ProjectModel updatedProject = projectService.updateProject(id, project);
            return ServerResponse.ok().bodyValue(updatedProject);
        });
    }

    public Mono<ServerResponse> deleteProject(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        projectService.deleteProject(id);
        return ServerResponse.ok().build();
    }
}
