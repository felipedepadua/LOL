
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author Felipe Padua
 */
public class userDAO {
    
    public User login(String email, String password){
        
        Connection conn = ConnectionDB.getConnection();
        ResultSet rs = null;
        User user = new User();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM user WHERE email=? AND password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("idUser"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
               
        return user;
    }
    
    
    public void insertUser(User user) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO user (email,password,role) values (?,?,?)");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }

    public void deleteUser(User user) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM user WHERE id=?");
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }

    public User getUserById(int id) {
        Connection conn = ConnectionDB.getConnection();
        ResultSet rs = null;
        User user = new User();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM user WHERE id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("idUser"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return user;
    }

    public void updateUser(User user) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE user SET email=?,password=?,role=?  WHERE id=?");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setInt(4, user.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }

    public List<User> getUsers() {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM user");
            rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("idUser"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                userList.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt, rs);
        }

        return userList;
    }
    
    
    public List<User> getUsersFromCourse(int idCourse) {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM user WHERE idUser IN (SELECT User_idUser FROM user_has_course WHERE Course_idCourse=?);");
            stmt.setInt(1, idCourse);
            rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("idUser"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                userList.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt, rs);
        }

        return userList;
    }
    
    
}
