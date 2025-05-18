package practice.namecrudapi2.post.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.namecrudapi2.post.dto.request.CreatePostRequest;
import practice.namecrudapi2.post.dto.request.UpdatePostRequest;
import practice.namecrudapi2.post.dto.response.PostResponse;
import practice.namecrudapi2.post.entity.Post;
import practice.namecrudapi2.post.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public void createPost(CreatePostRequest request) {
        postRepository.save(request.toEntity());
    }

    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        return new PostResponse(post);
    }

    public void updatePost(Long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        post.update(request.getTitle(), request.getContent());
    }

    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        postRepository.delete(post);
    }
}
