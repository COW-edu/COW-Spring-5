package practice.hyunjincrudapi.post.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")

    private Long id;
    private String title;
    private String content;

    @Column(name="member_id")
    private Long memberId;

    @Builder
    public Post(String title, String content, Long memberId) {
        this.title = title;
        this.content = content;
        this.memberId = memberId;
    }

    public void update(String title, String content) {
        if(title!=null){
            this.title = title;
        }

        if(content!=null){
            this.content = content;
        }
    }

}
