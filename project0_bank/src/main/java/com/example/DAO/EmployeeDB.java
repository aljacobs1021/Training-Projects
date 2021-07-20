package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.Models.Employee;
import com.example.Models.User;
import com.example.Utils.ConnectionUtil;

public class EmployeeDB implements EmployeesDAO {
    ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

    public List<Employee> getAllEmployees() {
        List<Employee> eList = new ArrayList<Employee>();

        try {
            Connection con = conUtil.getConnection();
            // To create a simple statment we write our query as a string
            String sql = "SELECT * FROM employees";

            // We need to create a statement with this sql string
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                eList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6)));
            }

            return eList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Employee getEmployeeByID(int ID) {
        Employee e = new Employee();

        try {
            Connection con = conUtil.getConnection();

            String sql = "SELECT * FROM customers WHERE employees.employee_ID = '" + ID + "'";

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                e.setEmployeeID(rs.getInt(1));
                e.setFirstName(rs.getString(2));
                e.setLastName(rs.getString(3));
                e.setUsername(rs.getString(4));
                e.setEmail(rs.getString(4));
                e.setPassword(rs.getString(6));
            }
            return e;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void createEmployee(User u) throws SQLException {
        Connection con = conUtil.getConnection();
        String sql = "INSERT INTO employees(employee_ID, first_name, last_name, email, username, password) values"
                + "(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, u.getEmployeeID());
        ps.setString(2, u.getFirstName());
        ps.setString(3, u.getLastName());
        ps.setString(4, u.getEmail());
        ps.setString(5, u.getUsername());
        ps.setString(6, u.getPassword());

        ps.execute();

    }

    public void updateEmployee(Employee e) {
        try {
            Connection con = conUtil.getConnection();
            String sql = "UPDATE employees SET employee_ID = ?, first_name = ?, last_name = ?, email = ?, username = ?, password = ? ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, e.getEmployeeID());
            ps.setString(2, e.getFirstName());
            ps.setString(3, e.getLastName());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getUsername());
            ps.setString(6, e.getPassword());
            ps.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteEmployee(Employee e) {
        try {

            Connection con = conUtil.getConnection();
            String sql = "DELETE FROM employees WHERE employees.employee_ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, e.getEmployeeID());

            ps.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
