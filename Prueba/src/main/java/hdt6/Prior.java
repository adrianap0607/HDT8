package hdt6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Clase que maneja la prioridad de atención de pacientes utilizando una cola de prioridad.
 */
public class Prior {
    /**
     * Método principal del programa.
     * Lee la lista de pacientes desde un archivo, los agrega a una cola de prioridad
     * y luego imprime el orden de atención de los pacientes.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        // Crear una cola de prioridad para almacenar los pacientes
        PriorityQueue<Paciente> pacientes = new PriorityQueue<>();

        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String line;
            // Leer el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Dividir la línea en partes utilizando la coma y el espacio como delimitador
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    // Si la línea contiene tres partes, se considera válida
                    // La primera parte es el nombre, la segunda parte es el síntoma y la tercera es el código de emergencia
                    String nombre = parts[0];
                    String sintoma = parts[1];
                    char codigoEmergencia = parts[2].charAt(0);
                    // Crear un nuevo paciente y agregarlo a la cola de prioridad
                    pacientes.add(new Paciente(nombre, sintoma, codigoEmergencia));
                }
            }
        } catch (IOException e) {
            // Imprimir cualquier excepción que ocurra durante la lectura del archivo
            e.printStackTrace();
        }

        // Imprimir el orden de atención de los pacientes
        System.out.println("Orden de atención de los pacientes:");
        while (!pacientes.isEmpty()) {
            // Remover y obtener el próximo paciente de mayor prioridad de la cola de prioridad
            Paciente paciente = pacientes.poll();
            // Imprimir los detalles del paciente
            System.out.println(paciente);
        }
    }
}
