package com.team13.route;

import com.team13.model.CommentModel;
import com.team13.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CommentHandler {

    @Autowired
    private CommentService commentService;

    public Mono<ServerResponse> getAllComments(ServerRequest request) {
        List<CommentModel> comments = commentService.getAllComments();
        return ServerResponse.ok().bodyValue(comments);
    }

    public Mono<ServerResponse> getCommentById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        CommentModel comment = commentService.getCommentById(id);
        return comment != null ?
                ServerResponse.ok().bodyValue(comment) :
                ServerResponse.notFound().build();
    }

    public Mono<ServerResponse> createComment(ServerRequest request) {
        Mono<CommentModel> commentMono = request.bodyToMono(CommentModel.class);
        return commentMono.flatMap(comment -> {
            CommentModel createdComment = commentService.createComment(comment);
            return ServerResponse.ok().bodyValue(createdComment);
        });
    }

    public Mono<ServerResponse> updateComment(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<CommentModel> commentMono = request.bodyToMono(CommentModel.class);
        return commentMono.flatMap(comment -> {
            CommentModel updatedComment = commentService.updateComment(id, comment);
            return ServerResponse.ok().bodyValue(updatedComment);
        });
    }

    public Mono<ServerResponse> deleteComment(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        commentService.deleteComment(id);
        return ServerResponse.ok().build();
    }
}
