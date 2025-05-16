package practice.hyunjincrudapi.member.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import practice.hyunjincrudapi.member.entity.Member;

@Getter
@AllArgsConstructor
public class MemberResponse {
    private Long id;
    private String name;
    private String email;

    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getId(), member.getName(), member.getEmail());
    }
}
