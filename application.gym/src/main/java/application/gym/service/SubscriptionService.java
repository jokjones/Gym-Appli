package application.gym.service;

import application.gym.POJO.Subscription;
import java.util.List;

public interface SubscriptionService {
    Subscription subscribe(Long customerId, Long packId);
    List<Subscription> getSubscriptionsByCustomer(Long customerId);
}
