package aguerre.cristian.pagrupaciondecontroles;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by mati on 22/10/13.
 */
public class PersonaActividad extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);


        //Localizar los controles
        TextView nombre = (TextView)findViewById(R.id.personaNombre);
        TextView apellido = (TextView)findViewById(R.id.personaApellido);

        //Accedemos al intent que ha originado la actividad original y recuperamos su informaicon asociada
        Bundle bundle = getIntent().getExtras();

        //Consturimos el mensaje a mostrar
        nombre.setText(bundle.getString("NOMBRE"));
        apellido.setText(bundle.getString("APELLIDO"));

    }
}
