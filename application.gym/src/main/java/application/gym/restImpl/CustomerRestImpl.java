package application.gym.restImpl;

import application.gym.POJO.Customer;
import application.gym.rest.CustomerRest;
import application.gym.service.CustomerService;
import application.gym.wrapper.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerRestImpl implements CustomerRest {

    @Autowired
    private CustomerService customerService;

    @Override
    public ResponseEntity<ResponseWrapper<Customer>> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(new ResponseWrapper<>(true, "Client créé avec succès", createdCustomer));
    }

    @Override
    public ResponseEntity<ResponseWrapper<List<Customer>>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(new ResponseWrapper<>(true, "Liste des clients récupérée", customers));
    }

    @Override
    public ResponseEntity<ResponseWrapper<Customer>> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok(new ResponseWrapper<>(true, "Client trouvé", customer));
        } else {
            return ResponseEntity.ok(new ResponseWrapper<>(false, "Client non trouvé", null));
        }
    }
}
