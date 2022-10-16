package co.edu.uniquindio.progiii.preparcial.persistencia;

import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import co.edu.uniquindio.progiii.preparcial.model.Universidad;
import co.edu.uniquindio.progiii.preparcial.model.Estudiante;
import co.edu.uniquindio.progiii.preparcial.model.Programa;


public class Persistencia {

    public static final String RUTA_ARCHIVO_ESTUDIANTES = "src/main/resources/archivos/archivoEstudiantes.txt";
    public static final String RUTA_ARCHIVO_PROGRAMAS = "src/main/resources/archivos/archivoProgramas.txt";
    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/archivos/UniversidadLog.txt";
    public static final String RUTA_ARCHIVO_MODELO_UNIVERSIDAD_BINARIO = "src/main/resources/archivos/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML = "src/main/resources/archivos/model.xml";
    private static final String RUTA_ARCHIVO_PROPERTIES_MODALIDADES = "src/main/resources/archivos/modalidades.properties";


    public static void cargarDatosArchivos(Universidad universidad) throws FileNotFoundException, IOException {

        ArrayList<Estudiante> estudiantesCargados = cargarEstudiantes();

        if (estudiantesCargados.size() > 0) {

            universidad.getEstudiantes().addAll(estudiantesCargados);

        }

    }

//	----------------------LOADS------------------------

    /**
     * @return un Arraylist de estudiantes con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */

    public static ArrayList<Estudiante> cargarEstudiantes() throws FileNotFoundException, IOException {

        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ESTUDIANTES);

        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {

            linea = contenido.get(i);

            Estudiante estudiante = new Estudiante();

            estudiante.setNombre(linea.split(",")[0]);
            estudiante.setCodigo(linea.split(",")[1]);
            estudiante.setNota1(Double.valueOf(linea.split(",")[2]));
            estudiante.setNota2(Double.valueOf(linea.split(",")[3]));
            estudiante.setNota3(Double.valueOf(linea.split(",")[4]));

            estudiantes.add(estudiante);

        }

        return estudiantes;

    }

    public static ArrayList<String> cargarModalidadesProperties() throws IOException {

        ArrayList<String> modalidades = ArchivoUtil.leerProperties(RUTA_ARCHIVO_PROPERTIES_MODALIDADES);

        return modalidades;

    }

//	----------------------SAVES------------------------

    /**
     * Guarda en un archivo de texto todos la información de los estudiantes almacenadas en el ArrayList
     *
     * @param listaEstudiantes
     * @throws IOException
     */

    public static void guardarEstudiantes(ArrayList<Estudiante> listaEstudiantes) throws IOException {

        String contenido = "";

        for (Estudiante estudiante : listaEstudiantes) {

            contenido += estudiante.getNombre() + "," + estudiante.getCodigo() + "," + estudiante.getNota1() + "," + estudiante.getNota2()
                    + "," + estudiante.getNota3() + "\n";

        }

        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTES, contenido, false);

    }

    /**
     * Guarda en un archivo de texto todos la información de los programas almacenadas en el ArrayList
     *
     * @param listaProgramas
     * @throws IOException
     */

    public static void guardarProgramas(ArrayList<Programa> listaProgramas) throws IOException {

        String contenido = "";

        for (Programa programa : listaProgramas) {

            contenido += programa.getNombre() + "," + programa.getCodigo() + "," + programa.getModalidad() + "\n";

        }

        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PROGRAMAS, contenido, false);

    }

    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {

        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }

    //------------------------------------SERIALIZACIÓN  y XML

    public static Universidad cargarRecursoUniversidadBinario() {

        Universidad universidad = null;

        try {

            universidad = (Universidad) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_BINARIO);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return universidad;

    }

    public static void guardarRecursoUniversidadBinario(Universidad universidad) {

        try {

            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_BINARIO, universidad);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static Universidad cargarRecursoUniversidadXML() {

        Universidad universidad = null;

        try {

            universidad = (Universidad) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return universidad;

    }

    public static void guardarRecursoUniversidadXML(Universidad universidad) {

        try {

            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML, universidad);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}