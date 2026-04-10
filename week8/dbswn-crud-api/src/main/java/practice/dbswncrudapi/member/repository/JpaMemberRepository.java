package practice.dbswncrudapi.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.dbswncrudapi.member.entity.Member;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long id);
}