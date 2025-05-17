package practice.crudapi.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.crudapi.user.controller.dto.request.CreateUserRequest;
import practice.crudapi.user.controller.dto.request.UpdateUserRequest;
import practice.crudapi.user.controller.dto.response.UserResponse;
import practice.crudapi.user.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public void signUp(@RequestBody CreateUserRequest createUserRequest) {
        userService.signup(createUserRequest);
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers(@RequestParam String username) {
        return userService.getUsers(username);
    }

    @PatchMapping("/users")
    public void updateUser(@RequestParam Long id, @RequestBody UpdateUserRequest updateUserRequest) {
        userService.updateUser(id, updateUserRequest);
    }

    @DeleteMapping("/users")
    public void deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
    }
}
