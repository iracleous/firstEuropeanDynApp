package gr.codehub.firsteuropeandynapp.controller;

import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.service.CustomerService;
import gr.codehub.firsteuropeandynapp.service.CustomerServiceImpl;
import gr.codehub.firsteuropeandynapp.service.GeneralService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private GeneralService<Customer,Integer> customerService ;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        //save customer
        return customerService.create(customer);
     }
    @GetMapping
    public List<Customer> getCustomer(){
        //get all customer
        return customerService.read();
    }
    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        //get all customer
        return customerService.read(customerId);
    }

    @PutMapping("{customerId}")
    public Customer updateCustomer(@PathVariable int customerId,@RequestBody Customer newCustomerValues){
        //get all customer
        return customerService.update(customerId, newCustomerValues);
    }

    @DeleteMapping ("{customerId}")
    public boolean udeleteCustomer(@PathVariable int customerId){
        //get all customer
        return customerService.delete(customerId);
    }

}
