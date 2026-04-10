package practice.namecrudapi2.member.controller.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.namecrudapi2.member.controller.dto.request.CreateMemberRequest;
import practice.namecrudapi2.member.controller.dto.request.UpdateMemberRequest;
import practice.namecrudapi2.member.controller.dto.response.MemberResponse;
import practice.namecrudapi2.member.controller.entity.Member;
import practice.namecrudapi2.member.controller.repository.MemberJpaRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public void signUp(CreateMemberRequest createMemberRequest) {
        Member member = createMemberRequest.toEntity();
        memberJpaRepository.save(member);
    }

    public MemberResponse getMember(Long id) {
        Member member = memberJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return new MemberResponse(member);
    }

    public void updateMember(Long id, UpdateMemberRequest request) {
        Member member = memberJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        member.updateProfile(request.getUsername(), request.getEmail(), request.getPassword());
    }

    public void deleteMember(Long id) {
        Member member = memberJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        memberJpaRepository.delete(member);
    }



}
