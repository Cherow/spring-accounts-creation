package com.kcbgroup.customer.controller;

import com.kcbgroup.customer.exceptions.UserNotFound;
import com.kcbgroup.customer.model.AccountModel;
import com.kcbgroup.customer.model.CustomerModel;
import com.kcbgroup.customer.repository.CustomerRepository;
import com.kcbgroup.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping

public class CustomerController {

    CustomerService customerService;
    @Autowired
    public CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired


    @GetMapping("/get-customers/")
    //getting all customer
    public List<CustomerModel> getAll(){
        return customerService.getAll();
    }
    @GetMapping(path = "{customerID}")
    public  CustomerModel getOne(@PathVariable("customerID") int customerID){
        return customerService.getOne(customerID);
    }

    @PostMapping

    public void createCustomer(@RequestBody CustomerModel customerModel){
        customerService.save(customerModel);
    }

    @PutMapping(path = "{customerID}")

    public CustomerModel  updateCustomer(@PathVariable("customerID") int customerID,
                                @RequestBody CustomerModel customerModel){
       return customerService.update(customerID,customerModel);
    }

    @GetMapping("customer-accounts/{id}")
    public List<AccountModel> returnAllAccount(@PathVariable int id){
        Optional<CustomerModel> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()){
            return optionalCustomer.get().getAccountModel();
        } else {
            throw new UserNotFound("id -> " + id);
        }
    }


}
