package practice.namecrudapi2.member.controller.dto.request;

import lombok.Getter;
import practice.namecrudapi2.member.controller.entity.Member;

@Getter
public class CreateMemberRequest {

    private String username;
    private String email;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .name(username)
                .email(email)
                .password(password)
                .build();
    }
}