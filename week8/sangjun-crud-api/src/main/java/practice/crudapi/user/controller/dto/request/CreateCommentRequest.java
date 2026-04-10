package practice.crudapi.user.controller.dto.request;

import lombok.Getter;
import practice.crudapi.user.entity.Comment;
import practice.crudapi.user.entity.Post;
import practice.crudapi.user.entity.User;

@Getter
public class CreateCommentRequest {
    private String content;
    private Long userId;

    public Comment toEntity(User user, Post post) {
        return Comment.builder()
                .content(content)
                .user(user)
                .post(post)
                .build();
    }
}
