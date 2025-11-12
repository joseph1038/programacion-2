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
public class EmpleadoTest {
    //Para probar que el empleado se cree correctamente
    @Test
    public void test1_CrearEmpleado(){
        Empleado empleado = new Empleado("Juan", "Calle 123", "555-1234", "E001", 3000.00);
        
        assertNotNull(empleado);
    }
    //probar que la lista de proyectos del empleado empiece vacia al crearlo
    @Test
    public void test2_ListaVaciaAlInicio(){
        Empleado empleado = new Empleado("Juan", "Calle 123", "555-1234", "E001", 3000.00);
        
        assertEquals(0, empleado.getProyectos().size());
    }
    //para probar que se puede agregar  proyecto correctamente
    @Test
    public void test3_AgregarProyecto(){
        Empleado empleado = new Empleado("Juan", "Calle 123", "555-1234", "E001", 3000.00);
        
        Proyecto proyecto = new Proyecto("P001", "Alpha", "Descripcion", "2024-01-01", "2024-12-31");
        
        empleado.addProyecto(proyecto);
        
        assertEquals(1, empleado.getProyectos().size());
    }
    public EmpleadoTest() {
    }

    @Test
    public void testSomeMethod() {
    }
    
}
