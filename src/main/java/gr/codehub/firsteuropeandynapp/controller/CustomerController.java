package gr.codehub.firsteuropeandynapp.controller;

import gr.codehub.firsteuropeandynapp.exceptions.EntityException;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.service.CustomerService;
import gr.codehub.firsteuropeandynapp.service.CustomerServiceImpl;
import gr.codehub.firsteuropeandynapp.service.GeneralService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) throws EntityException {
        return customerService.create(customer);
    }

    @GetMapping
    public List<Customer> getCustomer() {
        return customerService.read();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable long customerId) {
        return customerService.read(customerId);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable long customerId, @RequestBody Customer newCustomer) {
        return customerService.update(customerId, newCustomer);
    }

    @DeleteMapping("/{customerId}")
    public Customer deleteCustomer(@PathVariable long customerId) {
        return customerService.delete(customerId);
    }

}
