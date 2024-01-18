package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> readCustomer();
    Customer readCustomer(int customerId);
    Customer updateCustomer(int customerId, Customer newCustomerValues);
    boolean deleteCustomer(int customerId);
}
