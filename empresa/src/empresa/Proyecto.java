/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa;

/**
 *
 * @author estudiante
 */
public class Proyecto {
    private String proyectoID;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;

    public Proyecto(String proyectoID, String nombre, String descripcion, String fechaInicio, String fechaFin) {
        this.proyectoID = proyectoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getProyectoID() { return proyectoID; }
    public void setProyectoID(String proyectoID) { this.proyectoID = proyectoID; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }

    
    public String toString() {
        return "Proyecto ID: " + proyectoID + 
               ", Nombre: " + nombre +
               ", Descripción: " + descripcion + 
               ", Fecha Inicio: " + fechaInicio + 
               ", Fecha Fin: " + fechaFin;
    }
}
    

