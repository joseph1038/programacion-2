package Model;

public class Ciudad {
    String idCiudad,nomCiudad;
    int habitantes;
    Departamento objDepto = new Departamento();

    public Ciudad() {
    }

    public Ciudad(String idCiudad, String nomCiudad, int habitantes, Departamento objDepto) {
        this.idCiudad = idCiudad;
        this.nomCiudad = nomCiudad;
        this.habitantes = habitantes;
        this.objDepto = objDepto;
        
    }

    public String getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public Departamento getObjDepto() {
        return objDepto;
    }

    public void setObjDepto(Departamento objDepto) {
        this.objDepto = objDepto;
    }
    
    
}
