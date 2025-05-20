package practice.hyunjincrudapi.comment.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.hyunjincrudapi.comment.dto.request.CreateCommentRequest;
import practice.hyunjincrudapi.comment.dto.request.UpdateCommentRequest;
import practice.hyunjincrudapi.comment.dto.response.CommentResponse;
import practice.hyunjincrudapi.comment.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comments")
    public void createComment(@RequestBody CreateCommentRequest request) {
        commentService.createComment(request);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentResponse> getCommentsByPost(@PathVariable Long postId) {
        return commentService.getCommentsByPost(postId);
    }

    @PatchMapping("/comments/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody @Valid UpdateCommentRequest request) {
        commentService.updateComment(id, request);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
