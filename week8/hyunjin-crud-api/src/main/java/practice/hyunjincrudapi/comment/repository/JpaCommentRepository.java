package practice.hyunjincrudapi.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.hyunjincrudapi.comment.entity.Comment;

import java.util.List;


public interface JpaCommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
