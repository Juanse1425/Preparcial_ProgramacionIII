package co.edu.uniquindio.progiii.preparcial.model;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Programa implements Serializable {

    public SimpleStringProperty nombre = new SimpleStringProperty();
    public SimpleStringProperty codigo = new SimpleStringProperty();
    public SimpleStringProperty modalidad = new SimpleStringProperty();

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

    public String getModalidad() {
        return modalidad.get();
    }

    public SimpleStringProperty modalidadProperty() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad.set(modalidad);
    }
}