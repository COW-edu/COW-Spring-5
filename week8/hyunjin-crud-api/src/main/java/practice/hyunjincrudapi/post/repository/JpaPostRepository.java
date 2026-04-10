package practice.hyunjincrudapi.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.hyunjincrudapi.post.entity.Post;

public interface JpaPostRepository extends JpaRepository<Post, Long> {

}
