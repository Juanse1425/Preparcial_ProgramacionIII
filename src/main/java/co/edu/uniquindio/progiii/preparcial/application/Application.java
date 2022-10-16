package co.edu.uniquindio.progiii.preparcial.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/view/MenuView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menú");
        stage.setScene(scene);
        stage.show();
    }

    public static void AbrirEstudiantesView() {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/view/EstudiantesView.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Estudiantes");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void AbrirProgramasView() {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/view/ProgramasView.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Programas");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}