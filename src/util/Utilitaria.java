package util;

import negocio.Automovil;
import negocio.Motocicleta;
import negocio.Propietario;
import negocio.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Utilitaria {
    private List<Propietario> propietarios;
    private List<Vehiculo> vehiculos;

    public Utilitaria(){
        propietarios = new ArrayList<Propietario>();
        vehiculos = new ArrayList<Vehiculo>();
    }

    public void agregarPropietario(String nombre, String cedula, String telefono){
        propietarios.add(new Propietario(nombre, cedula,telefono));
    }
    public void agregarAutomovil(String marca, String modelo, int anio, Propietario propietario, String tipo, String traccion){
        vehiculos.add(new Automovil(marca, modelo, anio, propietario,tipo, traccion));
    }
    public void agregarMotocicleta(String marca, String modelo, int anio, Propietario propietario, String altura, String arranque){
        vehiculos.add(new Motocicleta(marca, modelo, anio, propietario, altura,arranque));
    }

    public Propietario buscarPropietario(String cedula){
        for (Propietario propietario:propietarios){
            if (propietario.getCedula().equals(cedula)){
                return propietario;
            }
        }
        return null;
    }
    public List<Vehiculo> buscarVehiculo(String marca){
        List<Vehiculo> lista = new ArrayList<>();
        for (Vehiculo vehiculo:vehiculos){
            if (vehiculo.getMarca().equalsIgnoreCase(marca)){
                 lista.add(vehiculo);
            }
        }
        return lista;
    }

    public String obtenerListaVehiculo(){
        String lista = "";
        for (Vehiculo vehiculo: vehiculos){
            lista += vehiculo + "\n";
        }
        return lista;
    }

    public String obtenerListaPropietario(){
        StringBuilder sb = new StringBuilder();
        for (Propietario propietario: propietarios){
            sb.append(propietario);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String listarTraccionAutomovilesporMarca(String marca){
        StringBuilder sb = new StringBuilder();
        for (Vehiculo v : vehiculos){
            if (v.getMarca().equalsIgnoreCase(marca)){
                if (v instanceof Automovil) {
                    Automovil A = (Automovil) v;

                }
            }
        }
        return sb.toString();
    }

    public String obtenerListaMotocicletas(){
        StringBuilder sb = new StringBuilder();

        for (Vehiculo v : vehiculos){
            if (v instanceof Motocicleta){
                sb.append(v).append("\n");
            }
        }
        return sb.toString();
    }

    public boolean matricularVehiculo(String placa){
        for (Vehiculo v : vehiculos){
            if (!v.isMatriculado()){
                v.setPlaca(placa);
                v.setMatriculado(true);
                return true;
            }
        }
        return false;
    }


    public void menu() {
        System.out.println("1. Ingresar clientes o propietarios");
        System.out.println("2. Agregar motocicletas a propietarios");
        System.out.println("3. Agregar automoviles a propietarios");
        System.out.println("4. Buscar vehiculos por marca");
        System.out.println("5. Listar propietarios");
        System.out.println("6, Listar Vehiculos");
        System.out.println("7, Listar Motocicletas");
        System.out.println("8, Listar Traccion de Automoviles por Marca");
        System.out.println("9. Matricular Vehiculo");
        System.out.println("10. Salir");

    }
}
