package com.rijai.LocationApi.service;

import com.rijai.LocationApi.model.Account;
import com.rijai.LocationApi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(String username)
    {
        Optional<Account> account = accountRepository.findById(username);
        if(account.isPresent()) {
            return account.get();
        }
        else
            return null;
    }
}
