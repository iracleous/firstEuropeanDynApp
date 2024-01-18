package gr.codehub.firsteuropeandynapp.controller;

import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        //save customer
        return null;
    }
    @GetMapping
    public List<Customer> getCustomer(){
        //get all customer
        return null;
    }
    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        //get all customer
        return null;
    }

    @PutMapping("{customerId}")
    public Customer updateCustomer(@PathVariable int customerId,@RequestBody Customer newCustomerValues){
        //get all customer
        return null;
    }

    @DeleteMapping ("{customerId}")
    public boolean udeleteCustomer(@PathVariable int customerId){
        //get all customer
        return false;
    }

}
