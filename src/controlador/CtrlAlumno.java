/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.mysql.cj.jdbc.Driver;
import java.awt.event.ActionEvent;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.awt.event.ActionListener;
import modelo.Alumno;
import modelo.ConsultasAlumno;
import vista.FrmAlumno;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Humberto Sánchez
 */
public class CtrlAlumno implements ActionListener{
    private Alumno modAlumno;
    private ConsultasAlumno modConsultasAlumno;
    private FrmAlumno frmAlumno;
    
    public CtrlAlumno (Alumno modAlumno, ConsultasAlumno modConsultasAlumno, FrmAlumno frmAlumno){
        this.modAlumno = modAlumno;
        this.modConsultasAlumno = modConsultasAlumno;
        this.frmAlumno = frmAlumno;
        this.frmAlumno.btnBuscar.addActionListener(this);
        this.frmAlumno.btnGuardar.addActionListener(this);
        this.frmAlumno.btnActualizar.addActionListener(this);
        this.frmAlumno.btnEliminar.addActionListener(this);
    }
    
    public void iniciar(){
        frmAlumno.setTitle("Alumnos");
        modAlumno.setTabulacionAlumno(frmAlumno.tablaDatosAlumno);
        tabularDatos();
        limpiarTabla();
        tabularDatos();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==frmAlumno.btnBuscar){
            modAlumno.setNumControlAlumno(frmAlumno.txtNumControlAlumno.getText());          
            
            if(modConsultasAlumno.buscar(modAlumno)){
                this.frmAlumno.txtNumControlAlumno.setText(modAlumno.getNumControlAlumno());
                this.frmAlumno.txtClaveAlumno.setText(modAlumno.getClaveALumno());
                this.frmAlumno.txtNombreAlumno.setText(modAlumno.getNombreAlumno());
                this.frmAlumno.txtApellido1Alumno.setText(modAlumno.getApellido1Alumno());
                this.frmAlumno.txtApellido2Alumno.setText(modAlumno.getApellido2Alumno());
                this.frmAlumno.txtFechaNacAlumno.setText(modAlumno.getFechaNacAlumno());
                this.frmAlumno.txtEmailAlumno.setText(modAlumno.getEmailAlumno());
                this.frmAlumno.txtNumeroCelAlumno.setText(modAlumno.getNumeroCelAlumno());
                this.frmAlumno.txtNumeroAltAlumno.setText(modAlumno.getNumeroAltAlumno());
 
            } else{
                JOptionPane.showMessageDialog(null,"Error, registro no encontrado");
                limpiar();
                limpiarTabla();
                tabularDatos();
            }       
        }
        
        if(e.getSource()==frmAlumno.btnGuardar){
            modAlumno.setNumControlAlumno(frmAlumno.txtNumControlAlumno.getText());
            modAlumno.setClaveALumno(frmAlumno.txtClaveAlumno.getText());
            modAlumno.setNombreAlumno(frmAlumno.txtNombreAlumno.getText());
            modAlumno.setApellido1Alumno(frmAlumno.txtApellido1Alumno.getText());
            modAlumno.setApellido2Alumno(frmAlumno.txtApellido2Alumno.getText());
            modAlumno.setFechaNacAlumno(frmAlumno.txtFechaNacAlumno.getText());
            modAlumno.setEmailAlumno(frmAlumno.txtEmailAlumno.getText());
            modAlumno.setNumeroCelAlumno(frmAlumno.txtNumeroCelAlumno.getText());
            modAlumno.setNumeroAltAlumno(frmAlumno.txtNumeroAltAlumno.getText());
            
            if(modConsultasAlumno.guardar(modAlumno)){
                JOptionPane.showMessageDialog(null,"Registro guardado");
                limpiar();
                limpiarTabla();
                tabularDatos();
            } else{
                JOptionPane.showMessageDialog(null,"Error, registro no guardado");
                limpiar();
                limpiarTabla();
                tabularDatos();
            }       
        }
        
        if(e.getSource()==frmAlumno.btnActualizar){
            modAlumno.setNumControlAlumno(frmAlumno.txtNumControlAlumno.getText());
            modAlumno.setClaveALumno(frmAlumno.txtClaveAlumno.getText());
            modAlumno.setNombreAlumno(frmAlumno.txtNombreAlumno.getText());
            modAlumno.setApellido1Alumno(frmAlumno.txtApellido1Alumno.getText());
            modAlumno.setApellido2Alumno(frmAlumno.txtApellido2Alumno.getText());
            modAlumno.setFechaNacAlumno(frmAlumno.txtFechaNacAlumno.getText());
            modAlumno.setEmailAlumno(frmAlumno.txtEmailAlumno.getText());
            modAlumno.setNumeroCelAlumno(frmAlumno.txtNumeroCelAlumno.getText());
            modAlumno.setNumeroAltAlumno(frmAlumno.txtNumeroAltAlumno.getText());
            
            if(modConsultasAlumno.actualizar(modAlumno)){
                JOptionPane.showMessageDialog(null,"Registro actualizado");
                limpiar();
                limpiarTabla();
                tabularDatos();
            } else{
                JOptionPane.showMessageDialog(null,"Error, registro no actualizado");
                limpiar();
                limpiarTabla();
                tabularDatos();
            }       
        }
        
        if(e.getSource()==frmAlumno.btnEliminar){
            modAlumno.setNumControlAlumno(frmAlumno.txtNumControlAlumno.getText());
            
            if(modConsultasAlumno.eliminar(modAlumno)){
                JOptionPane.showMessageDialog(null,"Registro eliminado");
                limpiar();
                limpiarTabla();
            } else{
                JOptionPane.showMessageDialog(null,"Error, registro no eliminado");
                limpiar();
                limpiarTabla();
                tabularDatos();
            }       
        }

        if(e.getSource()==frmAlumno.btnLimpiar)
        {
            JOptionPane.showMessageDialog(null,"Limpiar!");
            limpiar();
            limpiarTabla();
            tabularDatos();
        }       
    }
    public void limpiar(){
        frmAlumno.txtNumControlAlumno.setText(null);
        frmAlumno.txtClaveAlumno.setText(null);
        frmAlumno.txtNombreAlumno.setText(null);
        frmAlumno.txtApellido1Alumno.setText(null);
        frmAlumno.txtApellido2Alumno.setText(null);
        frmAlumno.txtFechaNacAlumno.setText(null);
        frmAlumno.txtEmailAlumno.setText(null);
        frmAlumno.txtNumeroCelAlumno.setText(null);
        frmAlumno.txtNumeroAltAlumno.setText(null);
    }
    
    public void limpiarTabla(){
        for(int i = 0; i < this.modAlumno.getTabulacionAlumno().getRowCount(); i++)
        {
            this.modAlumno.getEstructuraTabulacion().removeRow(i);
            i = i -1;
        }
    }
    
    public void tabularDatos(){
         if(modConsultasAlumno.tabular(modAlumno))
        {
            System.out.println("Datos tabulados");
        }
         else{
            System.err.println("Error, datos no tabulados");
        }
    }
}
