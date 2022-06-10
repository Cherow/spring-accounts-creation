package com.kcbgroup.customer.controller;

import com.kcbgroup.customer.exceptions.UserNotFound;
import com.kcbgroup.customer.model.AccountModel;
import com.kcbgroup.customer.model.CustomerModel;
import com.kcbgroup.customer.repository.AccountRepository;
import com.kcbgroup.customer.repository.CustomerRepository;
import com.kcbgroup.customer.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AccountController {

    AccountService accountService;
    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public AccountRepository accountRepository;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/")
    public List<AccountModel> getAllAccounts(){
        return  accountService.getAll();
    }

    @PostMapping("/post/account/{id}/")

    public ResponseEntity<AccountModel> postAccount(@RequestBody AccountModel accountModel,
                                                    @PathVariable int id){

        Optional<CustomerModel> customerOptional = customerRepository.findById(id);
        URI location;
        if (customerOptional.isPresent()){
            CustomerModel customerModel = customerOptional.get();
            accountModel.setCustomerModel(customerModel);
            AccountModel newAccount = accountRepository.save(accountModel);

            location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{id}")
                    .buildAndExpand(newAccount.getAccountNumber())
                    .toUri();


        } else{
            throw new UserNotFound("id -> " + id);
        }
        return ResponseEntity.created(location).build();
    }



}
