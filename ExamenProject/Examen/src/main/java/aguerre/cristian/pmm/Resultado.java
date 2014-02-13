package aguerre.cristian.pmm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Cristian Aguerre Clavel on 10/12/13.
 */
public class Resultado extends Activity {
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.resultado_ac);

        //Localizar los controles
        TextView txtZona = (TextView)findViewById(R.id.zona);
        TextView txtCont = (TextView)findViewById(R.id.continente);
        TextView txtCoste = (TextView)findViewById(R.id.costefinal);
        Button btn = (Button)findViewById(R.id.botonCambio);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Resultado.this,CalcularCambio.class);
                startActivity(intent2);
            }
        });


 //Accedemos al intent que ha originado la actividad origianl y recuperamos su informaicon asociada
        Bundle bundle = getIntent().getExtras();

        //Consturimos el mensaje a mostrar
        txtZona.setText(bundle.getString("zonaSelec"));
        txtCont.setText(bundle.getString("continente"));
        txtCoste.setText(String.valueOf(bundle.getDouble("precioT")));
    }

}
