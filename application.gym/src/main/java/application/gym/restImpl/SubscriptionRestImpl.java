package application.gym.restImpl;

import application.gym.POJO.Subscription;
import application.gym.rest.SubscriptionRest;
import application.gym.service.SubscriptionService;
import application.gym.wrapper.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription")
public class SubscriptionRestImpl implements SubscriptionRest {

    private final SubscriptionService subscriptionService;

    public SubscriptionRestImpl(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @Override
    @PostMapping("/subscribe")
    public ResponseEntity<ResponseWrapper<Subscription>> subscribe(@RequestParam Long customerId, @RequestParam Long packId) {
        Subscription subscription = subscriptionService.subscribe(customerId, packId);
        return ResponseEntity.ok(new ResponseWrapper<>(true, "Abonnement créé avec succès", subscription));
    }

    @Override
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ResponseWrapper<List<Subscription>>> getSubscriptionsByCustomer(@PathVariable Long customerId) {
        List<Subscription> subscriptions = subscriptionService.getSubscriptionsByCustomer(customerId);
        return ResponseEntity.ok(new ResponseWrapper<>(true, "Abonnements du client récupérés", subscriptions));
    }
}
