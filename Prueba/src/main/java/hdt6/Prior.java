package hdt6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Prior {
    public static void main(String[] args) {
        PriorityQueue<Paciente> pacientes = new PriorityQueue<>();

        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String nombre = parts[0];
                    String sintoma = parts[1];
                    char codigoEmergencia = parts[2].charAt(0);
                    pacientes.add(new Paciente(nombre, sintoma, codigoEmergencia));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Orden de atención de los pacientes:");
        while (!pacientes.isEmpty()) {
            Paciente paciente = pacientes.poll();
            System.out.println(paciente);
        }
    }
}
