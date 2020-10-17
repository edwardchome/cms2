package com.edwardchome.demo.api;

import com.edwardchome.demo.model.Customer;
import com.edwardchome.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    @GetMapping(value="/{customerid}")
    public  Customer getCustomer(@PathVariable("customerid") int customerid){
        return customerService.getCustomer(customerid);
    }

    @PutMapping(value="/{customerid}")
    public Customer updateCustomer(@PathVariable("customerid") int customerid, @RequestBody Customer customer){
       return customerService.updateCustomer(customerid, customer);
    }

    @DeleteMapping(value="/{customerid}")
    public void deleteCustomer(@PathVariable("customerid") int customerid){
        customerService.deleteCustomer(customerid);
    }
}
