package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Paciente extends Persona {
    private Integer numeroHistoriaClinica;
    private String sexo;
    private String grupoSanguineo;
    private ArrayList<String> listaMedicamentosAlergico;

    public Integer getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(Integer numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public ArrayList<String> getListaMedicamentosAlergico() {
        return listaMedicamentosAlergico;
    }

    public void setListaMedicamentosAlergico(ArrayList<String> listaMedicamentosAlergico) {
        this.listaMedicamentosAlergico = listaMedicamentosAlergico;
    }

    @Override
    public void registrarDatos() {
        try {
            super.registrarDatos();

            listaMedicamentosAlergico = new ArrayList<>();
            String historiaInput = JOptionPane.showInputDialog("Ingrese el número de historia clínica");
            if (historiaInput == null || historiaInput.trim().isEmpty()) {
                throw new IllegalArgumentException("El número de historia clínica no puede estar vacío.");
            }
            numeroHistoriaClinica = Integer.parseInt(historiaInput);
            sexo = JOptionPane.showInputDialog("Ingrese en sexo");
            grupoSanguineo = JOptionPane.showInputDialog("Ingrese el grupo sanguineo");

            String pregunta = JOptionPane.showInputDialog("Es alergico a algun medicamento? Ingrese si o no");

            if (pregunta != null && pregunta.equalsIgnoreCase("si")) {
                String medicamento;
                String continuar;

                do {
                    medicamento = JOptionPane.showInputDialog("Ingrese el nombre del medicamento al que es alérgico");
                    if (medicamento != null && !medicamento.trim().isEmpty()) {
                        listaMedicamentosAlergico.add(medicamento.trim());
                    }

                    continuar = JOptionPane.showInputDialog("Ingrese 'si' si desea continuar");
                } while (continuar != null && continuar.equalsIgnoreCase("si"));
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: el número de historia clínica debe ser un valor numérico.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);

        datos = "Numero historia clinica: " + numeroHistoriaClinica + "\n";
        datos += "Sexo: " + sexo + "\n";
        datos += "Grupo sanguineo: " + grupoSanguineo + "\n";

        if (!listaMedicamentosAlergico.isEmpty()) {
            datos += "Lista de medicamentos a los que es alergico\n";

            for (int i = 0; i < listaMedicamentosAlergico.size(); i++) {
                datos += "\t" + listaMedicamentosAlergico.get(i) + "\n";
            }
        } else {
            System.out.println("El paciente, no es alergico a ningun medicamento");
        }

        System.out.println(datos);
    }
}
