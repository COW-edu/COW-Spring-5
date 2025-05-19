package practice.hyunjincrudapi.comment.controller.dto.request;

import lombok.Getter;
import practice.hyunjincrudapi.comment.entity.Comment;
import practice.hyunjincrudapi.member.entity.Member;
import practice.hyunjincrudapi.post.entity.Post;

@Getter
public class CreateCommentRequest {
    private String content;
    private Long memberId;
    private Long postId;

    public Comment toEntity(Member member, Post post) {
        return Comment.builder()
                .content(content)
                .member(member)
                .post(post)
                .build();
    }
}
