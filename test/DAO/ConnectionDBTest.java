/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felipe Padua
 */
public class ConnectionDBTest {
    
    public ConnectionDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getConnection method, of class ConnectionDB.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection expResult = null;
        Connection result = ConnectionDB.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class ConnectionDB.
     */
    @Test
    public void testCloseConnection_Connection() {
        System.out.println("closeConnection");
        Connection conn = null;
        ConnectionDB.closeConnection(conn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class ConnectionDB.
     */
    @Test
    public void testCloseConnection_Connection_PreparedStatement() {
        System.out.println("closeConnection");
        Connection conn = null;
        PreparedStatement stmt = null;
        ConnectionDB.closeConnection(conn, stmt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class ConnectionDB.
     */
    @Test
    public void testCloseConnection_3args() {
        System.out.println("closeConnection");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ConnectionDB.closeConnection(conn, stmt, rs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
