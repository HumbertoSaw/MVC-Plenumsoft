/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.mysql.cj.jdbc.Driver;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

/**
 *
 * @author Humberto Sánchez
 */
public class Conexion {
    public static final String BASE = "dbtema5";
    public static final String URL = "jdbc:mysql://localhost:3306/"+ BASE +"?autoReconnect=true&useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";
    private Connection con = null;
    
    PreparedStatement ps;
    ResultSet rs;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.URL,this.USERNAME,this.PASSWORD);
        }catch(SQLException e){
            System.err.println(e);
        }
        catch (ClassNotFoundException ex) {   
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return con;
    }
}
