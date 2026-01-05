package abstractas.interfaz;

import abstractas.utilitario.Util;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Util util = new Util();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            util.menu();
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            String cedula;
            String nombre;
            int nivel;
            String dato;
            double precision;

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    System.out.print("Ingrese nombre: ");
                    nombre = sc.nextLine();
                    util.agregarEmpleado(cedula, nombre);
                    break;

                case 2:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    System.out.print("Nivel de seguridad: ");
                    nivel = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Código token: ");
                    dato = sc.nextLine();
                    util.agregarTokenSeguridad(cedula, nivel, dato);
                    break;

                case 3:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    System.out.print("Nivel de seguridad: ");
                    nivel = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Mapa del rostro: ");
                    dato = sc.nextLine();
                    System.out.print("Precisión del modelo: ");
                    precision = sc.nextDouble();
                    sc.nextLine();
                    util.agregarReconocimientoFacial(cedula, nivel, dato, precision);
                    break;

                case 4:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    System.out.print("Nivel de seguridad: ");
                    nivel = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Patrón de huella: ");
                    dato = sc.nextLine();
                    util.agregarHuellaDigital(cedula, nivel, dato);
                    break;

                case 5:
                    util.mostrarEmpleados();
                    break;

                case 6:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    util.buscarEmpleadoMostrar(cedula);
                    break;

                case 7:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    util.totalMetodosAutenticacion(cedula);
                    break;

                case 8:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    util.totalMetodosHuella(cedula);
                    break;

                case 9:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    util.totalMetodosToken(cedula);
                    break;

                case 10:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    util.totalMetodosReconocimiento(cedula);
                    break;

                case 11:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    util.metodosUmbralMayor(cedula);
                    break;

                case 12:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    util.autenticar(cedula);
                    break;

                case 13:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    util.mostrarHuellaEmpleado(cedula);
                    break;

                case 14:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 14);

        sc.close();
    }
}
