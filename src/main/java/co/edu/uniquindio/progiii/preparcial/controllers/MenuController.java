package co.edu.uniquindio.progiii.preparcial.controllers;

import co.edu.uniquindio.progiii.preparcial.application.Application;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void AbrirEstudiantesView() {

        Application.AbrirEstudiantesView();

    }

    @FXML
    private void AbrirProgramasView() {

        Application.AbrirProgramasView();
        
    }
}
