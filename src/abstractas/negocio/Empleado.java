package abstractas.negocio;

import java.util.ArrayList;
import java.util.List;
public class Empleado {
    private String cedula;
    private String nombre;
    private List<MetodoAutenticacion> autenticaciones;

    public Empleado(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        autenticaciones = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public List<MetodoAutenticacion> getAutenticaciones() {
        return autenticaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarAutenticacion(MetodoAutenticacion me){
        autenticaciones.add(me);
    }
    public int cantidadMetodoHuella(){
        int cont = 0;
        for (MetodoAutenticacion me:autenticaciones){
            if (me instanceof HuellaDigital)
                cont++;
        }
        return cont;
    }
    public int cantidadMetodoToken(){
        int cont = 0;
        for (MetodoAutenticacion me:autenticaciones){
            if (me instanceof TokenSeguridad)
                cont++;
        }
        return cont;
    }
    public int cantidadMetodoFacial(){
        int cont = 0;
        for (MetodoAutenticacion me:autenticaciones){
            if (me instanceof ReconocimientoFacial)
                cont++;
        }
        return cont;
    }

    public String umbralSeguridadSuperior(int umbral){
       String metodos = "";
       for (MetodoAutenticacion me:autenticaciones){
           if (me.getNivelSeguridad() > umbral)
                if (me instanceof HuellaDigital)
                    metodos += "Huella Digital\n";
                else if (me instanceof TokenSeguridad)
                    metodos += "Token de Seguridad\n";
                else if (me instanceof ReconocimientoFacial)
                    metodos += "Reconocimiento Facial\n";
       }
       return metodos;
    }

    public boolean autenticar(String metodo, String datos){
        boolean entro = false;
        for (MetodoAutenticacion me:autenticaciones){
            if (me instanceof HuellaDigital)
                entro = me.autenticar(datos);
            else if (me instanceof ReconocimientoFacial)
                entro = me.autenticar(datos);
            else
                entro = me.autenticar(datos);
            if (entro)
                return true;
        }
        return false;
    }

    public String mostrarMetodosHuella() {
        String resultado = "";

        for (var metodo : autenticaciones) {
            if (metodo instanceof HuellaDigital) {
                resultado += metodo.toString() + "\n";
            }
        }

        return resultado;
    }

    @Override
    public String toString(){
        return "Cedula: "+cedula+"\nNombre: "+nombre+ "\nMetodos de Autenticacion: "+autenticaciones;
    }
}
