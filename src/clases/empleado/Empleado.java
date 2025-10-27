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
        super.registrarDatos();

        codigoDeEmpleado = JOptionPane.showInputDialog("Ingrese el codigo de empelado");
        numeroDeHorasExtras = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de horas extras"));
        fechaDeIngreso = JOptionPane.showInputDialog("Ingrese la fecha de ingreo (dd/mm/aa)");
        area = JOptionPane.showInputDialog("Ingrese el area");
        cargo = JOptionPane.showInputDialog("Ingrese el cargo");
    }

    public void imprimirDatosPersona(String datos) {
        datos += "Codigo de empleado: " + codigoDeEmpleado + "\n";
        datos += "Numero de horas extras: " + numeroDeHorasExtras + "\n";
        datos += "Feecha de ingreso: " + fechaDeIngreso + "\n";
        datos += "Area: " + area + "\n";
        datos += "Cargo: " + cargo + "\n";
        
        System.out.println(datos);
    }
}
