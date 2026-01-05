package abstractas.negocio;

public class TokenSeguridad extends MetodoAutenticacion{
    private String codigoToken;

    public TokenSeguridad(int nivelSeguridad, String codigoToken) {
        super(nivelSeguridad);
        this.codigoToken = codigoToken;
    }

    public void setCodigoToken(String codigoToken) {
        this.codigoToken = codigoToken;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public boolean autenticar(String datos) {
        if (codigoToken.equals(datos))
            return true;
        return false;
    }
}
