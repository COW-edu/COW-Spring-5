package practice.dbswncrudapi.post.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.dbswncrudapi.member.entity.Member;
import practice.dbswncrudapi.member.repository.JpaMemberRepository;
import practice.dbswncrudapi.post.controller.dto.request.CreatePostRequest;
import practice.dbswncrudapi.post.controller.dto.request.UpdatePostRequest;
import practice.dbswncrudapi.post.controller.dto.response.PostResponse;
import practice.dbswncrudapi.post.entity.Post;
import practice.dbswncrudapi.post.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final JpaMemberRepository jpaMemberRepository;
    private final PostRepository postRepository;

    public void createPost(CreatePostRequest createPostRequest) {
        Member member = jpaMemberRepository.findById(createPostRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));
        Post post = createPostRequest.toEntity(member);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream()
                .map(PostResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        return PostResponse.from(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUserId(Long userId) {
        Member member = jpaMemberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        return member.getPosts().stream()
                .map(PostResponse::from)
                .collect(Collectors.toList());
    }

    public void updatePost(Long id, UpdatePostRequest updatePostRequest) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        post.update(updatePostRequest.getTitle(), updatePostRequest.getContent());
    }

    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        postRepository.delete(post);
    }
}
