package negocio;

public class Motocicleta extends Vehiculo{
    private String altura;
    private String arranque;

    public Motocicleta(String marca, String modelo, int anio, Propietario propietario, String altura, String arranque) {
        super(marca, modelo, anio, propietario);
        this.altura = altura;
        this.arranque = arranque;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getArranque() {
        return arranque;
    }

    public void setArranque(String arranque) {
        this.arranque = arranque;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAltura: "+ altura + "\nArranque: "+ arranque;
    }
}
