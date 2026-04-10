package practice.dbswncrudapi.member.controller.dto.request;

import lombok.Getter;
import practice.dbswncrudapi.member.entity.Member;

@Getter
public class MemberRequest {
    private String username;
    private String email;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();
    }
}

