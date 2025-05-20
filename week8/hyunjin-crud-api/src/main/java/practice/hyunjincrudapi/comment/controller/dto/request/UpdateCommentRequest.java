package practice.hyunjincrudapi.comment.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateCommentRequest {
    @NotBlank(message = "댓글 내용은 비어 있을 수 없습니다.")
    private String content;
}
