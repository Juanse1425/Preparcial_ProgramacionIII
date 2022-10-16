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

        estudiante.setNombre(nombre);
        estudiante.setCodigo(codigo);
        estudiante.setNota1(nota1);
        estudiante.setNota2(nota2);
        estudiante.setNota3(nota3);

        return estudiante;

    }

    public Programa crearPrograma(String nombre, String codigo, String modalidad) {

        Programa programa = new Programa();

        programa.setNombre(nombre);
        programa.setCodigo(codigo);
        programa.setModalidad(modalidad);

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
