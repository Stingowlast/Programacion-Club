package negocio;

public class Automovil extends Vehiculo{
    private String tipo;
    private String traccion;

    public Automovil(String marca, String modelo, int anio, Propietario propietario, String tipo, String traccion) {
        super(marca, modelo, anio, propietario);
        this.tipo = tipo;
        this.traccion = traccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo: " + tipo + "\nTraccion: " + traccion;
    }
}
