package practice.hyunjincrudapi.comment.controller.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.hyunjincrudapi.comment.controller.dto.request.CreateCommentRequest;
import practice.hyunjincrudapi.comment.controller.dto.request.UpdateCommentRequest;
import practice.hyunjincrudapi.comment.controller.dto.response.CommentResponse;
import practice.hyunjincrudapi.comment.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment")
    public void createComment(@RequestBody CreateCommentRequest request) {
        commentService.createComment(request);
    }

    @GetMapping("/post/{postId}/comment")
    public List<CommentResponse> getComments(@PathVariable Long postId) {
        return commentService.getCommentsByPost(postId);
    }

    @PatchMapping("/comment/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody UpdateCommentRequest request) {
        commentService.updateComment(id, request);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
