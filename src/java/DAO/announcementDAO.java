
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Announcement;

/**
 *
 * @author Felipe Padua
 */
public class announcementDAO {
    
    
        public List<Announcement> getAnnouncements() {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Announcement> announcementList = new ArrayList<>();
        // https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

        try { 
            stmt = conn.prepareStatement("SELECT * FROM announcement");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Announcement announcement = new Announcement();
                announcement.setId(rs.getInt("idAnnouncement"));
                announcement.setSubject(rs.getString("subject"));
                announcement.setContent(rs.getString("content"));
                announcement.setDate(rs.getDate("date"));
                announcement.setPublishedStatus(rs.getInt("publishedStatus"));
                announcement.setCourse_idCourse(rs.getInt("Course_idCourse"));

                announcementList.add(announcement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt, rs);
        }

        return announcementList;
    }        
              
    
    public List<Announcement> getAnnouncementsFromCourse(int courseId) {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Announcement> announcementList = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM announcement WHERE Course_idCourse=?");
            stmt.setInt(1, courseId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Announcement announcement = new Announcement();
                announcement.setId(rs.getInt("idAnnouncement"));
                announcement.setSubject(rs.getString("subject"));
                announcement.setContent(rs.getString("content"));
                announcement.setDate(rs.getDate("date"));
                announcement.setPublishedStatus(rs.getInt("publishedStatus"));
                announcement.setCourse_idCourse(rs.getInt("Course_idCourse"));

                announcementList.add(announcement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt, rs);
        }

        return announcementList;
    }  
    
    
    public List<Announcement> getAnnouncementsFromUser(int userId) {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Announcement> announcementList = new ArrayList<>();
        // https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

        try {
            stmt = conn.prepareStatement("SELECT * FROM announcement WHERE Course_idCourse IN (SELECT Course_idCourse FROM user_has_course WHERE User_idUser=?);");
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Announcement announcement = new Announcement();
                announcement.setId(rs.getInt("idAnnouncement"));
                announcement.setSubject(rs.getString("subject"));
                announcement.setContent(rs.getString("content"));
                announcement.setDate(rs.getDate("date"));
                announcement.setPublishedStatus(rs.getInt("publishedStatus"));
                announcement.setCourse_idCourse(rs.getInt("Course_idCourse"));

                announcementList.add(announcement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt, rs);
        }

        return announcementList;
    }
        
      
   public void createAnnouncement(Announcement announcement) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO announcement (subject,content,date,publishedStatus,Course_idCourse) values (?,?,?,?,?)");
            stmt.setString(1, announcement.getSubject());
            stmt.setString(2, announcement.getContent());
            // http://www.java2s.com/Tutorial/Java/0040__Data-Type/ConvertfromajavautilDateObjecttoajavasqlDateObject.htm
            stmt.setDate(3, new Date(announcement.getDate().getTime()));
            stmt.setInt(4, announcement.getPublishedStatus());
            stmt.setInt(5, announcement.getCourse_idCourse());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }
   
   
   public void deleteAnnouncement(Announcement announcement) {
        Connection conn = ConnectionDB.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM announcement WHERE idAnnouncement=?");
            stmt.setInt(1, announcement.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }
        
    
}
