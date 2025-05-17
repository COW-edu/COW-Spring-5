package practice.hyunjincrudapi.post.controller.dto.response;

import lombok.Getter;
import practice.hyunjincrudapi.post.entity.Post;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private Long memberId;

    public PostResponse(Long id, String title, String content, Long memberId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
    }

    public static PostResponse from(Post post) {
        return new PostResponse(post.getId(), post.getTitle(), post.getContent(), post.getMember().getId());
    }
}
