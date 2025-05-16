package practice.hyunjincrudapi.comment.controller.dto.response;

import lombok.Getter;
import practice.hyunjincrudapi.comment.entity.Comment;

@Getter
public class CommentResponse {
    private Long id;
    private String content;
    private Long memberId;
    private Long postId;

    public CommentResponse(Long id, String content, Long memberId, Long postId) {
        this.id = id;
        this.content = content;
        this.memberId = memberId;
        this.postId = postId;
    }

    public static CommentResponse from(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getContent(), comment.getMember().getId(), comment.getPost().getId());
    }
}
