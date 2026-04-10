package practice.crudapi.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.crudapi.user.controller.dto.request.CreateCommentRequest;
import practice.crudapi.user.controller.dto.request.CreatePostRequest;
import practice.crudapi.user.controller.dto.request.UpdateCommentRequest;
import practice.crudapi.user.controller.dto.request.UpdatePostRequest;
import practice.crudapi.user.controller.dto.response.CommentResponse;
import practice.crudapi.user.controller.dto.response.PostResponse;
import practice.crudapi.user.service.CommentService;
import practice.crudapi.user.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments/{id}")
    public void signUp(@PathVariable Long id,@RequestBody CreateCommentRequest createCommentRequest) {
        commentService.signup(id,createCommentRequest);
    }

    @GetMapping("/comments/{id}")
    public List<CommentResponse> getCommentByPostId(@PathVariable Long id) {
        return commentService.getCommentByPostId(id);
    }

    @PatchMapping("/comments")
    public void updateComment(@RequestParam Long id, @RequestBody UpdateCommentRequest updateCommentRequest) {
        commentService.updateComment(id, updateCommentRequest);
    }

    @DeleteMapping("/comments")
    public void deleteComment(@RequestParam Long id) {
        commentService.deleteComment(id);
    }
}
