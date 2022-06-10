package com.kcbgroup.customer.service;

import com.kcbgroup.customer.exceptions.UserNotFound;
import com.kcbgroup.customer.model.CustomerModel;
import com.kcbgroup.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    CustomerRepository customerRepository;
    @Autowired

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerModel> getAll() {
       return customerRepository.findAll();
    }

    public void save(CustomerModel customerModel) {
        customerRepository.save(customerModel);
    }

    public CustomerModel update(int customerID,CustomerModel customerModel1) {
//        customerRepository.save(customerModel);
        CustomerModel customerModel = customerRepository.findById(customerID).get();
        customerModel.setGender(customerModel1.getGender());
        customerModel.setName(customerModel1.getName());
        return customerRepository.save(customerModel);


    }

    public CustomerModel getOne(int customerId) {
        Optional<CustomerModel> optionalCustomerModel = customerRepository.findById(customerId);
        if(!optionalCustomerModel.isPresent()){
            throw   new UserNotFound("not found");
        }
        else
            return customerRepository.findById(customerId).get();

    }

}
