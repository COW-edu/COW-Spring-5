package practice.hyunjincrudapi.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import practice.hyunjincrudapi.comment.entity.Comment;

import java.util.List;


public interface JpaCommentRepository extends JpaRepository<Comment, Long> {
    @Query("""
        SELECT c FROM Comment c
        JOIN FETCH c.member
        JOIN FETCH c.post
        WHERE c.post.id = :postId
    """)
    List<Comment> findByPostId(@Param("postId")Long postId);
}
