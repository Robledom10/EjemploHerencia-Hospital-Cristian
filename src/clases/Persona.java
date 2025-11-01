package clases;

import javax.swing.JOptionPane;

public class Persona {
    private String numeroDeDNI;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String direccion;
    private String ciudadDeProcedencia;

    public void imprimirDatosPersona(String datos) {
        datos += "Nombre: " + nombre + "\n";
        datos += "Apellido: " + apellido + "\n";
        datos += "Fecha nacimiento: " + fechaNacimiento + "\n";
        datos += "Direccion: " + direccion + "\n";
        datos += "Ciudad de procedencia: " + ciudadDeProcedencia;

        System.out.println(datos);
    }

    public void registrarDatos() {
        try {
            numeroDeDNI = JOptionPane.showInputDialog("Ingrese el número de documento");
            if (numeroDeDNI == null || numeroDeDNI.trim().isEmpty()) {
                throw new IllegalArgumentException("El número de documento no puede estar vacío.");
            }

            nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            apellido = JOptionPane.showInputDialog("Ingrese el apellido");
            fechaNacimiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (DD/MM/AAAA)");
            direccion = JOptionPane.showInputDialog("Ingrese la dirección");
            ciudadDeProcedencia = JOptionPane.showInputDialog("Ingrese la ciudad de procedencia");

            System.out.println("Datos registrados correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No se ingresó ningún dato.");
        }
    }

    public String getNumeroDeDNI() {
        return numeroDeDNI;
    }

    public void setNumeroDeDNI(String numeroDeDNI) {
        this.numeroDeDNI = numeroDeDNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudadDeProcedencia() {
        return ciudadDeProcedencia;
    }

    public void setCiudadDeProcedencia(String ciudadDeProcedencia) {
        this.ciudadDeProcedencia = ciudadDeProcedencia;
    }
}