/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa;

/**
 *
 * @author estudiante
 */
public class Cliente extends Persona {
    
    private String clienteID;
    private String empresa;

    public Cliente(String nombre, String direccion, String telefono, String clienteID, String empresa) {
        super(nombre, direccion, telefono);
        this.clienteID = clienteID;
        this.empresa = empresa;
    }

    public String getClienteID() { return clienteID; }
    public void setClienteID(String clienteID) { this.clienteID = clienteID; }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    
    public String toString() {
        return super.toString() +
               ", Cliente ID: " + clienteID +
               ", Empresa: " + empresa;
    }
}
