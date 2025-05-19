package practice.hyunjincrudapi.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.hyunjincrudapi.member.entity.Member;
import practice.hyunjincrudapi.member.repository.JpaMemberRepository;
import practice.hyunjincrudapi.post.controller.dto.request.CreatePostRequest;
import practice.hyunjincrudapi.post.controller.dto.request.UpdatePostRequest;
import practice.hyunjincrudapi.post.controller.dto.response.PostResponse;
import practice.hyunjincrudapi.post.entity.Post;
import practice.hyunjincrudapi.post.repository.JpaPostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final JpaPostRepository postRepository;
    private final JpaMemberRepository memberRepository;

    public void createPost(CreatePostRequest request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Post post = request.toEntity(member);
        postRepository.save(post);
    }

    public List<PostResponse> getAllPosts(){
        return postRepository.findAll().stream()
                .map(PostResponse::from)
                .collect(Collectors.toList());
    }

    public PostResponse getPostById(Long id) {
        return postRepository.findById(id)
                .map(PostResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
    }

    public void updatePost(Long id, UpdatePostRequest request) {
        Post post = postRepository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException(("해당 게시글이 존재하지 않습니다.")));

        post.update(request.getTitle(), request.getContent());
    }

    public void deletePost(Long id) {
        Post post = postRepository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException(("해당 게시글이 존재하지 않습니다.")));

        postRepository.delete(post);
    }
}

