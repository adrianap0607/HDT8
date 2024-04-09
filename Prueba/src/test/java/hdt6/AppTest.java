package hdt6;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {
    
    @Test
    public void testPacienteCreation() {
        Paciente paciente = new Paciente("Juan Perez", "fractura de pierna", 'C');
        assertNotNull(paciente);
        assertEquals("Juan Perez", paciente.getNombre());
        assertEquals("fractura de pierna", paciente.getSintoma());
        assertEquals('C', paciente.getCodigoEmergencia());
    }
    
    @Test
    public void testPacienteComparison() {
        Paciente pacienteA = new Paciente("Maria Ramirez", "apendicitis", 'A');
        Paciente pacienteB = new Paciente("Carmen Sarmientos", "dolores de parto", 'B');
        Paciente pacienteC = new Paciente("Juan Perez", "fractura de pierna", 'C');
        
        assertTrue(pacienteA.compareTo(pacienteB) < 0);
        assertTrue(pacienteB.compareTo(pacienteC) < 0);
        assertTrue(pacienteA.compareTo(pacienteC) < 0);
    }
    
    @Test
    public void testVectorHeapBasicOperations() {
        VectorHeap<Paciente> pacientes = new VectorHeap<>();
        assertTrue(pacientes.isEmpty());
        assertEquals(0, pacientes.size());
        
        pacientes.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        pacientes.add(new Paciente("Carmen Sarmientos", "dolores de parto", 'B'));
        pacientes.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        
        assertFalse(pacientes.isEmpty());
        assertEquals(3, pacientes.size());
        
        assertEquals("Maria Ramirez, apendicitis, A", pacientes.peek().toString());
        
        Paciente pacienteAtendido = pacientes.remove();
        assertEquals("Maria Ramirez, apendicitis, A", pacienteAtendido.toString());
        assertEquals(2, pacientes.size());
        
        pacienteAtendido = pacientes.remove();
        assertEquals("Carmen Sarmientos, dolores de parto, B", pacienteAtendido.toString());
        assertEquals(1, pacientes.size());
    }
}
