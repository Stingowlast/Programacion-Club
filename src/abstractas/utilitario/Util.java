package abstractas.utilitario;

import abstractas.negocio.Empleado;
import abstractas.negocio.HuellaDigital;
import abstractas.negocio.ReconocimientoFacial;
import abstractas.negocio.TokenSeguridad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

    private List<Empleado> empleados;

    public Util() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(String cedula, String nombre) {
        if (buscarEmpleado(cedula) == -1) {
            empleados.add(new Empleado(cedula, nombre));
            System.out.println("Empleado agregado correctamente");
        } else {
            System.out.println("Empleado ya existe");
        }
    }

    public int buscarEmpleado(String cedula) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCedula().equals(cedula)) {
                return i;
            }
        }
        return -1;
    }

    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }

    public void buscarEmpleadoMostrar(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            System.out.println(empleados.get(indice));
        } else {
            System.out.println("Empleado no encontrado");
        }
    }

    public void agregarHuellaDigital(String cedula, int nivelSeguridad, String patronHuella) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            empleados.get(indice)
                    .agregarAutenticacion(new HuellaDigital(nivelSeguridad, patronHuella));
            System.out.println("Huella digital agregada");
        } else {
            System.out.println("Empleado no encontrado");
        }
    }

    public void agregarTokenSeguridad(String cedula, int nivelSeguridad, String codigoToken) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            empleados.get(indice)
                    .agregarAutenticacion(new TokenSeguridad(nivelSeguridad, codigoToken));
            System.out.println("Token agregado");
        } else {
            System.out.println("Empleado no encontrado");
        }
    }

    public void agregarReconocimientoFacial(String cedula, int nivelSeguridad,
                                            String mapaRostro, double precisionModelo) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            empleados.get(indice)
                    .agregarAutenticacion(
                            new ReconocimientoFacial(nivelSeguridad, mapaRostro, precisionModelo));
            System.out.println("Reconocimiento facial agregado");
        } else {
            System.out.println("Empleado no encontrado");
        }
    }

    public int totalMetodosAutenticacion(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            int total = empleados.get(indice).getAutenticaciones().size();
            System.out.println("Total métodos: " + total);
            return total;
        }
        System.out.println("Empleado no encontrado");
        return -1;
    }

    public int totalMetodosHuella(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            int total = empleados.get(indice).cantidadMetodoHuella();
            System.out.println("Total huellas: " + total);
            return total;
        }
        System.out.println("Empleado no encontrado");
        return -1;
    }

    public int totalMetodosToken(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            int total = empleados.get(indice).cantidadMetodoToken();
            System.out.println("Total tokens: " + total);
            return total;
        }
        System.out.println("Empleado no encontrado");
        return -1;
    }

    public int totalMetodosReconocimiento(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            int total = empleados.get(indice).cantidadMetodoFacial();
            System.out.println("Total reconocimiento facial: " + total);
            return total;
        }
        System.out.println("Empleado no encontrado");
        return -1;
    }

    public String metodosUmbralMayor(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese umbral de seguridad: ");
            int umbral = sc.nextInt();

            String resultado = empleados.get(indice)
                    .umbralSeguridadSuperior(umbral);

            if (resultado.isEmpty()) {
                System.out.println("No hay métodos con nivel superior");
            } else {
                System.out.println(resultado);
            }
            return resultado;
        }
        System.out.println("Empleado no encontrado");
        return "";
    }

    public String autenticar(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese dato de autenticación: ");
            String dato = sc.nextLine();

            boolean ok = empleados.get(indice).autenticar("", dato);
            System.out.println(ok ? "Autenticación exitosa" : "Autenticación fallida");
            return ok ? "OK" : "ERROR";
        }
        System.out.println("Empleado no encontrado");
        return "ERROR";
    }

    public void mostrarHuellaEmpleado(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            System.out.println(empleados.get(indice).mostrarMetodosHuella());
        } else {
            System.out.println("Empleado no encontrado");
        }
    }

    public void menu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1 agregar empleado");
        System.out.println("2 agregar token seguridad");
        System.out.println("3 agregar reconocimiento facial");
        System.out.println("4 agregar huella digital");
        System.out.println("5 mostrar datos de empleados (todos)");
        System.out.println("6 buscar empleado y mostrar datos");
        System.out.println("7 total métodos autenticación empleado");
        System.out.println("8 total métodos huella empleado");
        System.out.println("9 total métodos token empleado");
        System.out.println("10 total métodos facial empleado");
        System.out.println("11 métodos mayor a umbral de empleado");
        System.out.println("12 autenticar empleado");
        System.out.println("13 mostrar métodos huella empleado");
        System.out.println("14 salir");
    }
}
