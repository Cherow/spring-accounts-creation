package com.kcbgroup.customer.service;

import com.kcbgroup.customer.model.AccountModel;
import com.kcbgroup.customer.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AccountService {
    AccountRepository accountRepository;
    @Autowired

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountModel> getAll() {
        return accountRepository.findAll();
    }

    public void postAccount(AccountModel accountModel) {
        accountRepository.save(accountModel);
    }
}
