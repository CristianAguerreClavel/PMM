package aguerre.cristian.pmm;

/**
 * Created by Cristian Aguerre Clavel on 3/02/14.
 */
public class Centros {
    private int cod_centro;
    private String tipo_centro;
    private String nombre;
    private String direccion;
    private String telefono;
    private int num_plazas;

    public Centros(int cod_centro,String tipo_centro,String nombre,String direccion,String telefono, int num_plazas){
        this.setCod_centro(cod_centro);
        this.setTipo_centro(tipo_centro);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.setNum_plazas(num_plazas);
    }

    public int getCod_centro() {
        return cod_centro;
    }

    public void setCod_centro(int cod_centro) {
        this.cod_centro = cod_centro;
    }

    public String getTipo_centro() {
        return tipo_centro;
    }

    public void setTipo_centro(String tipo_centro) {
        this.tipo_centro = tipo_centro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNum_plazas() {
        return num_plazas;
    }

    public void setNum_plazas(int num_plazas) {
        this.num_plazas = num_plazas;
    }
}
