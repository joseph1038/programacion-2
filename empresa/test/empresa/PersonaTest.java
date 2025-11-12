/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package empresa;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author estudiante
 */
public class PersonaTest {
    
    @Test
    public void test1_CrearPersona(){
        Persona persona = new Persona("Juan", "Calle 123", "555-1234") {};
        
        assertNotNull (persona);
    }
    
    @Test
    public void test2_GetNombre(){
        Persona persona = new Persona("Juan", "Calle 123", "555-1234");
        
        assertEquals("Juan", persona.getNombre());
    }
    
    public PersonaTest() {
    }

    @Test
    public void testSomeMethod() {
    }
    
}
