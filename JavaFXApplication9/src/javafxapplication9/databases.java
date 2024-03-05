/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication9;


import java.sql.DriverManager;

import java.sql.Connection;

/**
 *
 * @author bekkari
 */
public class databases {
    public static Connection connectDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connect =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/dondiste","root",""); // LINK YOUR DATABASE
            return connect;
        } catch (Exception e) {e.printStackTrace();}
        return null;
    }
}
