package clases.empleado;

import clases.Persona;
import javax.swing.JOptionPane;

public class Empleado extends Persona {
    private String codigoDeEmpleado;
    private Integer numeroDeHorasExtras;
    private String fechaDeIngreso;
    private String area;
    private String cargo;

    public String getCodigoDeEmpleado() {
        return codigoDeEmpleado;
    }

    public void setCodigoDeEmpleado(String codigoDeEmpleado) {
        this.codigoDeEmpleado = codigoDeEmpleado;
    }

    public Integer getNumeroDeHorasExtras() {
        return numeroDeHorasExtras;
    }

    public void setNumeroDeHorasExtras(Integer numeroDeHorasExtras) {
        this.numeroDeHorasExtras = numeroDeHorasExtras;
    }

    public String getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(String fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void registrarDatos() {
        try {
            super.registrarDatos();

            codigoDeEmpleado = JOptionPane.showInputDialog("Ingrese el código de empleado");
            if (codigoDeEmpleado == null || codigoDeEmpleado.trim().isEmpty()) {
                throw new IllegalArgumentException("El código de empleado no puede estar vacío.");
            }

            String horasInput = JOptionPane.showInputDialog("Ingrese la cantidad de horas extras");
            if (horasInput == null || horasInput.trim().isEmpty()) {
                throw new IllegalArgumentException("La cantidad de horas extras no puede estar vacía.");
            }
            numeroDeHorasExtras = Integer.parseInt(horasInput.trim());

            fechaDeIngreso = JOptionPane.showInputDialog("Ingrese la fecha de ingreso (dd/mm/aa)");
            if (fechaDeIngreso == null || fechaDeIngreso.trim().isEmpty()) {
                throw new IllegalArgumentException("La fecha de ingreso no puede estar vacía.");
            }

            area = JOptionPane.showInputDialog("Ingrese el área");
            cargo = JOptionPane.showInputDialog("Ingrese el cargo");

            System.out.println("Empleado registrado correctamente.");

        } catch (NumberFormatException e) {
            System.out.println("Error: las horas extras deben ser un número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: ingreso cancelado por el usuario.");
        }
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        datos += "Codigo de empleado: " + codigoDeEmpleado + "\n";
        datos += "Numero de horas extras: " + numeroDeHorasExtras + "\n";
        datos += "Feecha de ingreso: " + fechaDeIngreso + "\n";
        datos += "Area: " + area + "\n";
        datos += "Cargo: " + cargo + "\n";

        System.out.println(datos);
    }
}
