package pl.gajewski.michal.java.app.bankaccount.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.gajewski.michal.java.app.bankaccount.cli.model.AccountModel;
import pl.gajewski.michal.java.app.bankaccount.dao.entity.AccountEntity;

class AccountMapperTest {

    @Test
    void fromEntity() {
        //Given
        AccountMapper accountMapper = new AccountMapper();
        AccountEntity accountEntity = new AccountEntity(
                1,
                1,
                "lisek",
                "100000000",
                null
        );
        //When
        AccountModel accountModel = accountMapper.fromEntity(accountEntity);
        //Then
        Assertions.assertAll(
            () ->  Assertions.assertEquals(accountEntity.getId(), accountModel.getId(), "id aren't equals"),
            () ->  Assertions.assertEquals(accountEntity.getNumber(), accountModel.getNumber(), "id aren't equals"),
            () ->  Assertions.assertEquals(accountEntity.getOwner(), accountModel.getOwner(), "id aren't equals"),
            () ->  Assertions.assertEquals(accountEntity.getBalance(), accountModel.getBalance(), "id aren't equals")

        );

    }

    @Test
    void fromModel() {
        //Given
        AccountMapper accountMapper = new AccountMapper();
        AccountModel accountModel = new AccountModel();
        //When
        AccountEntity accountEntity = accountMapper.fromModel(accountModel);
        //Then
        Assertions.assertAll(
                () ->  Assertions.assertEquals(accountModel.getId(),accountEntity.getId(), "id aren't equals"),
                () ->  Assertions.assertEquals(accountModel.getNumber(),accountEntity.getNumber(), "id aren't equals"),
                () ->  Assertions.assertEquals(accountModel.getOwner(),accountEntity.getOwner(), "id aren't equals"),
                () ->  Assertions.assertEquals(accountModel.getBalance(),accountEntity.getBalance(), "id aren't equals"),
                () -> Assertions.assertNull(accountEntity.getPassword(), "id aren't equals")
        );
    }
}