package application.gym.service;

import application.gym.POJO.User;

public interface UserService {
    User createUser(User user);
    boolean changePassword(Long userId, String oldPassword, String newPassword);
}

