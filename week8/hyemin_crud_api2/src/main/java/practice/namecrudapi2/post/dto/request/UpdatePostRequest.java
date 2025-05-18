package practice.namecrudapi2.post.dto.request;

import lombok.Getter;

@Getter
public class UpdatePostRequest {
    private String title;
    private String content;
}
