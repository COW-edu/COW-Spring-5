package practice.hyunjincrudapi.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.hyunjincrudapi.member.controller.dto.request.CreateMemberRequest;
import practice.hyunjincrudapi.member.controller.dto.request.UpdateMemberRequest;
import practice.hyunjincrudapi.member.controller.dto.response.MemberResponse;
import practice.hyunjincrudapi.member.entity.Member;
import practice.hyunjincrudapi.member.repository.JpaMemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final JpaMemberRepository jpaMemberRepository;

    public void signup(CreateMemberRequest createMemberRequest) {
        Member member = createMemberRequest.toEntity();
        jpaMemberRepository.save(member); //member에 대한 정보가 db에 저장됨
    }

    public MemberResponse getMember(Long id){
        Member member = jpaMemberRepository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException(("존재하지 않는 멤버입니다.")));

        return MemberResponse.from(member);
    }

    public void updateMember(Long id, UpdateMemberRequest updateMemberRequest) {
        Member member= jpaMemberRepository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회원입니다."));

        member.update(updateMemberRequest.getName(), updateMemberRequest.getEmail());
    }

    public void deleteMember(Long id) {
        Member member = jpaMemberRepository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회원입니다."));

        jpaMemberRepository.delete(member);
    }
}
