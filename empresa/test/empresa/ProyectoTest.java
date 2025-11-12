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
public class ProyectoTest {
    
    @Test
    public void test1_CrearPersona(){
        Persona persona = new Persona("Juan", "Calle 123", "555-1234");
        
        assertNotNull(persona);
    }
    
    @Test
    public void test2_GetNombre(){
        Persona persona = new Persona("Juan", "Calle 123", "555-1234");
        
        assertEquals("Juan", persona.getNombre());
    }
    //probar metodo constructor creando un proyecto
    @Test
    public void test1_CrearProyecto(){
        Proyecto proyecto = new Proyecto("P001", "Alpha", "Descripcion", "2024-01-01", "2024-12-31");
        
        assertNotNull(proyecto);
        
    }
    public ProyectoTest() {
    }
    //probar metodo getld
    @Test
    public void test2_GetProyectoID(){
        Proyecto proyecto = new Proyecto ("P001", "Alpha", "Descripcion", "2024-01-01", "2024-12-31");
        
        assertEquals("P001", proyecto.getProyectoID());
    }
    
   

    @Test
    public void testSomeMethod() {
    }
    
}
