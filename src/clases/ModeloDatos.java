package clases;

import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ModeloDatos {
    HashMap<String, Paciente> pacientesMap;
    HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
    HashMap<String, EmpleadoEventual> empleadosEventualMap;
    HashMap<String, Medico> medicosMap;
    ArrayList<CitaMedica> citasList;

    public ModeloDatos() {
        pacientesMap = new HashMap<>();
        empleadosPlanillaMap = new HashMap<>();
        empleadosEventualMap = new HashMap<>();
        medicosMap = new HashMap<>();
        citasList = new ArrayList<>();
    }

    /* Registrar */

    public void registrarPersona(Paciente miPaciente) {
        if (pacientesMap.containsKey(miPaciente.getNumeroDeDNI())) {
            System.out.println("El paciente con DNI " + miPaciente.getNumeroDeDNI() + " Ya esta registrado");
            return;
        }

        pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
        System.out.println("Se ha registrado el paciente " + miPaciente.getNombre() + " Satisfactoriamente");
    }

    public void registrarPersona(EmpleadoPlanilla miEmpPlanilla) {
        if (empleadosPlanillaMap.containsKey(miEmpPlanilla.getNumeroDeDNI())) {
            System.out.println("El empleado por planilla " + miEmpPlanilla.getNumeroDeDNI() + " Ya esta registrado");
            return;
        }

        empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
        System.out.println(
                "Se ha registrado el empleado por planilla " + miEmpPlanilla.getNombre() + " Satisfactoriamente");
    }

    public void registrarPersona(EmpleadoEventual miEmpEventual) {
        if (empleadosEventualMap.containsKey(miEmpEventual.getNumeroDeDNI())) {
            System.out.println(
                    "Se ha registrado el empleado por eventual" + miEmpEventual.getNombre() + " Satisfactoriamente");
            return;
        }

        empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
        System.out
                .println("Se ha registrado el empleado eventual " + miEmpEventual.getNombre() + " Satisfactoriamente");
    }

    public void registrarPersona(Medico miMedico) {
        if (medicosMap.containsKey(miMedico.getNumeroDeDNI())) {
            System.out.println("El medico con DNI " + miMedico.getNumeroDeDNI() + " Ya esta registrado");
            return;
        }
        medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
        System.out.println("Se ha registrado el medico  " + miMedico.getNombre() + " Satisfactoriamente");
    }

    public void registrarCitaMedica(CitaMedica miCita) {
        citasList.add(miCita);
        System.out.println("Se ha registrado la cita exitosamente\n");
        System.out.println(miCita.informacionCitaMedica());
    }

    /* Imprimir */

    public void imprimirPacientes() {
        if (pacientesMap.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        String msj = "PACIENTES REGISTRADOS\n";
        Iterator<String> iterador = pacientesMap.keySet().iterator();

        while (iterador.hasNext()) {
            String clave = iterador.next();
            pacientesMap.get(clave).imprimirDatosPersona(msj);
        }
    }

    public void imprimirEmpleadosEventuales() {
        if (empleadosEventualMap.isEmpty()) {
            System.out.println("No hay empleados eventuales registrados.");
            return;
        }
        String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";

        for (String clave : empleadosEventualMap.keySet()) {
            empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
        }
    }

    public void imprimirEmpleadosPorPlanilla() {
        // Verificar si hay registros
        if (empleadosPlanillaMap.isEmpty() && medicosMap.isEmpty()) {
            System.out.println("No hay empleados ni médicos registrados.");
            return;
        }

        // Mostrar empleados por planilla
        if (!empleadosPlanillaMap.isEmpty()) {
            System.out.println("=== EMPLEADOS POR PLANILLA REGISTRADOS ===");
            for (EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
                empleadoPlanilla.imprimirDatosPersona("");
            }
        }

        // Mostrar médicos
        if (!medicosMap.isEmpty()) {
            System.out.println("\n=== MÉDICOS REGISTRADOS (también empleados por planilla) ===");
            for (Medico medico : medicosMap.values()) {
                medico.imprimirDatosPersona("");
            }
        }
    }

    public void imprimirMedicos() {

        if (medicosMap.isEmpty()) {
            System.out.println("No hay médicos registrados.");
            return;
        }
        String msj = "MÉDICOS REGISTRADOS\n";

        for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
            // System.out.println("Key = " + elemento.getKey() + ", Value = " +
            // elemento.getValue());
            // medicosMap.get(elemento.getKey()).imprimirDatosPersona(msj);
            elemento.getValue().imprimirDatosPersona(msj);
        }
    }

    public void imprimirCitasMedicasProgramadas() {
        if (citasList.isEmpty()) {
            System.out.println("No hay citas médicas programadas.");
            return;
        }

        String msj = "CITAS MEDICAS PROGRAMADAS\n";
        CitaMedica miCita;

        System.out.println(msj + "\n");

        if (citasList.size() > 0) {
            for (int i = 0; i < citasList.size(); i++) {
                miCita = citasList.get(i);
                System.out.println(miCita.informacionCitaMedica());
            }
        } else {
            System.out.println("No existen citas programadas");
        }
    }

    /* Consultar por ID */
    public Paciente consultarPacientesPorDocumento(String documentoPaciente) {
        Paciente miPaciente = null;

        if (pacientesMap.containsKey(documentoPaciente)) {
            miPaciente = pacientesMap.get(documentoPaciente);
        }

        return miPaciente;
    }

    public EmpleadoEventual consultarEmpleadoEventualPorDocumento(String documentoEmpleadoEventual) {
        EmpleadoEventual miEmpleadoEventual = null;

        if (empleadosEventualMap.containsKey(documentoEmpleadoEventual)) {
            miEmpleadoEventual = empleadosEventualMap.get(documentoEmpleadoEventual);
        }

        return miEmpleadoEventual;
    }

    public EmpleadoPlanilla consultarEmpleadoPlanillaPorDocumento(String documentoEmpleadoPlanilla) {
        EmpleadoPlanilla miEmpleadoPlanilla = null;

        if(empleadosPlanillaMap.containsKey(documentoEmpleadoPlanilla)) {
            miEmpleadoPlanilla = empleadosPlanillaMap.get(documentoEmpleadoPlanilla);
        }
        return miEmpleadoPlanilla;
    }

    public Medico consultarMedidoPorDocumento(String documentoMedico) {
        Medico miMedico = null;

        if(medicosMap.containsKey(documentoMedico)) {
            miMedico = medicosMap.get(documentoMedico);
        }

        return miMedico; 
    }

    public Medico consultarMedicoPorNombre(String nombreMedico) {
        for (Medico medico : medicosMap.values()) {

            if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
                return medico;
            }
        }

        return null;
    }

}
