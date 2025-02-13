package application.gym.service;

import application.gym.POJO.Customer;
import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer getCustomerByEmail(String email);
    List<Customer> getAllCustomers();
}

