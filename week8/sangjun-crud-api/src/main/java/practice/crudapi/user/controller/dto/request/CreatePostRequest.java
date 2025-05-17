package practice.crudapi.user.controller.dto.request;

import lombok.Getter;
import practice.crudapi.user.entity.Post;
import practice.crudapi.user.entity.User;

@Getter
public class CreatePostRequest {
    private String title;
    private String content;
    private Long userId;

    public Post toEntity(User user) {
        return Post.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }
}
