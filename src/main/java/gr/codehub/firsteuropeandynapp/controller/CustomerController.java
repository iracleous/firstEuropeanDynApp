package gr.codehub.firsteuropeandynapp.controller;

import gr.codehub.firsteuropeandynapp.customexceptions.EntityException;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.service.CustomerService;
import gr.codehub.firsteuropeandynapp.service.CustomerServiceImpl;
import gr.codehub.firsteuropeandynapp.service.GeneralService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private GeneralService<Customer,Long> customerService ;
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) throws EntityException {
        //save customer
        return customerService.create(customer);
     }
    @GetMapping
    public List<Customer> getCustomer(){
        //get all customer
        return customerService.read();
    }
    @GetMapping("{customerId}")
    public Optional<Customer> getCustomer(@PathVariable long customerId){
        //get all customer
        return customerService.read(customerId);
    }

    @PutMapping("{customerId}")
    public  Optional<Customer> updateCustomer(@PathVariable long customerId,@RequestBody Customer newCustomerValues){
        //get all customer
        return customerService.update(customerId, newCustomerValues);
    }

    @DeleteMapping ("{customerId}")
    public boolean udeleteCustomer(@PathVariable long customerId){
        //get all customer
        return customerService.delete(customerId);
    }

}
