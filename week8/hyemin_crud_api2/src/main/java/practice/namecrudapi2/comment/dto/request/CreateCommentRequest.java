package practice.namecrudapi2.comment.dto.request;

import lombok.Getter;
import practice.namecrudapi2.comment.entity.Comment;

@Getter
public class CreateCommentRequest {
    private String content;
    private Long userId;

    public Comment toEntity(Long postId) {
        return Comment.builder()
                .content(content)
                .userId(userId)
                .postId(postId)
                .build();
    }
}

