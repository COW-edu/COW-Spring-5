package practice.crudapi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.crudapi.user.entity.Comment;
import practice.crudapi.user.entity.Post;
import practice.crudapi.user.entity.User;

import java.util.List;

public interface JpaCommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
