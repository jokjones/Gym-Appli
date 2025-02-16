package application.gym.restImpl;

import application.gym.POJO.User;
import application.gym.JWT.JwtUtil;
import application.gym.rest.UserRest;
import application.gym.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserRestImpl implements UserRest {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserRestImpl(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @Override

    public ResponseEntity<?> registerUser(String email, String password) {
        return null;
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        User user = userService.authenticate(email, password);

        if (user != null) {
            String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @Override
    @PutMapping("/change-password/{userId}")
    public ResponseEntity<?> changePassword(@PathVariable Long userId, @RequestParam String oldPassword, @RequestParam String newPassword) {
        boolean success = userService.changePassword(userId, oldPassword, newPassword);
        return success ? ResponseEntity.ok("Password changed successfully") : ResponseEntity.status(400).body("Incorrect old password");
    }




}
