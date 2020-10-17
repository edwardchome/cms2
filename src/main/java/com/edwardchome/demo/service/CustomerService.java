package com.edwardchome.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import com.edwardchome.demo.dao.CustomerDao;
import com.edwardchome.demo.exception.CustomerNotFoundException;
import com.edwardchome.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
    
    private List<Customer> customerList = new CopyOnWriteArrayList<Customer>();
    private int customerIdCount = 1;

    public Customer addCustomer(Customer customer){

        return customerDao.save(customer);
    }

    public List<Customer> getCustomers(){
        return  customerDao.findAll();
        /*return customerList;*/
    }

     @GetMapping(value="/{customerid}")
    public Customer getCustomer(@PathVariable("customerid") int customerid){

        Optional<Customer> optionalCustomer = customerDao.findById(customerid);

        if(!optionalCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer record not found...");
        }

        return optionalCustomer.get();

    }

    public Customer updateCustomer(int customerid, Customer customer){

        customer.setCustomerid(customerid);

        return customerDao.save(customer);
    }


    public void deleteCustomer(int customerid){

         customerDao.deleteById(customerid);

    }

}
