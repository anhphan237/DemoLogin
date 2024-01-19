/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dal.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RegistrationDAO implements Serializable {

    private List<RegistrationDTO> accounts;

    // create method to get data from DB
    public boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. create SQL String
                String sql = "select username "
                        + "FROM Registration "
                        + "WHERE username = ? "
                        + "AND password = ?";
                //3. create SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. execute query
                rs = stm.executeQuery();
                //5. process result   
                if (rs.next()) {
                    System.out.println(username);
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    // get user
    public RegistrationDTO getAccount(String username, String password) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        RegistrationDTO a = null;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. create SQL String
                String sql = "select username, password, fullname, role "
                        + "FROM Registration "
                        + "WHERE username = ? "
                        + "AND password = ?";
                //3. create SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. execute query
                rs = stm.executeQuery();
                //5. process result   
                if (rs.next()) {
                    String fullname = rs.getString("fullname");
                    boolean role = rs.getBoolean("role");
                    a = new RegistrationDTO(username, password, fullname, role);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return a;
    }
    public List<RegistrationDTO> getAccounts() {
        return accounts;
    }

    public void search(String searchValue) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. create SQL String
                String sql = "select username, password, fullname, role "
                        + "FROM Registration "
                        + "WHERE fullname like ? ";
                //3. create SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4. execute query
                rs = stm.executeQuery();
                //5. process result   
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullname = rs.getString("fullname");
                    boolean role = rs.getBoolean("role");

                    RegistrationDTO dto = new RegistrationDTO(username, password, fullname, role);
                    if (this.accounts == null) {
                        this.accounts = new ArrayList<>();
                    } //end acocunts are not existed
                    this.accounts.add(dto);
                } // end traverse Result Set
            } //process when connection is existed
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public boolean deleteRecord(String pk) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "DELETE FROM Registration "
                        + "WHERE username = ?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1,pk);
                
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateRecord(String username, String password, boolean role) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "UPDATE Registration "
                        + "SET password = ?, role = ? "
                        + "WHERE username = ?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1,password);
                stm.setBoolean(2, role);
                stm.setString(3,username);
                
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean insertAccount (String username, String password, String fullname, boolean role) throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT into dbo.Admin "
                        + "(username,password,fullname,role) "
                        + "VALUES(?,?,?,?)";
                
                stm = con.prepareStatement(sql);
                stm.setString(1,username);
                stm.setString(2, password);
                stm.setString(3,fullname);
                stm.setBoolean(4,role);
                
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;      
    }
}

