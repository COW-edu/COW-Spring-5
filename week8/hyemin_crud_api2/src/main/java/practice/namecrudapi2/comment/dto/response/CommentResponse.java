package practice.namecrudapi2.comment.dto.response;

import lombok.Getter;
import practice.namecrudapi2.comment.entity.Comment;

@Getter
public class CommentResponse {
    private Long id;
    private String content;
    private Long userId;
    private Long postId;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userId = comment.getUserId();
        this.postId = comment.getPostId();
    }
}

