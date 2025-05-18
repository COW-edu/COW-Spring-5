package practice.namecrudapi2.member.controller.dto.response;

import lombok.Getter;
import practice.namecrudapi2.member.controller.entity.Member;

@Getter
public class MemberResponse {
    private Long id;
    private String username; // API 명세에 맞게 필드명 변경
    private String email;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.username = member.getName(); // Member 엔티티의 name을 username으로 매핑
        this.email = member.getEmail();
    }
}
