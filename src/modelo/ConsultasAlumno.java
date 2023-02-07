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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Humberto Sánchez
 */
public class ConsultasAlumno extends Conexion {
    
    public boolean guardar(Alumno alumno){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO alumnos (NumControlALumno, ClaveAlumno, NombreAlumno, Apellido1Alumno, Apellido2Alumno, FechaNacAlumno,EmailAlumno,NumeroCelAlumno,NumeroAltAlumno) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,alumno.getNumControlAlumno());
            ps.setString(2,alumno.getClaveALumno());
            ps.setString(3,alumno.getNombreAlumno());
            ps.setString(4,alumno.getApellido1Alumno());
            ps.setString(5,alumno.getApellido2Alumno());
            ps.setDate(6,Date.valueOf(alumno.getFechaNacAlumno()));
            ps.setString(7,alumno.getEmailAlumno());
            ps.setString(8,alumno.getNumeroCelAlumno());
            ps.setString(9,alumno.getNumeroAltAlumno());
            ps.execute();
            return true;       
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }   
        }
    }
    
    public boolean actualizar(Alumno alumno){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE alumnos SET NumControlALumno = ?, ClaveAlumno = ?, NombreAlumno = ?, Apellido1Alumno = ?, Apellido2Alumno = ?, FechaNacAlumno = ?, EmailAlumno = ?, NumeroCelAlumno = ?, NumeroAltAlumno = ? WHERE NumControlALumno = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,alumno.getNumControlAlumno());
            ps.setString(2,alumno.getClaveALumno());
            ps.setString(3,alumno.getNombreAlumno());
            ps.setString(4,alumno.getApellido1Alumno());
            ps.setString(5,alumno.getApellido2Alumno());
            ps.setDate(6,Date.valueOf(alumno.getFechaNacAlumno()));
            ps.setString(7,alumno.getEmailAlumno());
            ps.setString(8,alumno.getNumeroCelAlumno());
            ps.setString(9,alumno.getNumeroAltAlumno());
            ps.setString(10,alumno.getNumControlAlumno());
            ps.execute();
            return true;       
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }   
        }
    }
    
    public boolean eliminar(Alumno alumno){
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM alumnos WHERE NumControlALumno = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,alumno.getNumControlAlumno());
            ps.execute();
            return true;       
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }   
        }
    }
    
    public boolean buscar(Alumno alumno){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM alumnos WHERE NumControlALumno = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,alumno.getNumControlAlumno());
            rs = ps.executeQuery();
            if(rs.next()){
                alumno.setNumControlAlumno(rs.getString("NumControlAlumno"));
                alumno.setClaveALumno(rs.getString("ClaveAlumno"));
                alumno.setNombreAlumno(rs.getString("NombreAlumno"));
                alumno.setApellido1Alumno(rs.getString("Apellido1Alumno"));
                alumno.setApellido2Alumno(rs.getString("Apellido2Alumno"));
                alumno.setFechaNacAlumno(rs.getString("FechaNacAlumno"));
                alumno.setEmailAlumno(rs.getString("EmailAlumno"));
                alumno.setNumeroCelAlumno(rs.getString("NumeroCelAlumno"));
                alumno.setNumeroAltAlumno(rs.getString("NumeroAltAlumno"));
                return true;
            }
            return false;     
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }   
        }
    }
    
    public boolean tabular (Alumno alumno){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM ALUMNOS";
        Object[] datosAlumno = new Object[9];
        DefaultTableModel modelo;
        JTable tabla;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            tabla = alumno.getTabulacionAlumno();
            modelo = (DefaultTableModel) tabla.getModel();
            while(rs.next()){
                datosAlumno[0] = rs.getString("NumControlAlumno");
                datosAlumno[1] = rs.getString("ClaveAlumno");
                datosAlumno[2] = rs.getString("NombreAlumno");
                datosAlumno[3] = rs.getString("Apellido1Alumno");
                datosAlumno[4] = rs.getString("Apellido2Alumno");
                datosAlumno[5] = rs.getString("FechaNacAlumno");
                datosAlumno[6] = rs.getString("EmailAlumno");
                datosAlumno[7] = rs.getString("NumeroCelAlumno");
                datosAlumno[8] = rs.getString("NumeroAltAlumno");
                modelo.addRow(datosAlumno);
            }
            tabla.setModel(modelo);
            alumno.setTabulacionAlumno(tabla);
            alumno.setEstructuraTabulacion(modelo);
            return true;
        }catch(Exception e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }   
        }
    }   
}
