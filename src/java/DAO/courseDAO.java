
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Course;

/**
 *
 * @author Felipe Padua
 */
public class courseDAO {
             
    public void createCourse(Course course) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO course (name,semester,description) values (?,?,?)");
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getSemester());
            stmt.setString(3, course.getDescription());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }

    public void deleteCourse(Course course) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM course WHERE idCourse=?");
            stmt.setInt(1, course.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }

    
    public void deleteUserFromCourse(int idUser) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM user_has_course WHERE User_idUser=?");
            stmt.setInt(1, idUser);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }
    
    
    public Course getCourseById(int id) {
        Connection conn = ConnectionDB.getConnection();
        ResultSet rs = null;
        Course course = new Course();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM course WHERE idCourse=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setSemester(rs.getString("semester"));
                course.setDescription(rs.getString("description"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return course;
    }

    public void updateCourse(Course course) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE Course SET name=?,semester=?,description=?  WHERE id=?");
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getSemester());
            stmt.setString(3, course.getDescription());
            stmt.setInt(4, course.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }

    public List<Course> getCourses() {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Course> courseList = new ArrayList<>();
        // https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

        try {
            stmt = conn.prepareStatement("SELECT * FROM course");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("idCourse"));
                course.setName(rs.getString("name"));
                course.setSemester(rs.getString("semester"));
                course.setDescription(rs.getString("description"));

                courseList.add(course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt, rs);
        }

        return courseList;
    }
      
    
    public List<Course> getCoursesFromUser(int userId) {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Course> courseList = new ArrayList<>();
        // https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

        try {
            // https://www.w3schools.com/sql/sql_join_inner.asp     
            // The following SQL statement selects all orders with user information:
            stmt = conn.prepareStatement("SELECT * FROM course WHERE idCourse IN (SELECT Course_idCourse FROM user_has_course WHERE User_idUser=?);");
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("idCourse"));
                course.setName(rs.getString("name"));
                course.setSemester(rs.getString("semester"));
                course.setDescription(rs.getString("description"));

                courseList.add(course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt, rs);
        }

        return courseList;
    }
     
}
