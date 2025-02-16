package application.gym.dao;

import application.gym.POJO.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionDao extends JpaRepository<Subscription, Long> {
    List<Subscription> findByCustomerId(Long customerId);
}
