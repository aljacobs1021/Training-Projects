package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.Models.Customer;
import com.example.Models.User;
import com.example.Utils.ConnectionUtil;

public class CustomerDB implements CustomersDAO {

    ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

    public List<Customer> getAllCustomers() {
        List<Customer> cList = new ArrayList<Customer>();

        try {
            Connection con = conUtil.getConnection();
            // To create a simple statment we write our query as a string
            String sql = "SELECT * FROM customers";

            // We need to create a statement with this sql string
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                cList.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5)));
            }

            return cList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Customer getCustomerByUsername(String username) {
        Customer c = new Customer();

        try {
            Connection con = conUtil.getConnection();

            String sql = "SELECT * FROM customers WHERE customers.username = '" + username + "'";

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                c.setFirstName(rs.getString(1));
                c.setLastName(rs.getString(2));
                c.setEmail(rs.getString(4));
                c.setUsername(rs.getString(3));
                c.setPassword(rs.getString(6));
            }
            return c;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void createCustomer(User u) throws SQLException {
        Connection con = conUtil.getConnection();
        String sql = "INSERT INTO customers(first_name, last_name, email, username, password) values" + "(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, u.getFirstName());
        ps.setString(2, u.getLastName());
        ps.setString(3, u.getEmail());
        ps.setString(4, u.getUsername());
        ps.setString(5, u.getPassword());

        ps.execute();

    }

    public void updateCustomer(Customer c) {
        try {
            Connection con = conUtil.getConnection();
            String sql = "UPDATE customers SET first_name = ?, last_name = ?, email = ?, username = ?, password = ? ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(4, c.getEmail());
            ps.setString(3, c.getUsername());
            ps.setString(5, c.getPassword());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteCustomer(Customer c) {
        try {

            Connection con = conUtil.getConnection();
            String sql = "DELETE FROM customers WHERE customers.username = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(3, c.getUsername());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
