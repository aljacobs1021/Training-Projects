package com.example.DAO;

import java.sql.SQLException;
import java.util.List;
import com.example.Models.Account;

public interface AccountsDAO {
    List<Account> getAllAccounts();

    Account getAccountByNumber(int accNum);

    void createAccount(Account a) throws SQLException;

    void updateAccount(Account a);

    void deleteAccount(Account a);
}
