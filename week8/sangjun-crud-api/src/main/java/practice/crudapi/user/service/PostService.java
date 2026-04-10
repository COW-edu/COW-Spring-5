package practice.crudapi.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.crudapi.user.controller.dto.request.CreatePostRequest;
import practice.crudapi.user.controller.dto.request.CreateUserRequest;
import practice.crudapi.user.controller.dto.request.UpdatePostRequest;
import practice.crudapi.user.controller.dto.request.UpdateUserRequest;
import practice.crudapi.user.controller.dto.response.PostResponse;
import practice.crudapi.user.controller.dto.response.UserResponse;
import practice.crudapi.user.entity.Post;
import practice.crudapi.user.entity.User;
import practice.crudapi.user.repository.JpaPostRepository;
import practice.crudapi.user.repository.JpaUserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final JpaPostRepository postRepository;
    private final JpaUserRepository userRepository;

    public void signup(CreatePostRequest createPostRequest) {
        User user = userRepository.findById(createPostRequest.getUserId()).orElse(null);
        Post post = createPostRequest.toEntity(user);
        postRepository.save(post);
    }

    public List<PostResponse> getAllPost() {
        List<Post> posts = postRepository.findAll();

        return posts.stream()
                .map(post -> new PostResponse(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getUser().getId()
                ))
                .collect(Collectors.toList());
    }

    public PostResponse getPostById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        return new PostResponse(post.getId(),post.getTitle(),post.getContent(),post.getUser().getId());
    }

    public void updatePost(Long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.updatePost(request.getTitle(), request.getContent());
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
