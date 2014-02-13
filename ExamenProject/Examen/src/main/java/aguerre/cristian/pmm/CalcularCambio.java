package aguerre.cristian.pmm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Cristian Aguerre Clavel on 14/01/14.
 */
public class CalcularCambio extends Activity {

    int[] monedas = new int[]{500,200,100,50,20,10,5,2,1};
    int[] cantidadMonedas = new int[]{0,0,0,0,0,0,0,0,0};
    EditText ed;

    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.calcularcambio_xml);
        ed = (EditText)findViewById(R.id.monedasNecesarias);

        int cantidad = 100;
        calculoCambio(cantidad);

    }


    public void calculoCambio(int cantidad){
        while (cantidad <0){
            for (int i = 0; i<monedas.length;i++){
                if(cantidad % monedas[i]==0){
                    cantidadMonedas[i]++;
                }
            }
        }

        for (int j=0; j<cantidadMonedas.length;j++){
            ed.setText(ed+ "," +String.valueOf((cantidadMonedas[j])));
        }
    }

}
