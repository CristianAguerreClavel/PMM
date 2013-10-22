package aguerre.cristian.pagrupaciondecontroles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class controlesSeleccion extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.controles_seleccion);

        final Button botonCheck = (Button) findViewById(R.id.botonCheckbox);
        //final Button botonCombo = (Button) findViewById(R.id.botonComboBox);
        final Button botonRadio = (Button) findViewById(R.id.botonRadio);

        botonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creamos el Itent
                Intent intent = new Intent(controlesSeleccion.this, Chekbox.class);
                 //INiciamos la nueva actividad
                startActivity(intent);
            }
        });

        botonRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(controlesSeleccion.this,Radio.class);
                startActivity(intent2);
            }
        });

		
	}
}
