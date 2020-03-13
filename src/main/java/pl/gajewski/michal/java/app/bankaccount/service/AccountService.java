package pl.gajewski.michal.java.app.bankaccount.service;

import pl.gajewski.michal.java.app.bankaccount.cli.model.AccountModel;
import pl.gajewski.michal.java.app.bankaccount.dao.AccountDao;
import pl.gajewski.michal.java.app.bankaccount.dao.UniqueID;
import pl.gajewski.michal.java.app.bankaccount.exception.AccountException;

import java.util.List;

public class AccountService {
    private UniqueID uniqueID;
    private AccountDao accountDao;

    public AccountService( AccountDao accountDao, UniqueID uniqueID) {
        this.uniqueID = uniqueID;
        this.accountDao = accountDao;
    }

    public List<AccountModel> accounts() throws AccountException{
        return accountDao.accounts();
    }

    //Create
    public AccountModel create(AccountModel accountModel) throws AccountException{
       return accountDao.create(accountModel);
    }

    //Read
    public AccountModel read(int accountId) throws AccountException {
        return accountDao.read(accountId);
    }

    //Update
    public AccountModel update(AccountModel accountModel) throws AccountException {
       return accountDao.update(accountModel);
    }

    //Delete
    public void delete(AccountModel accountModel) throws AccountException {
        accountDao.delete(accountModel.getId());
    }
}
