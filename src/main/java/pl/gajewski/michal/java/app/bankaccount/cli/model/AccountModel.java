package pl.gajewski.michal.java.app.bankaccount.cli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
    private int id;
    private int number;
    private String owner;
    private String balance;

    public AccountModel(String owner) {
        this.owner = owner;
    }
}
