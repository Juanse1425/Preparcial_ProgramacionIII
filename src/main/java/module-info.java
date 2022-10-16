module Preparcial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    exports co.edu.uniquindio.progiii.preparcial.controllers;
    opens co.edu.uniquindio.progiii.preparcial.controllers to javafx.fxml;
    exports co.edu.uniquindio.progiii.preparcial.application;
    opens co.edu.uniquindio.progiii.preparcial.application to javafx.fxml;
    exports co.edu.uniquindio.progiii.preparcial.model;
    opens co.edu.uniquindio.progiii.preparcial.model to javafx.fxml;
}