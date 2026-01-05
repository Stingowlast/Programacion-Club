package club;

import java.util.ArrayList;
import club.Socio.Tipo;

public class Club {

    public final static int MAXIMO_VIP = 3;
    private ArrayList<Socio> socios;

    public Club() {
        socios = new ArrayList<>();
    }

    public ArrayList<Socio> darSocios() {
        return socios;
    }

    public void afiliarSocio(String cedula, String nombre, Tipo tipo) throws ClubException {
        if (buscarSocio(cedula) != null) {
            throw new ClubException("El socio ya existe");
        }
        if (tipo == Tipo.VIP && contarSociosVIP() == MAXIMO_VIP) {
            throw new ClubException("Máximo de socios VIP alcanzado");
        }
        socios.add(new Socio(cedula, nombre, tipo));
    }

    public Socio buscarSocio(String cedula) {
        for (Socio s : socios) {
            if (s.darCedula().equals(cedula)) {
                return s;
            }
        }
        return null;
    }

    public int contarSociosVIP() {
        int c = 0;
        for (Socio s : socios) {
            if (s.darTipo() == Tipo.VIP) c++;
        }
        return c;
    }

    public void agregarAutorizadoSocio(String cedula, String nombre) throws ClubException {
        Socio s = buscarSocio(cedula);
        if (s == null) throw new ClubException("Socio no existe");
        s.agregarAutorizado(nombre);
    }

    public void eliminarAutorizadoSocio(String cedula, String nombre) throws ClubException {
        Socio s = buscarSocio(cedula);
        if (s == null) throw new ClubException("Socio no existe");
        s.eliminarAutorizado(nombre);
    }

    public void registrarConsumo(String cedula, String nombre, String concepto, double valor) throws ClubException {
        Socio s = buscarSocio(cedula);
        if (s == null) throw new ClubException("Socio no existe");
        s.registrarConsumo(nombre, concepto, valor);
    }

    public void pagarFacturaSocio(String cedula, int indice) throws ClubException {
        Socio s = buscarSocio(cedula);
        if (s == null) throw new ClubException("Socio no existe");
        s.pagarFactura(indice);
    }

    public void aumentarFondosSocio(String cedula, double valor) throws ClubException {
        Socio s = buscarSocio(cedula);
        if (s == null) throw new ClubException("Socio no existe");
        s.aumentarFondos(valor);
    }

    public double totalConsumosSocio(String pCedula) throws ClubException {
        Socio s = buscarSocio(pCedula);
        if (s == null) {
            throw new ClubException("No existe socio con esa cédula");
        }

        double total = 0;
        for (Factura f : s.darFacturas()) {
            total += f.darValor();
        }

        return total;
    }

    public boolean sePuedeEliminarSocio(String pCedula) throws ClubException {
        Socio s = buscarSocio(pCedula);

        if (s == null) {
            throw new ClubException("No existe socio con esa cédula");
        }

        if (s.darTipo() == Socio.Tipo.VIP) {
            return false;
        }

        if (!s.darFacturas().isEmpty()) {
            return false;
        }

        if (s.darAutorizados().size() > 1) {
            return false;
        }

        return true;
    }
}
