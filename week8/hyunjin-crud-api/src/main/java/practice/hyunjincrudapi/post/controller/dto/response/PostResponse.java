package practice.hyunjincrudapi.post.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import practice.hyunjincrudapi.post.entity.Post;

@Getter
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private Long memberId;

    public static PostResponse from(Post post) {
        return new PostResponse(post.getId(), post.getTitle(), post.getContent(), post.getMember().getId());
    }
}
