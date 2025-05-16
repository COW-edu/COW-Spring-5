package practice.hyunjincrudapi.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.hyunjincrudapi.member.entity.Member;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {

}
