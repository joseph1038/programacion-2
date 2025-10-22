package parcial;

public abstract class Vuelo {
    protected String numeroVuelo;
    protected String origen;
    protected String destino;
    protected String fecha;
    protected String horaSalida;
    protected String horaLlegada;

    public Vuelo(String numeroVuelo, String origen, String destino, String fecha, String horaSalida, String horaLlegada) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public String getNumeroVuelo() { return numeroVuelo; }
    public String getItinerario() {
        return "Origen: " + origen + ", Destino: " + destino + ", Fecha: " + fecha + ", Salida: " + horaSalida + ", Llegada: " + horaLlegada;
    }
    public void setItinerario(String origen, String destino, String fecha, String horaSalida, String horaLlegada) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        return "Vuelo [Numero: " + numeroVuelo + ", " + getItinerario() + "]";
    }
}