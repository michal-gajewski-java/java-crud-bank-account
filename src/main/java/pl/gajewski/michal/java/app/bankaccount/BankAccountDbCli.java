package pl.gajewski.michal.java.app.bankaccount;

import pl.gajewski.michal.java.app.bankaccount.cli.controller.AccountController;
import pl.gajewski.michal.java.app.bankaccount.cli.model.AccountModel;
import pl.gajewski.michal.java.app.bankaccount.dao.DbAccountDao;
import pl.gajewski.michal.java.app.bankaccount.dao.UniqueID;
import pl.gajewski.michal.java.app.bankaccount.exception.AccountException;
import pl.gajewski.michal.java.app.bankaccount.service.AccountService;

import java.util.List;
import java.util.logging.Logger;

public class BankAccountDbCli {
    private static final Logger LOGGER = Logger.getLogger(BankAccountDbCli.class.getName());

    public static void main(String[] args) {
        UniqueID uniqueID = new UniqueID();
        DbAccountDao dbAccountDao = new DbAccountDao();
        AccountService accountService = new AccountService(dbAccountDao, uniqueID);
        AccountController accountController = new AccountController(accountService);
        try {
           List<AccountModel> accounts =  accountController.accounts();
           LOGGER.info("Lista kont: "+accounts);
        } catch (AccountException e) {
            e.printStackTrace();
        }
    }
}
