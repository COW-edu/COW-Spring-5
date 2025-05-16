package practice.hyunjincrudapi.comment.controller.dto.request;

import lombok.Getter;

@Getter
public class CreateCommentRequest {
    private String content;
    private Long memberId;
    private Long postId;
}
