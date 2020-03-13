package pl.gajewski.michal.java.app.bankaccount.cli.controller;

import pl.gajewski.michal.java.app.bankaccount.cli.model.AccountModel;
import pl.gajewski.michal.java.app.bankaccount.exception.AccountException;
import pl.gajewski.michal.java.app.bankaccount.service.AccountService;

import java.util.List;

public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public List<AccountModel> accounts() throws AccountException {
        return accountService.accounts();
    }

    //Create
    public AccountModel createAccount(AccountModel accountModel) throws AccountException {
        return accountService.create(accountModel);
    }

    //Read
    public AccountModel readAccount(int accountId) throws AccountException {
        return accountService.read(accountId);
    }

    //Update
    public AccountModel updateAccount(AccountModel accountModel) throws AccountException {
        return accountService.update(accountModel);
    }

    //Delete
    public void deleteAccount(AccountModel accountModel) throws AccountException {
        accountService.delete(accountModel);
    }
}
