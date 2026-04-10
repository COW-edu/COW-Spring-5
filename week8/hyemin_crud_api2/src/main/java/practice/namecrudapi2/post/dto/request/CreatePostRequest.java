package practice.namecrudapi2.post.dto.request;

import lombok.Getter;
import practice.namecrudapi2.post.entity.Post;

@Getter
public class CreatePostRequest {
    private String title;
    private String content;
    private Long userId;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .userId(userId)
                .build();
    }
}
