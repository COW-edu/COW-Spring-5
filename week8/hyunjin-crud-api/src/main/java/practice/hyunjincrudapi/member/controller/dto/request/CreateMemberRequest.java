package practice.hyunjincrudapi.member.controller.dto.request;

import lombok.Getter;
import practice.hyunjincrudapi.member.entity.Member;
@Getter
public class CreateMemberRequest {
    private String name;
    private String password;
    private String email;

    public Member toEntity(){ //toEntity 메서드를 통해 새로운 객체를 생성하게 됨
        return Member.builder().name(name).password(password).email(email).build();
    }
}
