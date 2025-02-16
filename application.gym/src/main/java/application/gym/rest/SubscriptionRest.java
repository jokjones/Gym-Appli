package application.gym.rest;

import application.gym.POJO.Subscription;
import application.gym.wrapper.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SubscriptionRest {
    @PostMapping("/subscribe")
    ResponseEntity<ResponseWrapper<Subscription>> subscribe(@RequestParam Long customerId, @RequestParam Long packId);

    @GetMapping("/customer/{customerId}")
    ResponseEntity<ResponseWrapper<List<Subscription>>> getSubscriptionsByCustomer(@PathVariable Long customerId);
}
