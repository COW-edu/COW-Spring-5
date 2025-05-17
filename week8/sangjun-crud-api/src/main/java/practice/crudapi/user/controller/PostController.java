package practice.crudapi.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.crudapi.user.controller.dto.request.CreatePostRequest;
import practice.crudapi.user.controller.dto.request.CreateUserRequest;
import practice.crudapi.user.controller.dto.request.UpdatePostRequest;
import practice.crudapi.user.controller.dto.request.UpdateUserRequest;
import practice.crudapi.user.controller.dto.response.PostResponse;
import practice.crudapi.user.controller.dto.response.UserResponse;
import practice.crudapi.user.service.PostService;
import practice.crudapi.user.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void signUp(@RequestBody CreatePostRequest createPostRequest) {
        postService.signup(createPostRequest);
    }

    @GetMapping("/posts")
    public List<PostResponse> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/posts/{id}")
    public PostResponse getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PatchMapping("/posts")
    public void updatePost(@RequestParam Long id, @RequestBody UpdatePostRequest updatePostRequest) {
        postService.updatePost(id, updatePostRequest);
    }

    @DeleteMapping("/posts")
    public void deletePost(@RequestParam Long id) {
        postService.deletePost(id);
    }
}
