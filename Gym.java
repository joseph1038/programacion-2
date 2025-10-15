import java.util.*;

class Persona {
    private String nombre;
    private int edad;
    private String id;

    public Persona(String nombre, int edad, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}

class Rutina {
    private String nombre;
    private String descripcion;
    private int nivelDificultad;

    public Rutina(String nombre, String descripcion, int nivelDificultad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivelDificultad = nivelDificultad;
    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public int getNivelDificultad() { return nivelDificultad; }
    public void setNivelDificultad(int nivel) { this.nivelDificultad = nivel; }
    public String toString() {
        return nombre + " (" + descripcion + ", nivel " + nivelDificultad + ")";
    }
}

class Cliente {
    private String id;
    private String membresia;
    private String fechaRegistro;
    private boolean activo;

    public Cliente(String id, String membresia, String fechaRegistro, boolean activo) {
        this.id = id;
        this.membresia = membresia;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }
    public String getId() { return id; }
    public String getMembresia() { return membresia; }
    public void setMembresia(String membresia) { this.membresia = membresia; }
    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(String fecha) { this.fechaRegistro = fecha; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public void renovarMembresia() { this.activo = true; }
    public String toString() {
        return "Cliente{id='" + id + "', membresia='" + membresia + "', fecha='" + fechaRegistro + "', activo=" + activo + "}";
    }
}

class Coach extends Persona {
    private String especialidad;
    private ArrayList<Rutina> rutinas = new ArrayList<>();

    public Coach(String nombre, int edad, String id, String especialidad) {
        super(nombre, edad, id);
        this.especialidad = especialidad;
    }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public void agregarRutina(Rutina rutina) {
        if (rutina == null) return;
        if (!rutinas.contains(rutina)) rutinas.add(rutina);
    }
    public void eliminarRutina(Rutina rutina) {
        rutinas.remove(rutina);
    }
    public void mostrarRutinas() {
        if (rutinas.isEmpty()) System.out.println("Sin rutinas");
        else for (int i = 0; i < rutinas.size(); i++) System.out.println((i+1) + ". " + rutinas.get(i));
    }
    public String toString() {
        return "Coach{" + getNombre() + ", esp='" + especialidad + "', rutinas=" + rutinas.size() + "}";
    }
}

class PersonalDeAseo extends Persona {
    private String turno;
    private String area;

    public PersonalDeAseo(String nombre, int edad, String id, String turno, String area) {
        super(nombre, edad, id);
        this.turno = turno;
        this.area = area;
    }
    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    public String toString() {
        return "Aseo{" + getNombre() + ", turno='" + turno + "', area='" + area + "'}";
    }
}

class Administrativo extends Persona {
    private String departamento;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Administrativo(String nombre, int edad, String id, String departamento) {
        super(nombre, edad, id);
        this.departamento = departamento;
    }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public void agregarCliente(Cliente cliente) {
        if (cliente == null) return;
        if (buscarCliente(cliente.getId()) != null) return;
        clientes.add(cliente);
        System.out.println("Cliente asignado.");
    }
    public boolean eliminarClientePorId(String id) {
        Cliente c = buscarCliente(id);
        if (c == null) return false;
        clientes.remove(c);
        return true;
    }
    public void mostrarClientes() {
        if (clientes.isEmpty()) System.out.println("Sin clientes asignados");
        else for (Cliente c : clientes) System.out.println(c);
    }
    public Cliente buscarCliente(String id) {
        for (Cliente c : clientes) if (c.getId().equals(id)) return c;
        return null;
    }
    public String toString() {
        return "Admin{" + getNombre() + ", dep='" + departamento + "', clientes=" + clientes.size() + "}";
    }
}

public class Gym {
    static Scanner sc = new Scanner(System.in);
    static List<Coach> coaches = new ArrayList<>();
    static List<Administrativo> admins = new ArrayList<>();
    static List<PersonalDeAseo> aseo = new ArrayList<>();
    static List<Rutina> catalogoRutinas = new ArrayList<>();
    static Map<String, Cliente> baseClientes = new LinkedHashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1) Crear Coach");
            System.out.println("2) Crear Administrativo");
            System.out.println("3) Crear Personal de Aseo");
            System.out.println("4) Crear Cliente");
            System.out.println("5) Asignar/Eliminar Cliente a un Administrativo");
            System.out.println("6) Crear Rutina");
            System.out.println("7) Asignar/Eliminar Rutina a un Coach");
            System.out.println("8) Mostrar rutinas de un Coach");
            System.out.println("0) Salir");
            String op = sc.nextLine().trim();
            if (op.equals("0")) break;
            else if (op.equals("1")) crearCoach();
            else if (op.equals("2")) crearAdministrativo();
            else if (op.equals("3")) crearAseo();
            else if (op.equals("4")) crearCliente();
            else if (op.equals("5")) gestionarClientesDeAdmin();
            else if (op.equals("6")) crearRutina();
            else if (op.equals("7")) gestionarRutinasDeCoach();
            else if (op.equals("8")) mostrarRutinasDeCoach();
            else System.out.println("Opcion invalida");
        }
    }

    static void crearCoach() {
        System.out.print("Nombre: "); String n = sc.nextLine();
        System.out.print("Edad: "); int e = Integer.parseInt(sc.nextLine());
        System.out.print("ID: "); String id = sc.nextLine();
        System.out.print("Especialidad: "); String esp = sc.nextLine();
        coaches.add(new Coach(n, e, id, esp));
        System.out.println("Coach creado");
    }

