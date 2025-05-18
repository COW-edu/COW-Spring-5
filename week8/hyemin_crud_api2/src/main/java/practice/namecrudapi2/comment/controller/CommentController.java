package practice.namecrudapi2.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.namecrudapi2.comment.dto.request.CreateCommentRequest;
import practice.namecrudapi2.comment.dto.request.UpdateCommentRequest;
import practice.namecrudapi2.comment.dto.response.CommentResponse;
import practice.namecrudapi2.comment.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public void createComment(@PathVariable Long postId, @RequestBody CreateCommentRequest request) {
        commentService.createComment(postId, request);
    }

    @GetMapping
    public List<CommentResponse> getComments(@PathVariable Long postId) {
        return commentService.getCommentsByPost(postId);
    }

    @PutMapping("/{commentId}")
    public void updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest request) {
        commentService.updateComment(commentId, request);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}

