package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado {
    private double salarioMensual;
    private double porcentajeAdicionalPorHoraExtra;

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public double getPorcentajeAdicionalPorHoraExtra() {
        return porcentajeAdicionalPorHoraExtra;
    }

    public void setPorcentajeAdicionalPorHoraExtra(double porcentajeAdicionalPorHoraExtra) {
        this.porcentajeAdicionalPorHoraExtra = porcentajeAdicionalPorHoraExtra;
    }

    @Override
public void registrarDatos() {
    try {
        super.registrarDatos();

        String salarioInput = JOptionPane.showInputDialog("Ingrese el salario mensual");
        if (salarioInput == null || salarioInput.trim().isEmpty()) {
            throw new IllegalArgumentException("El salario mensual no puede estar vacío.");
        }
        salarioMensual = Double.parseDouble(salarioInput.trim());

        String porcentajeInput = JOptionPane.showInputDialog("Ingrese el porcentaje adicional por hora extra");
        if (porcentajeInput == null || porcentajeInput.trim().isEmpty()) {
            throw new IllegalArgumentException("El porcentaje adicional no puede estar vacío.");
        }
        porcentajeAdicionalPorHoraExtra = Double.parseDouble(porcentajeInput.trim());

        System.out.println("Empleado por planilla registrado correctamente.");

    } catch (NumberFormatException e) {
        System.out.println("Error: ingrese valores numéricos válidos para salario o porcentaje.");
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    } catch (NullPointerException e) {
        System.out.println("Error: ingreso cancelado por el usuario.");
    }
}


    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);

        datos += "Salario mensual: " + salarioMensual + "\n";
        datos += "Porcentaje adicional por horas extras: " + porcentajeAdicionalPorHoraExtra + "\n";

        System.out.println(datos);
    }
}
