package pl.gajewski.michal.java.app.bankaccount.dao.entity;

import java.util.Arrays;

public class AccountEntity {
    private int id;
    private int number;
    private String owner;
    private String balance;
    private char[] password;

    public AccountEntity(int id, int number, String owner, String balance, char[] password) {
        this.id = id;
        this.number = number;
        this.owner = owner;
        this.balance = balance;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public String getBalance() {
        return balance;
    }

    public char[] getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", number=" + number +
                ", owner='" + owner + '\'' +
                ", balance='" + balance + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
