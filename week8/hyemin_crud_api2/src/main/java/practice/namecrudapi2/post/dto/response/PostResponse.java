package practice.namecrudapi2.post.dto.response;

import lombok.Getter;
import practice.namecrudapi2.post.entity.Post;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private Long userId;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.userId = post.getUserId();
    }
}

