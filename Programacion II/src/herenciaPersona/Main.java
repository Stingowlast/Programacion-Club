package herenciaPersona;
import java.util.*;

public class Main {

    private static List<AlumnoPregrado> listaPregrado = new ArrayList<>();
    private static List<Alumnomagister> listaMagister = new ArrayList<>();
    private static List<Profesorhora> listaProfesoresHora = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    public static void main() {
        int opcion;

        do {
            menu();
            System.out.print("Elija una opción: ");
            while (!sc.hasNextInt()) {
                System.out.println("Debe ingresar un número.");
                sc.next();
                System.out.print("Elija una opción: ");
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    ingresarAlumnoPregrado();
                    break;
                case 2:
                    ingresarAlumnoMagister();
                    break;
                case 3:
                    ingresarProfesorHora();
                    break;
                case 4:
                    mostrarListas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println(); // línea en blanco
        } while (opcion != 5);
    }

    public static void menu() {
        System.out.println("******* Udla ******");
        System.out.println("1. Alumno pregrado");
        System.out.println("2. Alumno magister");
        System.out.println("3. Profesor hora");
        System.out.println("4. Mostrar las listas");
        System.out.println("5. Salir");
    }


    private static void ingresarAlumnoPregrado() {
        System.out.println("=== Ingreso Alumno Pregrado ===");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Cédula: ");
        String cedula = sc.nextLine();

        System.out.print("Universidad: ");
        String universidad = sc.nextLine();

        System.out.print("Carrera: ");
        String carrera = sc.nextLine();

        AlumnoPregrado ap = new AlumnoPregrado(nombre, cedula, universidad, carrera);
        listaPregrado.add(ap);

        System.out.println("Alumno de pregrado agregado correctamente.");
    }


    private static void ingresarAlumnoMagister() {
        System.out.println("=== Ingreso Alumno Magister ===");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Cédula: ");
        String cedula = sc.nextLine();

        System.out.print("Universidad: ");
        String universidad = sc.nextLine();

        System.out.print("Tema de tesis: ");
        String tesis = sc.nextLine();

        Alumnomagister am = new Alumnomagister(nombre, cedula, universidad, tesis);
        listaMagister.add(am);

        System.out.println("Alumno de magister agregado correctamente.");
    }


    private static void ingresarProfesorHora() {
        System.out.println("=== Ingreso Profesor por Hora ===");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Cédula: ");
        String cedula = sc.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();

        System.out.print("Número de horas: ");
        int horas;
        while (!sc.hasNextInt()) {
            System.out.println("Debe ingresar un número entero para las horas.");
            sc.next(); // limpiar
            System.out.print("Número de horas: ");
        }
        horas = sc.nextInt();
        sc.nextLine(); // limpiar salto

        Profesorhora ph = new Profesorhora(nombre, cedula, especialidad, horas);
        listaProfesoresHora.add(ph);

        System.out.println("Profesor por hora agregado correctamente.");
    }


    private static void mostrarListas() {
        System.out.println("=== Lista de Alumnos de Pregrado ===");
        if (listaPregrado.isEmpty()) {
            System.out.println("No hay alumnos de pregrado registrados.");
        } else {
            for (AlumnoPregrado ap : listaPregrado) {
                System.out.println(ap);
                System.out.println("-------------------------");
            }
        }

        System.out.println("=== Lista de Alumnos de Magister ===");
        if (listaMagister.isEmpty()) {
            System.out.println("No hay alumnos de magister registrados.");
        } else {
            for (Alumnomagister am : listaMagister) {
                System.out.println(am);
                System.out.println("-------------------------");
            }
        }

        System.out.println("=== Lista de Profesores por Hora ===");
        if (listaProfesoresHora.isEmpty()) {
            System.out.println("No hay profesores por hora registrados.");
        } else {
            for (Profesorhora ph : listaProfesoresHora) {
                System.out.println(ph);
                System.out.println("-------------------------");
            }
        }
    }
}
