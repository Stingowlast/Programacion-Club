package abstractas.negocio;

public class HuellaDigital extends MetodoAutenticacion {
    private String patronHuella;

    public HuellaDigital(int nivelSeguridad, String patronHuella) {
        super(nivelSeguridad);
        this.patronHuella = patronHuella;
    }

    public String getPatronHuella() {
        return patronHuella;
    }

    public void setPatronHuella(String patronHuella) {
        this.patronHuella = patronHuella;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPatron Huella:" + patronHuella;
    }

    @Override
    public boolean autenticar(String datos) {
        if (patronHuella.contains(datos))
            return true;
        return false;
    }
}
