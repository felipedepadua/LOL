
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Syllabus;

/**
 *
 * @author Felipe Padua
 */

public class syllabusDAO {       
    
        public Syllabus getSyllabusByCourseId(int id) {
        Connection conn = ConnectionDB.getConnection();
        ResultSet rs = null;
        Syllabus syllabus = new Syllabus();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM syllabus WHERE Course_idCourse=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                syllabus.setId(rs.getInt("idSyllabus"));
                syllabus.setDate(rs.getDate("date"));
                syllabus.setContent(rs.getString("content"));
                syllabus.setPublishedStatus(rs.getInt("publishedStatus"));
                syllabus.setCourse_idCourse(rs.getInt("Course_idCourse"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return syllabus;
    }
        
        
    public void createSyllabus(Syllabus syllabus) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO syllabus (content,date,publishedStatus,Course_idCourse) values (?,?,?,?)");
            stmt.setString(1, syllabus.getContent());
            stmt.setDate(2, new Date(syllabus.getDate().getTime()));
            stmt.setInt(3, syllabus.getPublishedStatus());
            stmt.setInt(4, syllabus.getCourse_idCourse());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }
    
    public void updateSyllabus(Syllabus syllabus) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE syllabus SET content=?,date=?,publishedStatus=?, Course_idCourse=?  WHERE idSyllabus=?");
            stmt.setString(1, syllabus.getContent());
            stmt.setDate(2, new Date(syllabus.getDate().getTime()));
            stmt.setInt(3, syllabus.getPublishedStatus());
            stmt.setInt(4, syllabus.getCourse_idCourse());
            stmt.setInt(5, syllabus.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }
    
    
    public void deleteSyllabus(Syllabus syllabus) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM syllabus WHERE idSyllabus=?");
            stmt.setInt(1, syllabus.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }
    
}
