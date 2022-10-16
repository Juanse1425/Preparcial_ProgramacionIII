package co.edu.uniquindio.progiii.preparcial.controllers;

import co.edu.uniquindio.progiii.preparcial.model.Estudiante;
import co.edu.uniquindio.progiii.preparcial.model.Programa;
import co.edu.uniquindio.progiii.preparcial.model.Universidad;
import co.edu.uniquindio.progiii.preparcial.persistencia.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class ModelFactoryController {

    Universidad universidad;

    private static ModelFactoryController instancia;

    private ModelFactoryController() {

        cargarDatosDesdeArchivos();

        if (Persistencia.cargarRecursoUniversidadXML() == null) {

            System.out.println("es null");
            guardarResourceXML();
            cargarResourceXML();

        }else{
            cargarResourceXML();
            guardarResourceXML();
        }

    }

    public static ModelFactoryController getInstance() {

        if (instancia == null) {

            instancia = new ModelFactoryController();

        }

        return instancia;

    }

    private void cargarDatosDesdeArchivos() {

        universidad = new Universidad();

        try {

            Persistencia.cargarDatosArchivos(getUniversidad());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }

    public void cargarResourceBinario() {

        universidad = Persistencia.cargarRecursoUniversidadBinario();

    }


    public void guardarResourceBinario() {

        Persistencia.guardarRecursoUniversidadBinario(universidad);

    }


    public void cargarResourceXML() {

        universidad = Persistencia.cargarRecursoUniversidadXML();

    }


    public void guardarResourceXML() {

        Persistencia.guardarRecursoUniversidadXML(universidad);

    }

    public Universidad getUniversidad() {

        return universidad;

    }

    public void setBanco(Universidad universidad) {

        this.universidad = universidad;

    }

    public Estudiante crearEstudiante(String nombre, String codigo, Double nota1, Double nota2, Double nota3) {

        Estudiante estudiante = getUniversidad().crearEstudiante(nombre, codigo, nota1, nota2, nota3);

        return estudiante;

    }

    public Programa crearPrograma(String nombre, String codigo, String modalidad) {

        Programa programa = getUniversidad().crearPrograma(nombre, codigo, modalidad);

        return programa;

    }

    public void guardarEstudianteArchivo(Estudiante estudiante) throws IOException {

        universidad.getEstudiantes().add(estudiante);
        Persistencia.guardarEstudiantes(universidad.getEstudiantes());
        Persistencia.guardarRecursoUniversidadXML(universidad);

    }

    public void guardarProgramaArchivo(Programa programa) throws IOException {

        universidad.getProgramas().add(programa);
        Persistencia.guardarProgramas(universidad.getProgramas());
        Persistencia.guardarRecursoUniversidadXML(universidad);

    }

    public boolean verificarCodigoEstudiante(String codigo) {

        if (getUniversidad().verificarExistenciaEstudiante(codigo)) {

            return true;

        }

        return false;

    }

    public boolean verificarCodigoPrograma(String codigo) {

        if (getUniversidad().verificarExistenciaPrograma(codigo)) {

            return true;

        }

        return false;

    }

    public ArrayList<String> cargarModalidades() throws IOException {

        ArrayList<String> modalidades = Persistencia.cargarModalidadesProperties();
        return modalidades;

    }

}
