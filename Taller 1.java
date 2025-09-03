import java.util.ArrayList;
import java.util.Scanner;

// Clase Usuario
class Usuario {
    String id;
    String tipo; // Admin o Normal

    public Usuario(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
}

// Clase base Vehiculo
abstract class Vehiculo {
    String tipo;
    double velocidad;
    boolean enMovimiento;

    public Vehiculo(String tipo, double velocidad) {
        this.tipo = tipo;
        this.velocidad = velocidad;
        this.enMovimiento = false;
    }

    public void iniciarMovimiento() {
        enMovimiento = true;
    }

    public void detener() {
        enMovimiento = false;
    }

    public abstract void mostrarInfo();
}

// Autobus
class Autobus extends Vehiculo {
    String ruta;
    int capacidadMaxima;
    int pasajerosActuales;

    public Autobus(String ruta, int capacidadMaxima, double velocidad, int pasajerosActuales) {
        super("Autobus", velocidad);
        this.ruta = ruta;
        this.capacidadMaxima = capacidadMaxima;
        this.pasajerosActuales = pasajerosActuales;
    }

    
    public void mostrarInfo() {
        System.out.println("Tipo: " + tipo + " | Ruta: " + ruta + " | Capacidad: " + capacidadMaxima +
                " | Pasajeros: " + pasajerosActuales + " | Velocidad: " + velocidad +
                " | Estado: " + (enMovimiento ? "En movimiento" : "Detenido"));
    }
}

// Taxi
class Taxi extends Vehiculo {
    String conductor;
    int capacidadMaxima;
    double tarifaBase;
    boolean enServicio;

    public Taxi(String conductor, int capacidadMaxima, double velocidad, double tarifaBase, boolean enServicio) {
        super("Taxi", velocidad);
        this.conductor = conductor;
        this.capacidadMaxima = capacidadMaxima;
        this.tarifaBase = tarifaBase;
        this.enServicio = enServicio;
    }

    
    public void mostrarInfo() {
        System.out.println("Tipo: " + tipo + " | Conductor: " + conductor + " | Capacidad: " + capacidadMaxima +
                " | Velocidad: " + velocidad + " | Tarifa: " + tarifaBase +
                " | Estado servicio: " + (enServicio ? "En servicio" : "Disponible") +
                " | Movimiento: " + (enMovimiento ? "En movimiento" : "Detenido"));
    }
}

// Bicicleta
class Bicicleta extends Vehiculo {
    String tipoBici; // electrica o mecanica
    boolean disponible;

    public Bicicleta(String tipoBici, double velocidad, boolean disponible) {
        super("Bicicleta", velocidad);
        this.tipoBici = tipoBici;
        this.disponible = disponible;
    }

    
    public void mostrarInfo() {
        System.out.println("Tipo: " + tipo + " | Bici: " + tipoBici +
                " | Velocidad: " + velocidad + " | Disponible: " + (disponible ? "Sí" : "No") +
                " | Movimiento: " + (enMovimiento ? "En movimiento" : "Detenida"));
    }
}

// Clase principal
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        // Agregamos dos usuarios de prueba
        usuarios.add(new Usuario("100", "Admin"));
        usuarios.add(new Usuario("200", "Normal"));

        System.out.print("Ingrese su ID de usuario: ");
        String id = sc.nextLine();
        Usuario actual = validarUsuario(id);

        if (actual == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        if (actual.tipo.equals("Admin")) {
            menuAdmin();
        } else {
            menuUsuario();
        }
    }

    public static Usuario validarUsuario(String id) {
        for (Usuario u : usuarios) {
            if (u.id.equals(id)) {
                return u;
            }
        }
        return null;
    }

    public static void menuAdmin() {
        int opcion;
        do {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Consultar vehiculos");
            System.out.println("3. Modificar vehiculo");
            System.out.println("4. Eliminar vehiculo");
            System.out.println("5. Salir");
            System.out.print("Elija: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: registrarVehiculo(); break;
                case 2: mostrarVehiculos(); break;
                case 3: modificarVehiculo(); break;
                case 4: eliminarVehiculo(); break;
                case 5: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }

    public static void menuUsuario() {
        int opcion;
        do {
            System.out.println("\n--- MENU USUARIO ---");
            System.out.println("1. Consultar vehiculos");
            System.out.println("2. Salir");
            System.out.print("Elija: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: mostrarVehiculos(); break;
                case 2: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion no valida.");
            }
        } while (opcion != 2);
    }

    public static void registrarVehiculo() {
        System.out.println("\n--- REGISTRAR VEHICULO ---");
        System.out.println("1. Autobus");
        System.out.println("2. Taxi");
        System.out.println("3. Bicicleta");
        System.out.print("Elija: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo == 1) {
            System.out.print("Ruta: ");
            String ruta = sc.nextLine();
            System.out.print("Capacidad maxima: ");
            int cap = sc.nextInt();
            System.out.print("Velocidad promedio: ");
            double vel = sc.nextDouble();
            System.out.print("Pasajeros actuales: ");
            int pas = sc.nextInt();
            vehiculos.add(new Autobus(ruta, cap, vel, pas));
        } else if (tipo == 2) {
            System.out.print("Conductor: ");
            String cond = sc.nextLine();
            System.out.print("Capacidad maxima: ");
            int cap = sc.nextInt();
            System.out.print("Velocidad promedio: ");
            double vel = sc.nextDouble();
            System.out.print("Tarifa base: ");
            double tarifa = sc.nextDouble();
            System.out.print("En servicio (Sigue intentando): ");
            boolean serv = sc.nextBoolean();
            vehiculos.add(new Taxi(cond, cap, vel, tarifa, serv));
        } else if (tipo == 3) {
            System.out.print("Tipo (electrica/mecanica): ");
            String tipoB = sc.nextLine();
            System.out.print("Velocidad promedio: ");
            double vel = sc.nextDouble();
            System.out.print("Disponible (true/false): ");
            boolean disp = sc.nextBoolean();
            vehiculos.add(new Bicicleta(tipoB, vel, disp));
        } else {
            System.out.println("Tipo no valido.");
        }
    }

    public static void mostrarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
        } else {
            for (int i = 0; i < vehiculos.size(); i++) {
                System.out.print(i + ". ");
                vehiculos.get(i).mostrarInfo();
            }
        }
    }

    public static void modificarVehiculo() {
        mostrarVehiculos();
        if (vehiculos.isEmpty()) return;

        System.out.print("Ingrese el indice a modificar: ");
        int i = sc.nextInt();
        sc.nextLine();

        if (i >= 0 && i < vehiculos.size()) {
            System.out.print("Nueva velocidad: ");
            double vel = sc.nextDouble();
            vehiculos.get(i).velocidad = vel;
            System.out.println("Velocidad modificada.");
        } else {
            System.out.println("Indice no valido.");
        }
    }

    public static void eliminarVehiculo() {
        mostrarVehiculos();
        if (vehiculos.isEmpty()) return;

        System.out.print("Ingrese el indice a eliminar: ");
        int i = sc.nextInt();

        if (i >= 0 && i < vehiculos.size()) {
            vehiculos.remove(i);
            System.out.println("Vehiculo eliminado.");
        } else {
            System.out.println("Indice no valido.");
        }
    }
}
