package practice.namecrudapi2.member.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.namecrudapi2.member.controller.entity.Member;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long id);
}
