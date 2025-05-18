package practice.dbswncrudapi.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.dbswncrudapi.comment.dto.request.CommentRequest;
import practice.dbswncrudapi.comment.dto.response.CommentResponse;
import practice.dbswncrudapi.comment.entity.Comment;
import practice.dbswncrudapi.comment.repository.CommentRepository;
import practice.dbswncrudapi.member.entity.Member;
import practice.dbswncrudapi.member.repository.JpaMemberRepository;
import practice.dbswncrudapi.post.entity.Post;
import practice.dbswncrudapi.post.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final JpaMemberRepository jpaMemberRepository;
    private final PostRepository postRepository;

    public CommentResponse createComment(Long postId, CommentRequest dto) {
        Member member = jpaMemberRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));

        Comment comment = Comment.builder()
                .content(dto.getContent())
                .member(member)
                .post(post)
                .build();
        Comment saved = commentRepository.save(comment);

        return new CommentResponse(saved.getId(), saved.getContent(), member.getId(), post.getId());
    }

    public List<CommentResponse> getCommentsByPost(Long postId) {
        return commentRepository.findByPostId(postId).stream()
                .map(c -> new CommentResponse(c.getId(), c.getContent(), c.getMember().getId(), c.getPost().getId()))
                .collect(Collectors.toList());
    }

    public void updateComment(Long commentId, String content) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글 없음"));
        comment.update(content);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}

