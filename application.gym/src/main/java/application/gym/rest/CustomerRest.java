package application.gym.rest;

import application.gym.POJO.Customer;
import application.gym.wrapper.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CustomerRest {
    @PostMapping("/create")
    ResponseEntity<ResponseWrapper<Customer>> createCustomer(@RequestBody Customer customer);

    @GetMapping("/all")
    ResponseEntity<ResponseWrapper<List<Customer>>> getAllCustomers();

    @GetMapping("/{id}")
    ResponseEntity<ResponseWrapper<Customer>> getCustomerById(@PathVariable Long id);
}
