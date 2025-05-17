package practice.crudapi.user.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommentResponse {
    private Long id;
    private String content;
    private Long userId;
    private Long postId;
} 