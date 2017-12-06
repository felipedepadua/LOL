/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Felipe Padua
 */
public class User {
    private int id;
    private String email;
    private String password;
    private enum Role {Admin, Student, Instructor, TA}; // http://www.geeksforgeeks.org/enum-in-java/
    private Role role;  // https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
    // The variable must be equal to one of the values that have been predefined for it.
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    // https://stackoverflow.com/questions/14926148/java-enum-usage-getting-and-setting
    public String getRole() {
        return this.role.name();
        // https://www.tutorialspoint.com/java/lang/java_lang_enum.htm
    }

    public void setRole(String role) {
        //this.role.valueOf(role);
        this.role = Role.valueOf(role);
    }
    // Enum is type-safe you can not assign anything else other than predefined Enum constants to an Enum variable
    // Enum constants are implicitly static and final and can not be changed once created
    // Read more: http://javarevisited.blogspot.com/2011/08/enum-in-java-example-tutorial.html
    
}
