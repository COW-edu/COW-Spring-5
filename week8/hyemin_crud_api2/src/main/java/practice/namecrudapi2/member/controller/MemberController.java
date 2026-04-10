package practice.namecrudapi2.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.namecrudapi2.member.controller.dto.request.CreateMemberRequest;
import practice.namecrudapi2.member.controller.dto.request.UpdateMemberRequest;
import practice.namecrudapi2.member.controller.dto.response.MemberResponse;
import practice.namecrudapi2.member.controller.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public void signUp(@RequestBody CreateMemberRequest createMemberRequest) {
        memberService.signUp(createMemberRequest);
    }

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody UpdateMemberRequest request) {
        memberService.updateMember(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }


}
