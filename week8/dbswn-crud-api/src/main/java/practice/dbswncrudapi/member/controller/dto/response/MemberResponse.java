package practice.dbswncrudapi.member.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import practice.dbswncrudapi.member.entity.Member;

@Getter
public class MemberResponse {
    private Long id;
    private String username;
    private String email;

    @Builder
    public MemberResponse(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public static MemberResponse from(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .username(member.getUsername())
                .email(member.getEmail())
                .build();
    }
}
