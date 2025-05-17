package practice.hyunjincrudapi.member.controller.dto.request;

import lombok.Getter;

@Getter
public class UpdateMemberRequest {
    private String name;
    private String email;
}
