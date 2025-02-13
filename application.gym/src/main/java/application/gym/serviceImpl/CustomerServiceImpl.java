package application.gym.serviceImpl;

import application.gym.dao.CustomerDao;
import application.gym.POJO.Customer;
import application.gym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerDao.findByEmail(email);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }
}

