package practice.namecrudapi2.member.controller.dto.request;


import lombok.Getter;

@Getter
public class UpdateMemberRequest {
    private String username;
    private String email;
    private String password;
}
