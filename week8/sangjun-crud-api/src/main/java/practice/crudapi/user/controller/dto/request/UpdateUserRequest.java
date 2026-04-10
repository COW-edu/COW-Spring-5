package practice.crudapi.user.controller.dto.request;

import lombok.Getter;
import practice.crudapi.user.entity.User;

@Getter
public class UpdateUserRequest {
    private String username;
    private String email;
}
