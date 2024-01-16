package gr.codehub.firsteuropeandynapp.controller;

import gr.codehub.firsteuropeandynapp.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class DynController {
    @GetMapping("hello")
    public String getGreeting(){
        return "hello";
    }
    @GetMapping("/value/")
    public int getValue(){
        return 1;
    }
    @PostMapping
    public String doTask(){
        return "ok";
    }
    @GetMapping
    public void doVoid(){
    }
    @GetMapping("/customer")
    public Customer getACustomer(){
        var customer = new Customer();
        customer.setName("George");
        customer.setEmail("george@mail.com");
        return customer;
    }
}
