package practice.namecrudapi2.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.namecrudapi2.post.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}

