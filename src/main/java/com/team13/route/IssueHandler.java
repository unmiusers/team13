package com.team13.route;

import com.team13.model.IssueModel;
import com.team13.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class IssueHandler {

    @Autowired
    private IssueService issueService;

    public Mono<ServerResponse> getAllIssues(ServerRequest request) {
        List<IssueModel> issues = issueService.getAllIssues();
        return ServerResponse.ok().bodyValue(issues);
    }

    public Mono<ServerResponse> getIssueById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        IssueModel issue = issueService.getIssueById(id);
        return issue != null ?
                ServerResponse.ok().bodyValue(issue) :
                ServerResponse.notFound().build();
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
}
