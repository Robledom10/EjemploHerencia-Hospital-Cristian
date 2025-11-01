package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado {
    private double honariosPorHora;
    private String fechaTerminoContrato;

    public double getHonariosPorHora() {
        return honariosPorHora;
    }

    public void setHonariosPorHora(double honariosPorHora) {
        this.honariosPorHora = honariosPorHora;
    }

    public String getFechaTerminoContrato() {
        return fechaTerminoContrato;
    }

    public void setFechaTerminoContrato(String fechaTerminoContrato) {
        this.fechaTerminoContrato = fechaTerminoContrato;
    }

    @Override
    public void registrarDatos() {
        try {
            super.registrarDatos();

            String horasInput = JOptionPane.showInputDialog("Ingrese el salario mensual");
            if (horasInput == null || horasInput.trim().isEmpty()) {
                throw new IllegalArgumentException("El salario mensual no puede estar vacio");
            }
            honariosPorHora = Integer.parseInt(horasInput);

            fechaTerminoContrato = JOptionPane.showInputDialog("Ingrese la fecha de termino de contrato (dd/mm/aa)");
            if (fechaTerminoContrato == null || fechaTerminoContrato.trim().isEmpty()) {
                throw new IllegalArgumentException("La  fecha de termino de contrato no puede estar vacia");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: el salario debe ser un número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: ingreso cancelado por el usuario.");
        }
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);

        datos += "Honorarios por hora: " + honariosPorHora + "\n";
        datos += "Fecha termino del contrato: " + fechaTerminoContrato + "\n";

        System.out.println(datos);
    }
}
