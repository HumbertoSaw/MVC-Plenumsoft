/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Humberto Sánchez
 */
public class Alumno {
    private String NumControlAlumno;
    private String ClaveALumno;
    private String NombreAlumno;
    private String Apellido1Alumno;
    private String Apellido2Alumno;
    private String FechaNacAlumno;
    private String EmailAlumno;
    private String NumeroCelAlumno;
    private String NumeroAltAlumno;   
    private JTable TabulacionAlumno;
    private DefaultTableModel EstructuraTabulacion;

    public JTable getTabulacionAlumno() {
        return TabulacionAlumno;
    }

    public void setTabulacionAlumno(JTable TabulacionAlumno) {
        this.TabulacionAlumno = TabulacionAlumno;
    }

    public DefaultTableModel getEstructuraTabulacion() {
        return EstructuraTabulacion;
    }

    public void setEstructuraTabulacion(DefaultTableModel EstructuraTabulacion) {
        this.EstructuraTabulacion = EstructuraTabulacion;
    }
    
    

    public String getNumControlAlumno() {
        return NumControlAlumno;
    }

    public void setNumControlAlumno(String NumControlAlumno) {
        this.NumControlAlumno = NumControlAlumno;
    }

    public String getClaveALumno() {
        return ClaveALumno;
    }

    public void setClaveALumno(String ClaveALumno) {
        this.ClaveALumno = ClaveALumno;
    }

    public String getNombreAlumno() {
        return NombreAlumno;
    }

    public void setNombreAlumno(String NombreAlumno) {
        this.NombreAlumno = NombreAlumno;
    }

    public String getApellido1Alumno() {
        return Apellido1Alumno;
    }

    public void setApellido1Alumno(String Apellido1Alumno) {
        this.Apellido1Alumno = Apellido1Alumno;
    }

    public String getApellido2Alumno() {
        return Apellido2Alumno;
    }

    public void setApellido2Alumno(String Apellido2Alumno) {
        this.Apellido2Alumno = Apellido2Alumno;
    }

    public String getFechaNacAlumno() {
        return FechaNacAlumno;
    }

    public void setFechaNacAlumno(String FechaNacAlumno) {
        this.FechaNacAlumno = FechaNacAlumno;
    }

    public String getEmailAlumno() {
        return EmailAlumno;
    }

    public void setEmailAlumno(String EmailAlumno) {
        this.EmailAlumno = EmailAlumno;
    }

    public String getNumeroCelAlumno() {
        return NumeroCelAlumno;
    }

    public void setNumeroCelAlumno(String NumeroCelAlumno) {
        this.NumeroCelAlumno = NumeroCelAlumno;
    }

    public String getNumeroAltAlumno() {
        return NumeroAltAlumno;
    }

    public void setNumeroAltAlumno(String NumeroAltAlumno) {
        this.NumeroAltAlumno = NumeroAltAlumno;
    }
    
    
}
