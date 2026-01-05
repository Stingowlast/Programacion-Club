package club;

import java.util.Scanner;
import club.Socio.Tipo;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Club c = new Club();
        int op;

        do {
            System.out.println("\n--- CLUB SOCIAL ---");
            System.out.println("1. Afiliar un socio al club");
            System.out.println("2. Registrar una persona autorizada por un socio");
            System.out.println("3. Pagar una factura");
            System.out.println("4. Registrar un consumo en la cuenta de un socio");
            System.out.println("5. Aumentar fondos de la cuenta de un socio");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            op = sc.nextInt();

            switch (op) {

                case 1: { // Afiliar socio
                    try {
                        System.out.print("Cédula: ");
                        String cedula = sc.next();

                        System.out.print("Nombre: ");
                        String nombre = sc.next();

                        System.out.print("Tipo (VIP / REGULAR): ");
                        Tipo tipo = Tipo.valueOf(sc.next().toUpperCase());

                        c.afiliarSocio(cedula, nombre, tipo);
                        System.out.println("Socio afiliado correctamente");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } break;

                case 2: { // Agregar autorizado
                    try {
                        System.out.print("Cédula del socio: ");
                        String cedula = sc.next();

                        System.out.print("Nombre del autorizado: ");
                        String nombre = sc.next();

                        c.agregarAutorizadoSocio(cedula, nombre);
                        System.out.println("Autorizado agregado correctamente");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } break;

                case 3: { // Pagar factura
                    try {
                        System.out.print("Cédula del socio: ");
                        String cedula = sc.next();

                        System.out.print("Índice de la factura: ");
                        int indice = sc.nextInt();

                        c.pagarFacturaSocio(cedula, indice);
                        System.out.println("Factura pagada correctamente");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } break;

                case 4: { // Registrar consumo
                    try {
                        System.out.print("Cédula del socio: ");
                        String cedula = sc.next();

                        System.out.print("Nombre de quien consume: ");
                        String nombre = sc.next();

                        System.out.print("Concepto: ");
                        String concepto = sc.next();

                        System.out.print("Valor del consumo: ");
                        double valor = sc.nextDouble();

                        c.registrarConsumo(cedula, nombre, concepto, valor);
                        System.out.println("Consumo registrado correctamente");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } break;

                case 5: { // Aumentar fondos
                    try {
                        System.out.print("Cédula del socio: ");
                        String cedula = sc.next();

                        System.out.print("Valor a aumentar: ");
                        double valor = sc.nextDouble();

                        c.aumentarFondosSocio(cedula, valor);
                        System.out.println("Fondos aumentados correctamente");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } break;

                case 6:
                    System.out.println("Gracias por usar el sistema");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (op != 6);

        sc.close();
    }
}
