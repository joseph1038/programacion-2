import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// clase abstracta Coach

abstract class Coach {
    protected String nombre;
    protected int id;
    protected int aniosExperiencia;

    public Coach(String nombre, int id, int aniosExperiencia) {
        this.nombre = nombre;
        this.id = id;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getNombre() { return nombre; }
    public int getId() { return id; }
    public int getAniosExperiencia() { return aniosExperiencia; }

    public abstract double calcularSalario();

    
    public abstract String toString();
}

// clase CoachNutricionista

class CoachNutricionista extends Coach {
    private String especialidad;
    private double salarioBase;
    private double bonoNutricionista;

    public CoachNutricionista(String nombre, int id, int aniosExperiencia,
                              String especialidad, double salarioBase, double bonoNutricionista) {
        super(nombre, id, aniosExperiencia);
        this.especialidad = especialidad;
        this.salarioBase = salarioBase;
        this.bonoNutricionista = bonoNutricionista;
    }

    public String getEspecialidad() { return especialidad; }
    public double getSalarioBase() { return salarioBase; }
    public double getBonoNutricionista() { return bonoNutricionista; }

    
    public double calcularSalario() {
        return salarioBase + bonoNutricionista;
    }

    
    public String toString() {
        return "Nutricionista -> ID: " + id + ", Nombre: " + nombre +
               ", Experiencia: " + aniosExperiencia + " anos, Especialidad: " + especialidad +
               ", Salario total: $" + String.format("%.2f", calcularSalario());
    }
}

// clase CoachEjercicios

class CoachEjercicios extends Coach {
    
    private String tipoEntrenamiento;
    private double salarioBase;
    private double bonoEjercicios;

    public CoachEjercicios(String nombre, int id, int aniosExperiencia,
                           String tipoEntrenamiento, double salarioBase, double bonoEjercicios) {
        super(nombre, id, aniosExperiencia);
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.salarioBase = salarioBase;
        this.bonoEjercicios = bonoEjercicios;
    }

    public String getTipoEntrenamiento() { return tipoEntrenamiento; }
    public double getSalarioBase() { return salarioBase; }
    public double getBonoEjercicios() { return bonoEjercicios; }

    
    public double calcularSalario() {
        return salarioBase + bonoEjercicios;
    }

    
    public String toString() {
        return "Entrenador -> ID: " + id + ", Nombre: " + nombre +
               ", Experiencia: " + aniosExperiencia + " anos, Tipo: " + tipoEntrenamiento +
               ", Salario total: $" + String.format("%.2f", calcularSalario());
    }
}

// clase Gym

class Gym {
    private String gerente;
    private String nombre;
    private String direccion;
    private boolean tiene24Horas;

    protected ArrayList<Coach> coaches;
    private final int CAPACIDAD_MAXIMA = 50;

    public Gym(String gerente, String nombre, String direccion, boolean tiene24Horas) {
        this.gerente = gerente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tiene24Horas = tiene24Horas;
        this.coaches = new ArrayList<>();
    }

    public boolean agregarCoach(Coach coach) {
        if (coaches.size() < CAPACIDAD_MAXIMA) {
            coaches.add(coach);
            System.out.println("Coach agregado: " + coach.getNombre());
            return true;
        } else {
            System.out.println("El gym esta lleno. No se pueden agregar mas coaches.");
            return false;
        }
    }

    public boolean eliminarCoach(String nombre) {
        for (int i = 0; i < coaches.size(); i++) {
            if (coaches.get(i).getNombre().equalsIgnoreCase(nombre)) {
                coaches.remove(i);
                System.out.println("Coach eliminado: " + nombre);
                return true;
            }
        }
        System.out.println("Coach no encontrado: " + nombre);
        return false;
    }

    public Coach consultarCoach(int indice) {
        if (indice >= 0 && indice < coaches.size()) {
            return coaches.get(indice);
        }
        return null;
    }

    public void mostrarCoaches() {
        System.out.println("\n==== COACHES EN EL GYM ====");
        if (coaches.isEmpty()) {
            System.out.println("No hay coaches registrados.");
        } else {
            for (int i = 0; i < coaches.size(); i++) {
                System.out.println("Indice " + i + " -> " + coaches.get(i));
            }
        }
        System.out.println("Total de coaches: " + coaches.size() + "/" + CAPACIDAD_MAXIMA);
    }

    public double calcularTotalSalarios() {
        double total = 0;
        for (Coach c : coaches) {
            total += c.calcularSalario();
        }
        return total;
    }

    public void mostrarInfo() {
        System.out.println("\n===== INFO DEL GYM =====");
        System.out.println("Nombre: " + nombre);
        System.out.println("Gerente: " + gerente);
        System.out.println("Direccion: " + direccion);
        System.out.println("24 horas: " + (tiene24Horas ? "Si" : "No"));
    }

    // guardar coaches en archivo
    
