package co.edu.uniquindio.progiii.preparcial.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Estudiante implements Serializable {

    public SimpleStringProperty nombre = new SimpleStringProperty();
    public SimpleStringProperty codigo = new SimpleStringProperty();
    public SimpleDoubleProperty nota1 = new SimpleDoubleProperty();
    public SimpleDoubleProperty nota2 = new SimpleDoubleProperty();
    public SimpleDoubleProperty nota3 = new SimpleDoubleProperty();

    public Estudiante() {
    }

    public Estudiante(SimpleStringProperty nombre, SimpleStringProperty codigo, SimpleDoubleProperty nota1, SimpleDoubleProperty nota2, SimpleDoubleProperty nota3) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getCodigo() {
        return codigo.get();
    }

    public SimpleStringProperty codigoProperty() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }

    public double getNota1() {
        return nota1.get();
    }

    public SimpleDoubleProperty nota1Property() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1.set(nota1);
    }

    public double getNota2() {
        return nota2.get();
    }

    public SimpleDoubleProperty nota2Property() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2.set(nota2);
    }

    public double getNota3() {
        return nota3.get();
    }

    public SimpleDoubleProperty nota3Property() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3.set(nota3);
    }
}
