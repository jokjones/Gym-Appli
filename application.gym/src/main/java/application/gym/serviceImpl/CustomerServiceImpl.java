package application.gym.serviceImpl;

import application.gym.dao.CustomerDao;
import application.gym.POJO.Customer;
import application.gym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer createCustomer(Customer customer) {
        if (customer == null || customer.getEmail() == null || customer.getPhone() == null) {
            throw new IllegalArgumentException("Les informations du client sont invalides.");
        }
        return customerDao.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerDao.findById(id);
        return customer.orElse(null);
    }
}
