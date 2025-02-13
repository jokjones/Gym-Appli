package application.gym.serviceImpl;

import application.gym.dao.SubscriptionDao;
import application.gym.dao.CustomerDao;
import application.gym.dao.PackDao;
import application.gym.POJO.Subscription;
import application.gym.POJO.Customer;
import application.gym.POJO.Pack;
import application.gym.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private PackDao packDao;

    @Override
    public Subscription subscribe(Long customerId, Long packId) {
        Customer customer = customerDao.findById(customerId).orElseThrow();
        Pack pack = packDao.findById(packId).orElseThrow();

        Subscription subscription = new Subscription();
        subscription.setCustomer(customer);
        subscription.setPack(pack);
        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(LocalDate.now().plusMonths(1)); // Exemple

        return subscriptionDao.save(subscription);
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionDao.findAll();
    }
}
