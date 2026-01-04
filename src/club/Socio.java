package club;

import java.util.ArrayList;

public class Socio {

    public enum Tipo {
        VIP, REGULAR
    }

    public final static double FONDOS_INICIALES_REGULARES = 50;
    public final static double FONDOS_INICIALES_VIP = 100;
    public final static double MONTO_MAXIMO_REGULARES = 1000;
    public final static double MONTO_MAXIMO_VIP = 5000;

    private String cedula;
    private String nombre;
    private double fondos;
    private Tipo tipoSubscripcion;
    private ArrayList<Factura> facturas;
    private ArrayList<String> autorizados;

    public Socio(String pCedula, String pNombre, Tipo pTipo) {
        cedula = pCedula;
        nombre = pNombre;
        tipoSubscripcion = pTipo;

        fondos = (pTipo == Tipo.VIP) ? FONDOS_INICIALES_VIP : FONDOS_INICIALES_REGULARES;

        facturas = new ArrayList<>();
        autorizados = new ArrayList<>();
    }

    public String darNombre() { return nombre; }
    public String darCedula() { return cedula; }
    public double darFondos() { return fondos; }
    public Tipo darTipo() { return tipoSubscripcion; }
    public ArrayList<Factura> darFacturas() { return facturas; }
    public ArrayList<String> darAutorizados() { return autorizados; }

    private boolean existeAutorizado(String nombre) {
        return autorizados.contains(nombre);
    }

    private boolean tieneFacturaAsociada(String nombre) {
        for (Factura f : facturas) {
            if (f.darNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void aumentarFondos(double valor) throws ClubException {
        double max = (tipoSubscripcion == Tipo.VIP) ? MONTO_MAXIMO_VIP : MONTO_MAXIMO_REGULARES;
        if (fondos + valor > max) {
            throw new ClubException("Se excede el monto máximo permitido");
        }
        fondos += valor;
    }

    public void registrarConsumo(String nombre, String concepto, double valor) throws ClubException {
        if (valor > fondos) {
            throw new ClubException("Fondos insuficientes para el consumo");
        }
        facturas.add(new Factura(nombre, concepto, valor));
    }

    public void agregarAutorizado(String nombre) throws ClubException {
        if (nombre.equals(this.nombre)) {
            throw new ClubException("No se puede autorizar al mismo socio");
        }
        if (fondos <= 0) {
            throw new ClubException("Fondos insuficientes para autorizar");
        }
        if (existeAutorizado(nombre)) {
            throw new ClubException("El autorizado ya existe");
        }
        autorizados.add(nombre);
    }

    public void eliminarAutorizado(String nombre) throws ClubException {
        if (tieneFacturaAsociada(nombre)) {
            throw new ClubException("El autorizado tiene facturas pendientes");
        }
        if (!autorizados.remove(nombre)) {
            throw new ClubException("El autorizado no existe");
        }
    }

    public void pagarFactura(int indice) throws ClubException {
        if (indice < 0 || indice >= facturas.size()) {
            throw new ClubException("Factura inválida");
        }
        Factura f = facturas.get(indice);
        if (f.darValor() > fondos) {
            throw new ClubException("Fondos insuficientes para pagar la factura");
        }
        fondos -= f.darValor();
        facturas.remove(indice);
    }
}
