package application.gym.serviceImpl;

import application.gym.POJO.Customer;
import application.gym.POJO.Pack;
import application.gym.POJO.Subscription;
import application.gym.dao.CustomerDao;
import application.gym.dao.PackDao;
import application.gym.dao.SubscriptionDao;
import application.gym.service.SubscriptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionDao subscriptionDao;
    private final CustomerDao customerDao;
    private final PackDao packDao;

    public SubscriptionServiceImpl(SubscriptionDao subscriptionDao, CustomerDao customerDao, PackDao packDao) {
        this.subscriptionDao = subscriptionDao;
        this.customerDao = customerDao;
        this.packDao = packDao;
    }

    @Override
    @Transactional
    public Subscription subscribe(Long customerId, Long packId) {
        Optional<Customer> customerOpt = customerDao.findById(customerId);
        Optional<Pack> packOpt = packDao.findById(packId);

        if (customerOpt.isEmpty() || packOpt.isEmpty()) {
            throw new IllegalArgumentException("Client ou Pack non trouvé.");
        }

        Subscription subscription = new Subscription();
        subscription.setCustomer(customerOpt.get());
        subscription.setPack(packOpt.get());
        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(LocalDate.now().plusMonths(1));

        return subscriptionDao.save(subscription);
    }

    @Override
    public List<Subscription> getSubscriptionsByCustomer(Long customerId) {
        return subscriptionDao.findByCustomerId(customerId);
    }
}
