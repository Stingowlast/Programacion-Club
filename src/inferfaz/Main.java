package inferfaz;

import negocio.Vehiculo;
import util.Utilitaria;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String nombre, cedula, telefono;
        String marca, modelo, tipo, traccion;
        String altura, arranque;
        int anio, opc;
        String placa;

        Utilitaria utilitaria = new Utilitaria();
        Scanner sc = new Scanner(System.in);

        do {
            utilitaria.menu();
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {

                case 1 -> {
                    System.out.println("Ingrese el nombre del propietario: ");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese la cédula del propietario: ");
                    cedula = sc.nextLine();
                    System.out.println("Ingrese el telefono del propietario: ");
                    telefono = sc.nextLine();

                    utilitaria.agregarPropietario(cedula, nombre, telefono);
                }

                case 2 -> {
                    System.out.println("Ingrese la cedula del propietario: ");
                    cedula = sc.nextLine();

                    var aux = utilitaria.buscarPropietario(cedula);

                    if (aux != null) {
                        System.out.println("Ingrese la marca de la motocicleta: ");
                        marca = sc.nextLine();
                        System.out.println("Ingrese el modelo de la motocicleta: ");
                        modelo = sc.nextLine();
                        System.out.println("Ingrese el año de la motocicleta: ");
                        anio = Integer.parseInt(sc.nextLine());
                        System.out.println("Ingrese la altura de la motocicleta: ");
                        altura = sc.nextLine();
                        System.out.println("Ingrese el arranque de la motocicleta: ");
                        arranque = sc.nextLine();

                        utilitaria.agregarMotocicleta(marca, modelo, anio, aux, altura, arranque);
                    } else {
                        System.out.println("No se encontro un propietario");
                    }
                }

                case 3 -> {
                    System.out.println("Ingrese la cedula del propietario: ");
                    cedula = sc.nextLine();

                    var aux = utilitaria.buscarPropietario(cedula);

                    if (aux != null) {
                        System.out.println("Ingrese la marca del automovil: ");
                        marca = sc.nextLine();
                        System.out.println("Ingrese el modelo del automovil: ");
                        modelo = sc.nextLine();
                        System.out.println("Ingrese el año del automovil: ");
                        anio = Integer.parseInt(sc.nextLine());
                        System.out.println("Ingrese el tipo del automovil: ");
                        tipo = sc.nextLine();
                        System.out.println("Ingrese la tracción del automovil: ");
                        traccion = sc.nextLine();

                        utilitaria.agregarAutomovil(marca, modelo, anio, aux, tipo, traccion);
                    } else {
                        System.out.println("No se encontro un propietario");
                    }
                }

                case 4 -> {
                    System.out.println("Ingrese la marca del vehiculo: ");
                    marca = sc.nextLine();

                    List<Vehiculo> aux = utilitaria.buscarVehiculo(marca);

                    if (aux.isEmpty()) {
                        System.out.println("No se encontro ningun vehiculo con esa marca");
                    } else {
                        aux.forEach(System.out::println);
                    }
                }

                case 5 -> System.out.println(utilitaria.obtenerListaPropietario());

                case 6 -> System.out.println(utilitaria.obtenerListaVehiculo());

                case 7 -> System.out.println(utilitaria.obtenerListaMotocicletas());

                case 8 -> {
                    System.out.println("Ingrese la marca del automovil: ");
                    marca = sc.nextLine();
                    System.out.println(utilitaria.listarTraccionAutomovilesporMarca(marca));
                }

                case 9 -> {
                    System.out.println("Ingrese la placa del vehiculo: ");
                    placa = sc.nextLine();

                    if (utilitaria.matricularVehiculo(placa)) {
                        System.out.println("Vehiculo matriculado correctamente");
                    } else {
                        System.out.println("No hay vehiculos sin matricular");
                    }
                }

                case 10 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opcion invalida");
            }

        } while (opc != 10);
    }
}
