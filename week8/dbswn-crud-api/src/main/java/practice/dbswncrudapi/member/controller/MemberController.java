package practice.dbswncrudapi.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.dbswncrudapi.member.controller.dto.request.MemberRequest;
import practice.dbswncrudapi.member.controller.dto.response.MemberResponse;
import practice.dbswncrudapi.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void signUp(@RequestBody MemberRequest memberRequest) {
        memberService.signUp(memberRequest);
    }

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody MemberRequest memberRequest) {
        memberService.updateMember(id, memberRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}


