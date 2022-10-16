package co.edu.uniquindio.progiii.preparcial.controllers;

import co.edu.uniquindio.progiii.preparcial.model.Programa;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProgramaController implements Initializable {

    @FXML
    private TextField txtNombrePrograma;
    @FXML
    private TextField txtCodigoPrograma;
    @FXML
    private ChoiceBox cbModalidadPrograma;
    ObservableList<String> opciones = FXCollections.observableArrayList();
    ArrayList<String> modalidades = ModelFactoryController.getInstance().cargarModalidades();
    @FXML
    private TableView<Programa> tablaProgramas;
    @FXML
    private TableColumn columnaNombrePrograma;
    @FXML
    private TableColumn columnaCodigoPrograma;
    @FXML
    private TableColumn columnaModalidadPrograma;
    @FXML
    private Label lblPrograma;
    @FXML
    private Button btnAgregarPrograma;
    @FXML
    private Button btnLimpiarPrograma;

    ObservableList<Programa> programas;

    public ProgramaController() throws IOException {
    }

    @FXML
    private void AgregarPrograma(ActionEvent event) throws IOException {

        lblPrograma.setText("");

        if (txtNombrePrograma.getText() != "" && txtCodigoPrograma.getText() != "") {

            if (!ModelFactoryController.getInstance().verificarCodigoPrograma(txtCodigoPrograma.getText())) {

                String nombrePrograma = txtNombrePrograma.getText();
                String codigoPrograma = txtCodigoPrograma.getText();
                String modalidadPrograma = cbModalidadPrograma.getValue().toString();

                Programa programa = ModelFactoryController.getInstance().crearPrograma(nombrePrograma, codigoPrograma, modalidadPrograma);

                ModelFactoryController.getInstance().guardarProgramaArchivo(programa);

                lblPrograma.setText("Se ha guardado el estudiante!");

                Persistencia.guardaRegistroLog("Se ha guardado el programa " + nombrePrograma + " con exito", 1, "guardarPrograma");

                txtNombrePrograma.setText("");
                txtCodigoPrograma.setText("");
                cbModalidadPrograma.setValue(opciones.get(0));

                inicializarTabla();

            } else {

                lblPrograma.setText("Un programa con ese codigo ya existe");

            }

        } else {

            lblPrograma.setText("Por favor rellene todos los espacios");

        }

    }

    @FXML
    private void LimpiarPrograma(ActionEvent event) {

        txtNombrePrograma.setText("");
        txtCodigoPrograma.setText("");
        cbModalidadPrograma.setValue(opciones.get(0));

        tablaProgramas.getSelectionModel().clearSelection();

        btnAgregarPrograma.setDisable(false);
        btnLimpiarPrograma.setDisable(true);

    }

    private final ListChangeListener<Programa> selectorTablaProgramas = new ListChangeListener<Programa>() {

        @Override
        public void onChanged(Change<? extends Programa> c) {

            ponerProgramaSeleccionado();

        }

    };

    public Programa getTablaProgramaSeleccionado() {

        if (tablaProgramas != null) {

            List<Programa> tabla = tablaProgramas.getSelectionModel().getSelectedItems();

            if (tabla.size() == 1) {

                final Programa programaSeleccionado = tabla.get(0);

                return programaSeleccionado;

            }

        }

        return null;

    }

    private void ponerProgramaSeleccionado() {

        final Programa programa = getTablaProgramaSeleccionado();

        if (programa != null) {

            txtNombrePrograma.setText(programa.getNombre());
            txtCodigoPrograma.setText(programa.getCodigo());
            cbModalidadPrograma.setValue(programa.getModalidad());

            btnAgregarPrograma.setDisable(true);
            btnLimpiarPrograma.setDisable(false);

            lblPrograma.setText("");

        }

    }

    private void inicializarTabla() {

        programas = FXCollections.observableArrayList();
        programas.addAll(ModelFactoryController.getInstance().getUniversidad().getProgramas());

        columnaNombrePrograma.setCellValueFactory(new PropertyValueFactory<Programa, String>("nombre"));
        columnaCodigoPrograma.setCellValueFactory(new PropertyValueFactory<Programa, String>("codigo"));
        columnaModalidadPrograma.setCellValueFactory(new PropertyValueFactory<Programa, Double>("modalidad"));

        tablaProgramas.setItems(programas);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i < modalidades.size(); i++) {

            opciones.add(modalidades.get(i));

        }

        cbModalidadPrograma.setValue(opciones.get(0));
        cbModalidadPrograma.setItems(opciones);

        this.inicializarTabla();

        final ObservableList<Programa> tablaProgramaSel = tablaProgramas.getSelectionModel().getSelectedItems();
        tablaProgramaSel.addListener(selectorTablaProgramas);

    }
}