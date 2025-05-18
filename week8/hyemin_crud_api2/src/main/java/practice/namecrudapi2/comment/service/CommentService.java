package practice.namecrudapi2.comment.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.namecrudapi2.comment.dto.request.CreateCommentRequest;
import practice.namecrudapi2.comment.dto.request.UpdateCommentRequest;
import practice.namecrudapi2.comment.dto.response.CommentResponse;
import practice.namecrudapi2.comment.entity.Comment;
import practice.namecrudapi2.comment.repository.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    public void createComment(Long postId, CreateCommentRequest request) {
        commentRepository.save(request.toEntity(postId));
    }

    public List<CommentResponse> getCommentsByPost(Long postId) {
        return commentRepository.findByPostId(postId)
                .stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }

    public void updateComment(Long id, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        comment.update(request.getContent());
    }

    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        commentRepository.delete(comment);
    }
}

