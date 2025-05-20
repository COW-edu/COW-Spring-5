package practice.hyunjincrudapi.comment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import practice.hyunjincrudapi.comment.entity.Comment;

@Getter
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private String content;
    private Long memberId;
    private Long postId;

    public static CommentResponse from(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getContent(), comment.getMember().getId(), comment.getPost().getId());
    }
}
