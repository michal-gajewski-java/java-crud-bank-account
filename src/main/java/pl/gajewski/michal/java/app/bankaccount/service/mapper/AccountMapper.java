package pl.gajewski.michal.java.app.bankaccount.service.mapper;

import pl.gajewski.michal.java.app.bankaccount.cli.model.AccountModel;
import pl.gajewski.michal.java.app.bankaccount.dao.entity.AccountEntity;

public class AccountMapper {
    public AccountModel fromEntity(AccountEntity accountEntity) {
        AccountModel accountModel = new AccountModel();
        accountModel.setId(accountEntity.getId());
        accountModel.setNumber(accountEntity.getNumber());
        accountModel.setOwner(accountEntity.getOwner());
        accountModel.setBalance(accountEntity.getBalance());
        return accountModel;
    }

    public AccountEntity fromModel(AccountModel accountModel) {
        return new AccountEntity(
                accountModel.getId(),
                accountModel.getNumber(),
                accountModel.getOwner(),
                accountModel.getBalance(),
                null);
    }
}
