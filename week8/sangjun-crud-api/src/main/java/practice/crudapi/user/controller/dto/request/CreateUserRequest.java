package practice.crudapi.user.controller.dto.request;

import lombok.Getter;
import practice.crudapi.user.entity.User;

@Getter
public class CreateUserRequest {
    private String username;
    private String email;
    private String password;

    public User toEntity() {
        return User.builder().username(username).email(email).password(password).build();
    }
}
