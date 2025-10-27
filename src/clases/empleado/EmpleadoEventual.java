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
        super.registrarDatos();

        honariosPorHora = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
        fechaTerminoContrato = JOptionPane.showInputDialog("Ingrese fecha de  termino de contrato (dd/mm/aa)");
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);

        datos += "Honorarios por hora: " + honariosPorHora + "\n";
        datos += "Fecha termino del contrato: " + fechaTerminoContrato + "\n";

        System.out.println(datos);
    }
}
