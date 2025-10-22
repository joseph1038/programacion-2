package parcial;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Aerolinea {
    private ArrayList<Vuelo> vuelos = new ArrayList<>();
    private static final String ARCHIVO = "vuelos.txt";
    private static final int MAX_VUELOS = 50;

    public static void main(String[] args) {
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.cargarVuelos();

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            aerolinea.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    aerolinea.agregarVuelo(scanner);
                    break;
                case 2:
                    aerolinea.eliminarVuelo(scanner);
                    break;
                case 3:
                    aerolinea.visualizarVuelos();
                    break;
                case 4:
                    aerolinea.guardarVuelos();
                    break;
                case 5:
                    aerolinea.cargarVuelos();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n=== Menú de la Aerolínea Privada ===");
        System.out.println("1. Agregar vuelo");
        System.out.println("2. Eliminar vuelo");
        System.out.println("3. Visualizar vuelos");
        System.out.println("4. Guardar vuelos");
        System.out.println("5. Cargar vuelos");
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
    }

    private void agregarVuelo(Scanner scanner) {
        if (vuelos.size() >= MAX_VUELOS) {
            System.out.println("Límite de 50 vuelos alcanzado.");
            return;
        }
        System.out.print("Ingrese número de vuelo: ");
        String numero = scanner.nextLine();
        System.out.print("Ingrese origen: ");
        String origen = scanner.nextLine();
        System.out.print("Ingrese destino: ");
        String destino = scanner.nextLine();
        System.out.print("Ingrese fecha (dd/mm/yyyy): ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese hora de salida: ");
        String horaSalida = scanner.nextLine();
        System.out.print("Ingrese hora de llegada: ");
        String horaLlegada = scanner.nextLine();
        System.out.print("Tipo de vuelo (Regular/VIP): ");
        String tipo = scanner.nextLine();

        if (tipo.equalsIgnoreCase("Regular")) {
            System.out.print("Ingrese distancia recorrida (km): ");
            double distancia = scanner.nextDouble();
            scanner.nextLine(); // Consumir salto de línea
            vuelos.add(new VueloRegular(numero, origen, destino, fecha, horaSalida, horaLlegada, distancia));
        } else if (tipo.equalsIgnoreCase("VIP")) {
            System.out.print("Ingrese servicios adicionales: ");
            String servicios = scanner.nextLine();
            System.out.print("Ingrese precio del servicio adicional: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Consumir salto de línea
            vuelos.add(new VueloVIP(numero, origen, destino, fecha, horaSalida, horaLlegada, servicios, precio));
        } else {
            System.out.println("Tipo de vuelo inválido.");
        }
        System.out.println("Vuelo agregado.");
    }

    private void eliminarVuelo(Scanner scanner) {
        System.out.print("Ingrese número de vuelo a eliminar: ");
        String numero = scanner.nextLine();
        vuelos.removeIf(vuelo -> vuelo.getNumeroVuelo().equals(numero));
        System.out.println("Vuelo eliminado (si existía).");
    }

    private void visualizarVuelos() {
        if (vuelos.isEmpty()) {
            System.out.println("No hay vuelos registrados.");
        } else {
            for (Vuelo vuelo : vuelos) {
                System.out.println(vuelo);
            }
        }
    }

    private void guardarVuelos() {
        System.out.println("Intentando guardar en: " + new File(ARCHIVO).getAbsolutePath());
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO))) {
            if (vuelos.isEmpty()) {
                System.out.println("No hay vuelos para guardar.");
                return;
            }
            for (Vuelo vuelo : vuelos) {
                writer.println(vuelo.getNumeroVuelo() + "," + vuelo.getItinerario().replace(", ", "|") + "," + 
                               (vuelo instanceof VueloRegular ? ((VueloRegular)vuelo).getDistanciaRecorrida() : 
                               ((VueloVIP)vuelo).getServiciosAdicionales() + "," + ((VueloVIP)vuelo).getPrecioServicioAdicional()));
            }
            System.out.println("Vuelos guardados exitosamente en " + ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar los vuelos: " + e.getMessage());
        }
    }

    private void cargarVuelos() {
        vuelos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 6) {
                    String numero = partes[0];
                    String[] itinerario = partes[1].split("\\|");
                    String origen = itinerario[0].replace("Origen: ", "");
                    String destino = itinerario[1].replace("Destino: ", "");
                    String fecha = itinerario[2].replace("Fecha: ", "");
                    String horaSalida = itinerario[3].replace("Salida: ", "");
                    String horaLlegada = itinerario[4].replace("Llegada: ", "");

                    if (partes.length == 7) { // VueloRegular
                        double distancia = Double.parseDouble(partes[6]);
                        vuelos.add(new VueloRegular(numero, origen, destino, fecha, horaSalida, horaLlegada, distancia));
                    } else if (partes.length == 8) { // VueloVIP
                        String servicios = partes[6];
                        double precio = Double.parseDouble(partes[7]);
                        vuelos.add(new VueloVIP(numero, origen, destino, fecha, horaSalida, horaLlegada, servicios, precio));
                    }
                }
            }
            System.out.println("Vuelos cargados desde " + ARCHIVO);
        } catch (IOException e) {
            System.out.println("No se encontró el archivo o error al cargar.");
        }
    }
}