package parcial;

public class VueloVIP extends Vuelo {
    private String serviciosAdicionales;
    private double precioServicioAdicional;

    public VueloVIP(String numeroVuelo, String origen, String destino, String fecha, String horaSalida, String horaLlegada, String serviciosAdicionales, double precioServicioAdicional) {
        super(numeroVuelo, origen, destino, fecha, horaSalida, horaLlegada);
        this.serviciosAdicionales = serviciosAdicionales;
        this.precioServicioAdicional = precioServicioAdicional;
    }

    public String getServiciosAdicionales() { return serviciosAdicionales; }
    public double getPrecioServicioAdicional() { return precioServicioAdicional; }

    @Override
    public String toString() {
        return super.toString() + ", Servicios: " + serviciosAdicionales + ", Precio Extra: $" + precioServicioAdicional;
    }
}