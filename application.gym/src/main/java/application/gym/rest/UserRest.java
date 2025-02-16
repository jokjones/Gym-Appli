package application.gym.rest;

import application.gym.POJO.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public interface UserRest {


    @PostMapping("/register")
    ResponseEntity<?> registerUser(@RequestBody User user);


    ResponseEntity<?> registerUser(String email, String password);

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestParam String email, @RequestParam String password);

    @PutMapping("/change-password/{userId}")
    ResponseEntity<?> changePassword(@PathVariable Long userId, @RequestParam String oldPassword, @RequestParam String newPassword);
}
