package pl.gajewski.michal.java.app.bankaccount.dao;

import pl.gajewski.michal.java.app.bankaccount.cli.model.AccountModel;
import pl.gajewski.michal.java.app.bankaccount.utils.DbPropertySourceUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbAccountDao implements AccountDao {

    public static final String CONNTECTION_URL = "jdbc:h2:~/h2database/bank-account-app";
    public static final String SELECT_FROM_ACCOUNTS = "SELECT * FROM ACCOUNTS";
    public static final String INSERT_INTO_ACCOUNTS = "INSERT INTO ACCOUNTS(id,number,owner,balance) VALUES(?,?,?,?)";
    public static final String UPDATE_ACCOUNTS = "UPDATE ACCOUNTS SET number=?,balance=? WHERE id=?";
    public static final String DELETE_ACCOUNTS = "DELETE ACCOUNTS WHERE id=?";
    public static final String USER = "sa";
    public static final String PASSWORD = "sa";

    @Override
    public AccountModel create(AccountModel accountModel) {
        try (Connection connection = DriverManager.getConnection(CONNTECTION_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_ACCOUNTS)) {
            preparedStatement.setInt(1, accountModel.getId());
            preparedStatement.setInt(2, accountModel.getNumber());
            preparedStatement.setString(3, accountModel.getOwner());
            preparedStatement.setString(4, accountModel.getBalance());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountModel;
    }

    @Override
    public AccountModel read(Integer id) {
        return null;
    }

    @Override
    public AccountModel update(AccountModel accountModel) {

        try (Connection connection = DriverManager.getConnection(CONNTECTION_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNTS)) {
            preparedStatement.setInt(1, accountModel.getNumber());
            preparedStatement.setString(2, accountModel.getBalance());
            preparedStatement.setInt(3, accountModel.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountModel;
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DriverManager.getConnection(CONNTECTION_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNTS)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AccountModel> accounts() {

        String connectionURL = DbPropertySourceUtils.getProperty("db.connection.url");
        String dbUser = DbPropertySourceUtils.getProperty("db.user");
        String dbPassword = DbPropertySourceUtils.getProperty("db.password");

        List<AccountModel> accounts = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionURL, dbUser, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_ACCOUNTS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int number = resultSet.getInt("number");
                String owner = resultSet.getString("owner");
                String balance = resultSet.getString("balance");

                AccountModel accountModel = new AccountModel(id, number, owner, balance);
                accounts.add(accountModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
}