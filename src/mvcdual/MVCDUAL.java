/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvcdual;

import controlador.CtrlAlumno;
import modelo.Alumno;
import modelo.ConsultasAlumno;
import vista.FrmAlumno;

/**
 *
 * @author Humberto Sánchez
 */
public class MVCDUAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno modAlumno = new Alumno();
        ConsultasAlumno modConsultasAlumno = new ConsultasAlumno();
        FrmAlumno frmAlumno = new FrmAlumno();
        CtrlAlumno ctrlALumno = new CtrlAlumno(modAlumno,modConsultasAlumno,frmAlumno);
        ctrlALumno.iniciar();
        frmAlumno.setVisible(true);
        
    }
    
}
