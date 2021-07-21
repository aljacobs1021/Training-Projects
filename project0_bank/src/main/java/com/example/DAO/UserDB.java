package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.Models.User;
import com.example.Utils.ConnectionUtil;

public class UserDB implements UserDao {
    ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

    // Simple statements

    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<User>();

        try {
            Connection con = conUtil.getConnection();
            // To create a simple statment we write our query as a string
            String sql = "SELECT * FROM users";

            // We need to create a statement with this sql string
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4),
                        rs.getString(6), rs.getBoolean(7)));
            }

            return userList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public User getUserByUsername(String username) {

        User user = new User();

        try {
            Connection con = conUtil.getConnection();

            String sql = "SELECT * FROM users WHERE users.username = '" + username + "'";

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setUsername(rs.getString(5));
                user.setPassword(rs.getString(6));
                user.setEmployee(rs.getBoolean(7));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void createUser(User u) throws SQLException {

        Connection con = conUtil.getConnection();
        String sql = "INSERT INTO users(first_name, last_name, email, username, password, is_employee) values"
                + "(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, u.getFirstName());
        ps.setString(2, u.getLastName());
        ps.setString(3, u.getEmail());
        ps.setString(4, u.getUsername());
        ps.setString(5, u.getPassword());
        ps.setBoolean(6, u.isEmployee());

        ps.execute();

    }

    public void updateUser(User u) {
        try {
            Connection con = conUtil.getConnection();
            String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, username = ?, password = ?, is_employee = ? WHERE users.id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, u.getFirstName());
            ps.setString(2, u.getLastName());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getUsername());
            ps.setString(5, u.getPassword());
            ps.setInt(6, u.getId());
            ps.setBoolean(7, u.isEmployee());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteUser(User u) {

        try {

            Connection con = conUtil.getConnection();
            String sql = "DELETE FROM users WHERE users.id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, u.getId());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
