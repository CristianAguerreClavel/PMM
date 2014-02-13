package aguerre.cristian.pmm;

/**
 * Created by Cristian Aguerre Clavel on 10/12/13.
 */
public class Destino  {
    private String zona;
    private String continente;
    private int precio;

    public Destino (String zona, String continente, int precio)
    {
        this.zona = zona;
        this.continente = continente;
        this.precio = precio;
    }


    public String getZona()
    {
        return zona;
    }

    public String getContinente()
    {
        return continente;
    }

    public int getPrecio(){
        return precio;
    }


}

