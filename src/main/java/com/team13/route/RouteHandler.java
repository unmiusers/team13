package com.team13.route;

import com.team13.model.*;
import com.team13.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class RouteHandler {

    @Autowired
    private IssueService issueService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private TimeTrackingService timeTrackingService;
    @Autowired
    private UserService userService;
    @Autowired
    private WikiService wikiService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private VersionService versionService;

    // Issue handlers
    public Mono<ServerResponse> getAllIssues(ServerRequest request) {
        List<IssueModel> issues = issueService.getAllIssues();
        return ServerResponse.ok().bodyValue(issues);
    }

    public Mono<ServerResponse> getIssueById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        IssueModel issue = issueService.getIssueById(id);
        return ServerResponse.ok().bodyValue(issue);
    }

    public Mono<ServerResponse> createIssue(ServerRequest request) {
        Mono<IssueModel> issueMono = request.bodyToMono(IssueModel.class);
        return issueMono.flatMap(issue -> {
            IssueModel createdIssue = issueService.createIssue(issue);
            return ServerResponse.ok().bodyValue(createdIssue);
        });
    }

    public Mono<ServerResponse> updateIssue(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<IssueModel> issueMono = request.bodyToMono(IssueModel.class);
        return issueMono.flatMap(issue -> {
            IssueModel updatedIssue = issueService.updateIssue(id, issue);
            return ServerResponse.ok().bodyValue(updatedIssue);
        });
    }

    public Mono<ServerResponse> deleteIssue(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        issueService.deleteIssue(id);
        return ServerResponse.ok().build();
    }

    // Similar handler methods for other entities...

}
