/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class Empleado extends Persona {
    
    private String empleadoID;
    private double salario;
    private List<Proyecto> proyectos;

    public Empleado(String nombre, String direccion, String telefono, String empleadoID, double salario) {
        super(nombre, direccion, telefono);
        this.empleadoID = empleadoID;
        this.salario = salario;
        this.proyectos = new ArrayList<>();
    }

    public String getEmpleadoID() { return empleadoID; }
    public void setEmpleadoID(String empleadoID) { this.empleadoID = empleadoID; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public List<Proyecto> getProyectos() { return proyectos; }

    public void addProyecto(Proyecto p) {
        proyectos.add(p);
    }

    public void removeProyecto(Proyecto p) {
        proyectos.remove(p);
    }

    
    public String toString() {
        return super.toString() +
               ", Empleado ID: " + empleadoID +
               ", Salario: " + salario +
               ", Proyectos: " + proyectos.size();
    }
}
