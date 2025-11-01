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
    try {
        super.registrarDatos();

        especialidad = JOptionPane.showInputDialog("Ingrese su especialidad");
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        }

        String consultorioInput = JOptionPane.showInputDialog("Ingrese el número de consultorio");
        if (consultorioInput == null || consultorioInput.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de consultorio no puede estar vacío.");
        }

        numeroDeConsultorio = Integer.parseInt(consultorioInput.trim());

        System.out.println("Médico registrado correctamente.");

    } catch (NumberFormatException e) {
        System.out.println("Error: el número de consultorio debe ser un valor numérico.");
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    } catch (NullPointerException e) {
        System.out.println("Error: ingreso cancelado por el usuario.");
    }
}

}