    static void crearAdministrativo() {
        System.out.print("Nombre: "); String n = sc.nextLine();
        System.out.print("Edad: "); int e = Integer.parseInt(sc.nextLine());
        System.out.print("ID: "); String id = sc.nextLine();
        System.out.print("Departamento: "); String dep = sc.nextLine();
        admins.add(new Administrativo(n, e, id, dep));
        System.out.println("Administrativo creado");
    }

    static void crearAseo() {
        System.out.print("Nombre: "); String n = sc.nextLine();
        System.out.print("Edad: "); int e = Integer.parseInt(sc.nextLine());
        System.out.print("ID: "); String id = sc.nextLine();
        System.out.print("Turno: "); String t = sc.nextLine();
        System.out.print("Area: "); String a = sc.nextLine();
        aseo.add(new PersonalDeAseo(n, e, id, t, a));
        System.out.println("Personal de aseo creado");
    }

    static void crearCliente() {
        System.out.print("ID del cliente: "); String id = sc.nextLine();
        if (baseClientes.containsKey(id)) { System.out.println("Ya existe un cliente con ese ID."); return; }
        System.out.print("Membresia: "); String m = sc.nextLine();
        System.out.print("Fecha de registro: "); String f = sc.nextLine();
        System.out.print("Activo (si/no): "); String s = sc.nextLine().trim().toLowerCase();
        boolean activo = s.startsWith("s");
        Cliente c = new Cliente(id, m, f, activo);
        baseClientes.put(id, c);
        System.out.println("Cliente creado en base general: " + c);
    }

    static void gestionarClientesDeAdmin() {
        System.out.print("ID del Administrativo: "); String idAdmin = sc.nextLine();
        Administrativo admin = buscarAdminPorId(idAdmin);
        if (admin == null) { System.out.println("Administrativo no encontrado."); return; }

        while (true) {
            System.out.println("1) Asignar cliente");
            System.out.println("2) Eliminar cliente");
            System.out.println("3) Mostrar clientes del administrativo");
            System.out.println("0) Volver");
            String op = sc.nextLine().trim();
            if (op.equals("0")) break;
            else if (op.equals("1")) {
                System.out.print("ID del cliente a asignar: "); String idCli = sc.nextLine();
                Cliente c = baseClientes.get(idCli);
                if (c == null) System.out.println("Cliente no existe en la base general.");
                else admin.agregarCliente(c);
            } else if (op.equals("2")) {
                System.out.print("ID del cliente a eliminar: "); String idCli = sc.nextLine();
                boolean ok = admin.eliminarClientePorId(idCli);
                System.out.println(ok ? "Cliente eliminado." : "Cliente no estaba asignado.");
            } else if (op.equals("3")) {
                admin.mostrarClientes();
            } else System.out.println("Opcion invalida");
        }
    }

    static Administrativo buscarAdminPorId(String id) {
        for (Administrativo a : admins) if (a.getId().equals(id)) return a;
        return null;
    }
    static Coach buscarCoachPorId(String id) {
        for (Coach c : coaches) if (c.getId().equals(id)) return c;
        return null;
    }

    static void crearRutina() {
        System.out.print("Nombre: "); String n = sc.nextLine();
        System.out.print("Descripcion: "); String d = sc.nextLine();
        System.out.print("Nivel de dificultad: "); int lvl = Integer.parseInt(sc.nextLine());
        catalogoRutinas.add(new Rutina(n, d, lvl));
        System.out.println("Rutina creada");
    }

    static void gestionarRutinasDeCoach() {
        System.out.print("ID del Coach: "); String id = sc.nextLine();
        Coach coach = buscarCoachPorId(id);
        if (coach == null) { System.out.println("Coach no encontrado."); return; }

        while (true) {
            System.out.println("1) Asignar rutina del catalogo");
            System.out.println("2) Eliminar rutina por nombre");
            System.out.println("3) Mostrar rutinas del coach");
            System.out.println("0) Volver");
            String op = sc.nextLine().trim();
            if (op.equals("0")) break;
            else if (op.equals("1")) {
                if (catalogoRutinas.isEmpty()) { System.out.println("No hay rutinas en el catalogo."); continue; }
                for (int i = 0; i < catalogoRutinas.size(); i++) System.out.println((i+1) + ") " + catalogoRutinas.get(i));
                System.out.print("Numero de rutina: ");
                int idx = Integer.parseInt(sc.nextLine()) - 1;
                if (idx < 0 || idx >= catalogoRutinas.size()) System.out.println("Indice invalido");
                else coach.agregarRutina(catalogoRutinas.get(idx));
            } else if (op.equals("2")) {
                System.out.print("Nombre de la rutina a eliminar: "); String nombre = sc.nextLine();
                Rutina r = null;
                for (Rutina x : catalogoRutinas) if (x.getNombre().equalsIgnoreCase(nombre)) { r = x; break; }
                if (r == null) System.out.println("No existe en catálogo; se intenta por referencia nula.");
                coach.eliminarRutina(r);
            } else if (op.equals("3")) coach.mostrarRutinas();
            else System.out.println("Opcion invalida");
        }
    }

    static void mostrarRutinasDeCoach() {
        System.out.print("ID del Coach: "); String id = sc.nextLine();
        Coach coach = buscarCoachPorId(id);
        if (coach == null) { System.out.println("Coach no encontrado."); return; }
        coach.mostrarRutinas();
    }
}