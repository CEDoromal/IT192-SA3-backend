package com.rijai.LocationApi.controller;

import com.rijai.LocationApi.model.Account;
import com.rijai.LocationApi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/account/{username}")
    public Account getAccount(@PathVariable String username)
    {
        return accountService.getAccount(username);
    }

    @RequestMapping(value="/add-account")
    public Account addAccount(@RequestBody Account account) { return accountService.addAccount(account); }
}
