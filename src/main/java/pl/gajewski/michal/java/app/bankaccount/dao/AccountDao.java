package pl.gajewski.michal.java.app.bankaccount.dao;

import pl.gajewski.michal.java.app.bankaccount.cli.model.AccountModel;
import pl.gajewski.michal.java.app.bankaccount.exception.AccountException;

import java.util.List;

public interface AccountDao {
    List<AccountModel> accounts() throws AccountException;
    AccountModel create(AccountModel  accountModel) throws AccountException;
    AccountModel read(Integer id) throws AccountException;
    AccountModel update(AccountModel  accountModel) throws AccountException;
    void delete(Integer id) throws AccountException;
}