    public void guardarListado(String nombreArchivo) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
        for (int i = 0; i < coaches.size(); i++) {
            Coach c = coaches.get(i);
            if (c instanceof CoachNutricionista) {
                CoachNutricionista cn = (CoachNutricionista) c;
                // Guardamos: tipo;id;nombre;aniosExperiencia;especialidad;salarioBase;bonoNutricionista
                writer.println("N;" + cn.getId() + ";" + cn.getNombre() + ";" + cn.getAniosExperiencia() + ";" + cn.getEspecialidad() + ";" + cn.getSalarioBase() + ";" + cn.getBonoNutricionista());
            } else if (c instanceof CoachEjercicios) {
                CoachEjercicios ce = (CoachEjercicios) c;
                // Guardamos: tipo;id;nombre;aniosExperiencia;tipoEntrenamiento;salarioBase;bonoEjercicios
                writer.println("E;" + ce.getId() + ";" + ce.getNombre() + ";" + ce.getAniosExperiencia() + ";" + ce.getTipoEntrenamiento() + ";" + ce.getSalarioBase() + ";" + ce.getBonoEjercicios());
             }
         }
         System.out.println("Coaches guardados en: " + nombreArchivo);
        } catch (IOException e) {
           System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // cargar coaches de archivo
    
    public void cargarListado(String nombreArchivo) {
    coaches.clear();
    try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(";");
            String tipo = datos[0];
            int id = Integer.parseInt(datos[1]);
            String nombre = datos[2];
            int aniosExperiencia = Integer.parseInt(datos[3]);

            if (tipo.equals("N")) {
                String especialidad = datos[4];
                double salarioBase = Double.parseDouble(datos[5]);
                double bonoNutricionista = Double.parseDouble(datos[6]);
                coaches.add(new CoachNutricionista(nombre, id, aniosExperiencia, especialidad, salarioBase, bonoNutricionista));
            } else if (tipo.equals("E")) {
                String tipoEntrenamiento = datos[4];
                double salarioBase = Double.parseDouble(datos[5]);
                double bonoEjercicios = Double.parseDouble(datos[6]);
                coaches.add(new CoachEjercicios(nombre, id, aniosExperiencia, tipoEntrenamiento, salarioBase, bonoEjercicios));
             }
            }
            System.out.println("Coaches cargados desde: " + nombreArchivo);
        } catch (IOException e) {
          System.out.println("Error al cargar: " + e.getMessage());
        }
    }
    public void eliminarTodosCoaches() {
        coaches.clear();
        System.out.println("Se eliminaron todos los coaches del gym.");
    }   
}

// clase Main

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gym gym = new Gym("Armando Paredes", "BODY GYMCR", "Calle 123", true);

        

        while (true) {
            System.out.println("\n===== MENU GYM =====");
            System.out.println("1. Agregar Coach Nutricionista");
            System.out.println("2. Agregar Coach Ejercicios");
            System.out.println("3. Eliminar Coach por nombre");
            System.out.println("4. Consultar Coach por indice");
            System.out.println("5. Mostrar todos los Coaches");
            System.out.println("6. Mostrar info del Gym");
            System.out.println("7. Mostrar total de salarios");
            System.out.println("8. Salir");
            System.out.println("9. Guardar coaches en archivo");
            System.out.println("10. Cargar coaches desde archivo");
            System.out.println("11. Eliminar todos los coaches");
            System.out.print("Elige una opcion: ");

            int opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombreN = br.readLine();
                    System.out.print("ID: ");
                    int idN = Integer.parseInt(br.readLine());
                    System.out.print("Anos de experiencia: ");
                    int expN = Integer.parseInt(br.readLine());
                    System.out.print("Especialidad: ");
                    String esp = br.readLine();
                    System.out.print("Salario base: ");
                    double sbN = Double.parseDouble(br.readLine());
                    System.out.print("Bono nutricionista: ");
                    double bn = Double.parseDouble(br.readLine());

                    gym.agregarCoach(new CoachNutricionista(nombreN, idN, expN, esp, sbN, bn));
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    String nombreE = br.readLine();
                    System.out.print("ID: ");
                    int idE = Integer.parseInt(br.readLine());
                    System.out.print("Anos de experiencia: ");
                    int expE = Integer.parseInt(br.readLine());
                    System.out.print("Tipo de entrenamiento: ");
                    String tipo = br.readLine();
                    System.out.print("Salario base: ");
                    double sbE = Double.parseDouble(br.readLine());
                    System.out.print("Bono ejercicios: ");
                    double be = Double.parseDouble(br.readLine());

                    gym.agregarCoach(new CoachEjercicios(nombreE, idE, expE, tipo, sbE, be));
                    break;

                case 3:
                    System.out.print("Nombre del coach a eliminar: ");
                    String eliminar = br.readLine();
                    gym.eliminarCoach(eliminar);
                    break;

                case 4:
                    System.out.print("Indice a consultar: ");
                    int indice = Integer.parseInt(br.readLine());
                    Coach c = gym.consultarCoach(indice);
                    if (c != null) {
                        System.out.println("Coach encontrado -> " + c);
                    } else {
                        System.out.println("Indice invalido.");
                    }
                    break;

                case 5:
                    gym.mostrarCoaches();
                    break;

                case 6:
                    gym.mostrarInfo();
                    break;

                case 7:
                    System.out.println("Total salarios: $" + gym.calcularTotalSalarios());
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    return;

                case 9:
                    System.out.print("Archivo para guardar (ej: coaches.dat): ");
                    String archivoGuardar = br.readLine();
                    gym.guardarListado(archivoGuardar);
                    break;

                case 10:
                    System.out.print("Archivo para cargar (ej: coaches.dat): ");
                    String archivoCargar = br.readLine();
                    gym.cargarListado(archivoCargar);
                    break;
                case 11: 
                    gym.eliminarTodosCoaches();
                    
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}
