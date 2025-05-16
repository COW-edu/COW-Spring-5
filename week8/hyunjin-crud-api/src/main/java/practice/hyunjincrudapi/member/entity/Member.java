package practice.hyunjincrudapi.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String password;
    @Column(unique = true, nullable = false) //unique=true -> unique한 값으로 지정
    private String email;

    @Builder
    public Member(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void update(String name, String email){
        if(name!=null){
            this.name = name;
        }
        if(email!=null){
            this.email = email;
        }
    }
}
