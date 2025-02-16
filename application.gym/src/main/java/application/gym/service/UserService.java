package application.gym.service;

import application.gym.POJO.User;

public interface UserService {
    User createUser(User user);
    User authenticate(String email, String password);
    boolean changePassword(Long userId, String oldPassword, String newPassword);
}
