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

    public void setNombre(String nombre) {

        this.nombre.set(nombre);

    }

    public void setCodigo(String codigo) {

        this.codigo.set(codigo);

    }

    public void setNota1(double nota1) {

        this.nota1.set(nota1);

    }

    public void setNota2(double nota2) {

        this.nota2.set(nota2);
    }

    public void setNota3(double nota3) {

        this.nota3.set(nota3);

    }

    public String getNombre() {

        return nombre.get();

    }

    public String getCodigo() {

        return codigo.get();

    }

    public double getNota1() {

        return nota1.get();

    }

    public double getNota2() {

        return nota2.get();

    }

    public double getNota3() {

        return nota3.get();

    }


}
