package com.example.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.Models.Account;
import com.example.Models.User;
import com.example.Utils.ConnectionUtil;

public class AccountsDB implements AccountsDAO {

    ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

    @Override
    public List<Account> getAllAccounts() {
        List<Account> aList = new ArrayList<Account>();

        try {
            Connection con = conUtil.getConnection();
            String sql = "SELECT * FROM accounts";

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                aList.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getDouble(6), rs.getString(7)));
            }

            return aList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Account getAccountByUser(User u) {
        Account a = new Account();

        try {
            Connection con = conUtil.getConnection();

            String sql = "SELECT * FROM accounts WHERE accounts.username = '" + u.getUsername() + "'";

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                a.setAccNum(rs.getInt(1));
                a.setUser(rs.getString(5));
                a.setBal(rs.getDouble(6));
                a.setType(rs.getString(7));
            }
            return a;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void createAccount(Account a) throws SQLException {
        Connection con = conUtil.getConnection();
        String sql = "INSERT INTO accounts(first_name, last_name, email, username, balance, type) values"
                + "(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, a.getFirst());
        ps.setString(2, a.getLast());
        ps.setString(3, a.getEmail());
        ps.setString(4, a.getUser());
        ps.setDouble(5, a.getBal());
        ps.setString(6, a.getType());

        ps.execute();

        sql = "SELECT MAX(account_num) FROM accounts WHERE username = '" + a.getUser() + "'";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(sql);

        rs.next();
        a.setAccNum(rs.getInt(1));

    }

    @Override
    public void updateAccount(Account a) {
        try {
            Connection con = conUtil.getConnection();
            String sql = "UPDATE customers SET first_name = ?, last_name = ?, username = ?, email = ?, balance = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(2, a.getFirst());
            ps.setString(3, a.getLast());
            ps.setString(4, a.getUser());
            ps.setString(5, a.getEmail());
            ps.setDouble(6, a.getBal());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteAccount(Account a) {
        try {

            Connection con = conUtil.getConnection();
            String sql = "DELETE FROM customers WHERE customers.username = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(3, a.getUser());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account getAccountByNum(int b) {
        Account a = new Account();

        try {
            Connection con = conUtil.getConnection();

            String sql = "SELECT * FROM accounts WHERE account_num = " + b;

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                a.setAccNum(rs.getInt(1));
                a.setUser(rs.getString(5));
                a.setBal(rs.getDouble(6));
                a.setType(rs.getString(7));
            }
            return a;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deposit(Account a) {
        try {
            Connection con = conUtil.getConnection();

            String sql = "UPDATE accounts SET balance = ? where account_num = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, a.getAccNum());
            ps.setDouble(2, a.getBal());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void withdraw(Account a) {

        try {
            Connection con = conUtil.getConnection();

            String sql = "UPDATE accounts SET balance = ? WHERE account_num = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, a.getAccNum());
            ps.setDouble(2, a.getBal());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
