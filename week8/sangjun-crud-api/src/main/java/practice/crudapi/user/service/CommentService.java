package practice.crudapi.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.crudapi.user.controller.dto.request.CreateCommentRequest;
import practice.crudapi.user.controller.dto.request.CreatePostRequest;
import practice.crudapi.user.controller.dto.request.UpdateCommentRequest;
import practice.crudapi.user.controller.dto.request.UpdatePostRequest;
import practice.crudapi.user.controller.dto.response.CommentResponse;
import practice.crudapi.user.controller.dto.response.PostResponse;
import practice.crudapi.user.entity.Comment;
import practice.crudapi.user.entity.Post;
import practice.crudapi.user.entity.User;
import practice.crudapi.user.repository.JpaCommentRepository;
import practice.crudapi.user.repository.JpaPostRepository;
import practice.crudapi.user.repository.JpaUserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final JpaPostRepository postRepository;
    private final JpaUserRepository userRepository;
    private final JpaCommentRepository commentRepository;

    public void signup(Long postId, CreateCommentRequest createCommentRequest) {
        User user = userRepository.findById(createCommentRequest.getUserId()).orElse(null);
        Post post = postRepository.findById(postId).orElse(null);;
        Comment comment = createCommentRequest.toEntity(user,post);
        commentRepository.save(comment);
    }

    public List<CommentResponse> getCommentByPostId(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);;
        List<Comment> comments = commentRepository.findByPost(post);

        return comments.stream()
                .map(comment -> new CommentResponse(
                        comment.getId(),
                        comment.getContent(),
                        comment.getUser().getId(),
                        comment.getPost().getId()
                ))
                .collect(Collectors.toList());
    }

    public void updateComment(Long id, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        comment.updateContent(request.getContent());
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
