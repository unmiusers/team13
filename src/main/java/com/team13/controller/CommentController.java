package com.team13.controller;

import com.team13.model.CommentModel;
import com.team13.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<CommentModel> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public CommentModel getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping
    public CommentModel createComment(@RequestBody CommentModel comment) {
        return commentService.createComment(comment);
    }

    @PutMapping("/{id}")
    public CommentModel updateComment(@PathVariable Long id, @RequestBody CommentModel comment) {
        return commentService.updateComment(id, comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
