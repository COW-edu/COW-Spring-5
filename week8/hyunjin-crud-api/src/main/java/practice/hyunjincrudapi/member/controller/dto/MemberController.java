package practice.hyunjincrudapi.member.controller.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.hyunjincrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.hyunjincrudapi.member.controller.dto.request.UpdateMemberRequest;
import practice.hyunjincrudapi.member.controller.dto.response.MemberResponse;
import practice.hyunjincrudapi.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public void signup(@RequestBody CreateMemberRequest createMemberRequest) {
        memberService.signup(createMemberRequest);
    }

    @GetMapping("/members/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PutMapping("/members/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody UpdateMemberRequest updateMemberRequest) {
        memberService.updateMember(id, updateMemberRequest);
    }

    @DeleteMapping("/members/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
