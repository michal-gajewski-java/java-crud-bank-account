package pl.gajewski.michal.java.app.bankaccount.exception;

public class AccountNotFoundException extends AccountException {
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
