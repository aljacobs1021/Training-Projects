package com.example.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Models.Account;
import com.example.Utils.ConnectionUtil;

public class AccountsDB implements AccountsDAO {

    ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

    @Override
    public List<Account> getAllAccounts() {
        List<Account> aList = new ArrayList<Account>();

        try {
            Connection con = conUtil.getConnection();
            // To create a simple statment we write our query as a string
            String sql = "SELECT * FROM accounts";

            // We need to create a statement with this sql string
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

    public Account getAccountByNumber(int accNum) {
        Account a = new Account();

        try {
            Connection con = conUtil.getConnection();

            String sql = "SELECT * FROM accounts WHERE accounts.account_num = '" + accNum + "'";

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                a.setAccNum(rs.getInt(1));
                a.setUser(rs.getString(2));
                a.setBal(rs.getDouble(3));
                a.setType(rs.getString(4));
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
        String sql = "INSERT INTO accounts(account_num, first_name, last_name, email, username, balance, type) values"
                + "(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, a.getAccNum());
        ps.setString(2, a.getFirst());
        ps.setString(3, a.getLast());
        ps.setString(4, a.getEmail());
        ps.setString(5, a.getUser());
        ps.setDouble(6, a.getBal());
        ps.setString(7, a.getType());

        ps.execute();
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
}
