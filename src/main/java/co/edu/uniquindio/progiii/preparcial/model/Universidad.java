package co.edu.uniquindio.progiii.preparcial.model;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Universidad implements Serializable {

    ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
    ArrayList<Programa> programas = new ArrayList<Programa>();

    public Universidad() {
    }

    public ArrayList<Estudiante> getEstudiantes() {

        return estudiantes;

    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {

        this.estudiantes = estudiantes;

    }

    public ArrayList<Programa> getProgramas() {

        return programas;

    }

    public void setProgramas(ArrayList<Programa> programas) {

        this.programas = programas;

    }

    public Estudiante crearEstudiante(String nombre, String codigo, Double nota1, Double nota2, Double nota3) {

        Estudiante estudiante = new Estudiante();

        estudiante.nombre.set(nombre);
        estudiante.codigo.set(codigo);
        estudiante.nota1.set(nota1);
        estudiante.nota2.set(nota2);
        estudiante.nota3.set(nota3);

        return estudiante;

    }

    public Programa crearPrograma(String nombre, String codigo, String modalidad) {


        Programa programa = new Programa();

        programa.nombre.set(nombre);
        programa.codigo.set(codigo);
        programa.modalidad.set(modalidad);

        return programa;

    }

    public boolean verificarExistenciaEstudiante(String codigo) {

        for (int i = 0; i < getEstudiantes().size(); i++) {

            if (getEstudiantes().get(i).getCodigo().equals(codigo)) {

                return true;

            }

        }

        return false;

    }

    public boolean verificarExistenciaPrograma(String codigo) {

        for (int i = 0; i < getProgramas().size(); i++) {

            if (getProgramas().get(i).getCodigo().equals(codigo)) {

                return true;

            }

        }

        return false;

    }
}
