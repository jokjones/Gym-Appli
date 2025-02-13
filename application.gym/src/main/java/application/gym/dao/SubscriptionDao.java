package application.gym.dao;

import application.gym.POJO.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionDao extends JpaRepository<Subscription, Long> {}
