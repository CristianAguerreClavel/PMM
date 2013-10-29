package aguerre.cristian.pagrupaciondecontroles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by nerea on 29/10/13.
 */
public class seleccionDeLista extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_de_lista);

        Button bLista = (Button) findViewById(R.id.botonLista);
        Button bSpinner = (Button) findViewById(R.id.botonSpinner);


        bLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Itent
                Intent intent = new Intent(seleccionDeLista.this, Lista.class);
                //INiciamos la nueva actividad
                startActivity(intent);
            }
        });


        bSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Itent
                Intent intent2 = new Intent(seleccionDeLista.this, LSpinner.class);
                //INiciamos la nueva actividad
                startActivity(intent2);
            }
        });
    }



}
