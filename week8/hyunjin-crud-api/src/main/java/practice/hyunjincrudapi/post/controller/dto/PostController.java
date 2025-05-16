package practice.hyunjincrudapi.post.controller.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.hyunjincrudapi.post.controller.dto.request.CreatePostRequest;
import practice.hyunjincrudapi.post.controller.dto.request.UpdatePostRequest;
import practice.hyunjincrudapi.post.controller.dto.response.PostResponse;
import practice.hyunjincrudapi.post.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class PostController {
    private final PostService postService;

    @PostMapping("/posts")
    public void uploadPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
    }

    @GetMapping("/posts")
    public List<PostResponse> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public PostResponse getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody UpdatePostRequest updatePostRequest) {
        postService.updatePost(id, updatePostRequest);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
