package abstractas.negocio;

public class ReconocimientoFacial extends MetodoAutenticacion {
    private String mapaRostro;
    private double precisionModelo;

    public ReconocimientoFacial(int nivelSeguridad, String mapaRostro, double precisionModelo) {
        super(nivelSeguridad);
        this.mapaRostro = mapaRostro;
        this.precisionModelo = precisionModelo;
    }

    public String getMapaRostro() {
        return mapaRostro;
    }

    public void setMapaRostro(String mapaRostro) {
        this.mapaRostro = mapaRostro;
    }

    public double getPrecisionModelo() {
        return precisionModelo;
    }

    public void setPrecisionModelo(double precisionModelo) {
        this.precisionModelo = precisionModelo;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nMapa: "+ mapaRostro + "\nPrecision Modelo: "+ precisionModelo;
    }

    @Override
    public boolean autenticar(String datos){
        double similitud = calcularSimilitud(mapaRostro, datos);
        return similitud >= precisionModelo;
    }

    private double calcularSimilitud(String a, String b) {
        int minLen = Math.min(a.length(), b.length());
        int comunes = 0;

        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                comunes++;
            }
        }return (double) comunes/minLen;
    }
}
