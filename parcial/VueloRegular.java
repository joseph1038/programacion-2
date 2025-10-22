package parcial;

public class VueloRegular extends Vuelo {
    private double distanciaRecorrida;

    public VueloRegular(String numeroVuelo, String origen, String destino, String fecha, String horaSalida, String horaLlegada, double distanciaRecorrida) {
        super(numeroVuelo, origen, destino, fecha, horaSalida, horaLlegada);
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public double getDistanciaRecorrida() { return distanciaRecorrida; }

    @Override
    public String toString() {
        return super.toString() + ", Distancia: " + distanciaRecorrida + " km";
    }
}