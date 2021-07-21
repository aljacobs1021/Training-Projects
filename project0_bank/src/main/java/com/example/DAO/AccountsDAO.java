package com.example.DAO;

import java.sql.SQLException;
import java.util.List;
import com.example.Models.Account;
import com.example.Models.User;

public interface AccountsDAO {
    List<Account> getAllAccounts();

    Account getAccountByUser(User user);

    Account getAccountByNum(int b);

    void createAccount(Account a) throws SQLException;

    void updateAccount(Account a);

    void deposit(Account a);

    void withdraw(Account a);

    void deleteAccount(Account a);
}
