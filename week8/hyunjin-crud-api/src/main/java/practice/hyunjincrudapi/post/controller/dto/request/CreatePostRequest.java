package practice.hyunjincrudapi.post.controller.dto.request;

import lombok.Getter;
import practice.hyunjincrudapi.post.entity.Post;

@Getter
public class CreatePostRequest {
    private String title;
    private String content;
    private Long memberId;

    public Post toEntity() {return Post.builder().title(title).content(content).memberId(memberId).build();}
}
