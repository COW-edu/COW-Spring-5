package practice.crudapi.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.crudapi.user.controller.dto.request.CreateUserRequest;
import practice.crudapi.user.controller.dto.request.UpdateUserRequest;
import practice.crudapi.user.controller.dto.response.UserResponse;
import practice.crudapi.user.entity.User;
import practice.crudapi.user.repository.JpaUserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final JpaUserRepository userRepository;

    public void signup(CreateUserRequest createUserRequest) {
        User user = createUserRequest.toEntity();
        userRepository.save(user);
    }

    public List<UserResponse> getUsers(String username) {
        List<User> users = userRepository.findByUsername(username);
        return users.stream()
                .map(user -> new UserResponse(user.getId(), user.getUsername(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public void updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.updateProfile(request.getUsername(), request.getEmail());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
