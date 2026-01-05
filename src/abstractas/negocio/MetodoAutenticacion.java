package abstractas.negocio;

public abstract class MetodoAutenticacion {
    private int nivelSeguridad;

    public MetodoAutenticacion(int nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }

    public int getNivelSeguridad() {
        return nivelSeguridad;
    }

    public void setNivelSeguridad(int nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }

    public abstract boolean autenticar(String datos);

    @Override
    public String toString() {
        return "Nivel de Seguridad: "+nivelSeguridad;
    }
}
