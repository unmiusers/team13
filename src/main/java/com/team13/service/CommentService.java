package com.team13.service;

import com.team13.model.CommentModel;
import com.team13.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentModel> getAllComments() {
        return commentRepository.findAll();
    }

    public CommentModel getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public CommentModel createComment(CommentModel comment) {
        return commentRepository.save(comment);
    }

    public CommentModel updateComment(Long id, CommentModel comment) {
        if (commentRepository.existsById(id)) {
            comment.setId(id);
            return commentRepository.save(comment);
        } else {
            return null;
        }
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
