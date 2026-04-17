/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author estudiante
 */
public class Empleado {
    int idEmp;
    String nomEmp;
    String Depto;
    int salario;

    public Empleado() {
    }

    public Empleado(int idEmp, String nomEmp, String Depto, int salario) {
        this.idEmp = idEmp;
        this.nomEmp = nomEmp;
        this.Depto = Depto;
        this.salario = salario;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public String getDepto() {
        return Depto;
    }

    public int getSalario() {
        return salario;
    }
    
    public void setSalario(int salario) {
    this.salario = salario;
    }
    
    public String toString() {
    return "Empleado{" +
            "idEmp=" + idEmp +
            ", nomEmp='" + nomEmp + '\'' +
            ", depto='" + Depto + '\'' +
            ", salario=" + salario +
            '}';
}
}

