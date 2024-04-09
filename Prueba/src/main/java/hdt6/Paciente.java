package hdt6;

/**
 * Clase que representa a un paciente en un sistema de atención médica de emergencia.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre; // Nombre del paciente
    private String sintoma; // Síntoma del paciente
    private char codigoEmergencia; // Código de emergencia del paciente

    /**
     * Constructor de la clase Paciente.
     * @param nombre Nombre del paciente.
     * @param sintoma Síntoma del paciente.
     * @param codigoEmergencia Código de emergencia del paciente.
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    /**
     * Obtiene el nombre del paciente.
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el síntoma del paciente.
     * @return El síntoma del paciente.
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Obtiene el código de emergencia del paciente.
     * @return El código de emergencia del paciente.
     */
    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    /**
     * Compara este paciente con otro paciente basado en su código de emergencia.
     * @param otro El otro paciente con el que se compara.
     * @return Un valor negativo si este paciente tiene un código de emergencia menor que el otro,
     *         cero si ambos pacientes tienen el mismo código de emergencia,
     *         o un valor positivo si este paciente tiene un código de emergencia mayor que el otro.
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }

    /**
     * Devuelve una representación en cadena de este paciente.
     * @return Una cadena que contiene el nombre, síntoma y código de emergencia del paciente.
     */
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}
