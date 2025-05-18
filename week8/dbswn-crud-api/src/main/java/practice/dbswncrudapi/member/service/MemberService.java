package practice.dbswncrudapi.member.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.dbswncrudapi.member.controller.dto.request.MemberRequest;
import practice.dbswncrudapi.member.controller.dto.response.MemberResponse;
import practice.dbswncrudapi.member.entity.Member;
import practice.dbswncrudapi.member.repository.JpaMemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final JpaMemberRepository jpaMemberRepository;

    public void signUp(MemberRequest memberRequest) {
        Member member = memberRequest.toEntity();
        jpaMemberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public MemberResponse getMember(Long id) {
        Member member = jpaMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));
        return MemberResponse.from(member);
    }

    public void updateMember(Long id, MemberRequest request) {
        Member member = jpaMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));
        member.update(request.getUsername(), request.getEmail(), request.getPassword());
    }

    public void deleteMember(Long id) {
        Member member = jpaMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));
        jpaMemberRepository.delete(member);
    }
}
