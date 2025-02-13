package application.gym.dao;

import application.gym.POJO.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
