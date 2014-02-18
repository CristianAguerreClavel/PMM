package aguerre.cristian.pmm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Cristian Aguerre Clavel on 14/01/14.
 */
public class CalcularCambio extends Activity {
    private TextView cantidadMonedas;
    private int[] modenas = {500,200,100,50,20,10,5,2,1};
    private int[] resultado = {0,0,0,0,0,0,0,0,0};

    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.calcularcambio_xml);
        cantidadMonedas = (TextView)findViewById(R.id.cantidad);
        setCantidad();
        desglosarCantidad();
        setResultado();
    }

    public void setCantidad(){
        Bundle bundle = getIntent().getExtras();
        String dineroRecibido = String.valueOf(bundle.getInt("money"));

        cantidadMonedas.setText(dineroRecibido);
    }

    public void desglosarCantidad(){
        int cantidad=Integer.valueOf(cantidadMonedas.getText().toString());
        for (int i = 0; i <modenas.length;){
            if(cantidad-modenas[i]>=0){
                resultado[i]++;
                cantidad = cantidad-modenas[i];
            }else{
                i++;
            }
        }
        //setResultado();
    }

    public void setResultado(){
        TextView tQuinientos = (TextView)findViewById(R.id.quinientos);
        TextView tDoscientos = (TextView)findViewById(R.id.doscientos);
        TextView tCien = (TextView)findViewById(R.id.cien);
        TextView tCincuenta = (TextView)findViewById(R.id.cincuenta);
        TextView tVeinte = (TextView)findViewById(R.id.veinte);
        TextView tDiez = (TextView)findViewById(R.id.diez);
        TextView tCinco = (TextView)findViewById(R.id.cinco);
        TextView tDos = (TextView)findViewById(R.id.dos);
        TextView tUno = (TextView)findViewById(R.id.uno);

        tQuinientos.setText(String.valueOf(resultado[0]));
        tDoscientos.setText(String.valueOf(resultado[1]));
        tCien.setText(String.valueOf(resultado[2]));
        tCincuenta.setText(String.valueOf(resultado[3]));
        tVeinte.setText(String.valueOf(resultado[4]));
        tDiez.setText(String.valueOf(resultado[5]));
        tCinco.setText(String.valueOf(resultado[6]));
        tDos.setText(String.valueOf(resultado[7]));
        tUno.setText(String.valueOf(resultado[8]));
    }
}
