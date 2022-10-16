package co.edu.uniquindio.progiii.preparcial.controllers;

import co.edu.uniquindio.progiii.preparcial.model.Estudiante;
import co.edu.uniquindio.progiii.preparcial.persistencia.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EstudianteController implements Initializable {

    @FXML
    private TextField txtNombreEstudiante;
    @FXML
    private TextField txtCodigoEstudiante;
    @FXML
    private TextField txtNota1;
    @FXML
    private TextField txtNota2;
    @FXML
    private TextField txtNota3;
    @FXML
    private TableView<Estudiante> tablaEstudiantes;
    @FXML
    private TableColumn columnaNombreEstudiante;
    @FXML
    private TableColumn columnaCodigoEstudiante;
    @FXML
    private TableColumn columnaNota1;
    @FXML
    private TableColumn columnaNota2;
    @FXML
    private TableColumn columnaNota3;
    @FXML
    private Label lblEstudiante;
    @FXML
    private Button btnAgregarEstudiante;
    @FXML
    private Button btnLimpiarEstudiante;

    ObservableList<Estudiante> estudiantes;

    @FXML
    private void AgregarEstudiante(ActionEvent event) throws IOException {
        lblEstudiante.setText("");
        try {
            Double.valueOf(txtNota1.getText());
            Double.valueOf(txtNota2.getText());
            Double.valueOf(txtNota3.getText());
        } catch (NumberFormatException e) {
            lblEstudiante.setText("Recuerde que las notas se dan en numeros");
        }
        if (txtNombreEstudiante.getText() != "" && txtCodigoEstudiante.getText() != "") {
            if ((Double.valueOf(txtNota1.getText()) >= 0 && Double.valueOf(txtNota1.getText()) <= 5) &&
                    (Double.valueOf(txtNota2.getText()) >= 0 && Double.valueOf(txtNota2.getText()) <= 5) &&
                    (Double.valueOf(txtNota3.getText()) >= 0 && Double.valueOf(txtNota3.getText()) <= 5)) {
                if (!ModelFactoryController.getInstance().verificarCodigoEstudiante(txtCodigoEstudiante.getText())) {
                    String nombreEstudiante = txtNombreEstudiante.getText();
                    String codigoEstudiante = txtCodigoEstudiante.getText();
                    Double nota1 = Double.valueOf(txtNota1.getText());
                    Double nota2 = Double.valueOf(txtNota2.getText());
                    Double nota3 = Double.valueOf(txtNota3.getText());
                    Estudiante estudiante = ModelFactoryController.getInstance().crearEstudiante(nombreEstudiante, codigoEstudiante, nota1, nota2, nota3);
                    ModelFactoryController.getInstance().guardarEstudianteArchivo(estudiante);
                    lblEstudiante.setText("Se ha guardado el estudiante!");
                    Persistencia.guardaRegistroLog("Se ha guardado el estudiante " + nombreEstudiante + " con exito", 1, "guardarEstudiante");
                    txtCodigoEstudiante.setText("");
                    txtNombreEstudiante.setText("");
                    txtNota1.setText("");
                    txtNota2.setText("");
                    txtNota3.setText("");
                    inicializarTabla();
                } else {
                    lblEstudiante.setText("Un estudiante con ese codigo ya existe");
                }
            } else {
                lblEstudiante.setText("Las notas deben estar entre 0 y 5");
            }
        } else {
            lblEstudiante.setText("Porfavor rellene todos los espacios");
        }
    }

    @FXML
    private void LimpiarEstudiante(ActionEvent event) {

        txtNombreEstudiante.setText("");
        txtCodigoEstudiante.setText("");
        txtNota1.setText("");
        txtNota2.setText("");
        txtNota3.setText("");
        tablaEstudiantes.getSelectionModel().clearSelection();

        btnAgregarEstudiante.setDisable(false);
        btnLimpiarEstudiante.setDisable(true);

    }

    private final ListChangeListener<Estudiante> selectorTablaEstudiantes = new ListChangeListener<Estudiante>() {
        @Override
        public void onChanged(Change<? extends Estudiante> c) {
            ponerEstudianteSeleccionado();
        }
    };

    public Estudiante getTablaEstudianteSeleccionado() {
        if (tablaEstudiantes != null) {
            List<Estudiante> tabla = tablaEstudiantes.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Estudiante competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    private void ponerEstudianteSeleccionado() {
        final Estudiante estudiante = getTablaEstudianteSeleccionado();

        if (estudiante != null) {
            txtNombreEstudiante.setText(estudiante.getNombre());
            txtCodigoEstudiante.setText(estudiante.getCodigo());
            txtNota1.setText(String.valueOf(estudiante.getNota1()));
            txtNota2.setText(String.valueOf(estudiante.getNota2()));
            txtNota3.setText(String.valueOf(estudiante.getNota3()));
            btnAgregarEstudiante.setDisable(true);
            btnLimpiarEstudiante.setDisable(false);
            lblEstudiante.setText("");
        }
    }

    private void inicializarTabla() {
        estudiantes = FXCollections.observableArrayList();
        estudiantes.addAll(ModelFactoryController.getInstance().getUniversidad().getEstudiantes());
        columnaNombreEstudiante.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombre"));
        columnaCodigoEstudiante.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("codigo"));
        columnaNota1.setCellValueFactory(new PropertyValueFactory<Estudiante, Double>("nota1"));
        columnaNota2.setCellValueFactory(new PropertyValueFactory<Estudiante, Double>("nota2"));
        columnaNota3.setCellValueFactory(new PropertyValueFactory<Estudiante, Double>("nota3"));


        tablaEstudiantes.setItems(estudiantes);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.inicializarTabla();

        final ObservableList<Estudiante> tablaEstudianteSel = tablaEstudiantes.getSelectionModel().getSelectedItems();
        tablaEstudianteSel.addListener(selectorTablaEstudiantes);
    }
}