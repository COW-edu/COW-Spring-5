package practice.hyunjincrudapi.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.hyunjincrudapi.member.dto.request.CreateMemberRequest;
import practice.hyunjincrudapi.member.dto.request.UpdateMemberRequest;
import practice.hyunjincrudapi.member.dto.response.MemberResponse;
import practice.hyunjincrudapi.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public void signup(@RequestBody CreateMemberRequest createMemberRequest) {
        memberService.signup(createMemberRequest);
    }

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody UpdateMemberRequest updateMemberRequest) {
        memberService.updateMember(id, updateMemberRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
