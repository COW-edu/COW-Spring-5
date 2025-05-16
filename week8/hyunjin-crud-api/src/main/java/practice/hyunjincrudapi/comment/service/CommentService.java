package practice.hyunjincrudapi.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.hyunjincrudapi.comment.controller.dto.request.CreateCommentRequest;
import practice.hyunjincrudapi.comment.controller.dto.request.UpdateCommentRequest;
import practice.hyunjincrudapi.comment.controller.dto.response.CommentResponse;
import practice.hyunjincrudapi.comment.entity.Comment;
import practice.hyunjincrudapi.comment.repository.JpaCommentRepository;
import practice.hyunjincrudapi.member.entity.Member;
import practice.hyunjincrudapi.member.repository.JpaMemberRepository;
import practice.hyunjincrudapi.post.entity.Post;
import practice.hyunjincrudapi.post.repository.JpaPostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final JpaCommentRepository commentRepository;
    private final JpaMemberRepository memberRepository;
    private final JpaPostRepository postRepository;

    public void createComment(CreateCommentRequest request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        Comment comment = Comment.builder()
                .content(request.getContent())
                .member(member)
                .post(post)
                .build();

        commentRepository.save(comment);
    }

    public List<CommentResponse> getCommentsByPost(Long postId){
        return commentRepository.findByPostId(postId).stream().map(CommentResponse::from).toList();
    }

    public void updateComment(Long commentId, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new IllegalArgumentException(("존재하지 않는 댓글입니다.")));
        comment.updateContent(request.getContent());
    }

    public void deleteComment(Long commentId){
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new IllegalArgumentException(("존재하지 않는 댓글입니다.")));
        commentRepository.delete(comment);
    }
}
