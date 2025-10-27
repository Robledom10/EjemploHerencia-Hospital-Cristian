package clases.empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla {
    private String especialidad;
    private Integer numeroDeConsultorio;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getNumeroDeConsultorio() {
        return numeroDeConsultorio;
    }

    public void setNumeroDeConsultorio(Integer numeroDeConsultorio) {
        this.numeroDeConsultorio = numeroDeConsultorio;
    }

    @Override
    public void registrarDatos() {
        super.registrarDatos();

        especialidad = JOptionPane.showInputDialog("Ingrese su especialiidad");
        numeroDeConsultorio = Integer.parseInt(JOptionPane.showInputDialog("Numero consultorio"));
    }
}
