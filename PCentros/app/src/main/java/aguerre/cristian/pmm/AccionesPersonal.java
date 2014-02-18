package aguerre.cristian.pmm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Cristian Aguerre Clavel on 17/02/14.
 */
public class AccionesPersonal extends Activity{
    Button btnCrearBD;
    Button btnVerPersonal;
    Button btnInsertarPersona;
    Button btnBorrarPersona;
    Button btnInsertarPorDefecto;
    BDPersonal bdPersonal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_acciones_bd_personal);

        btnCrearBD = (Button)findViewById(R.id.btnCrearBDPersonal);
        btnVerPersonal = (Button)findViewById(R.id.btnVerPersona);
        btnInsertarPersona  = (Button)findViewById(R.id.btnInsertarPersonal);
        btnBorrarPersona = (Button)findViewById((R.id.btnBorrarPersona));
        btnInsertarPorDefecto = (Button)findViewById((R.id.btnInsertarPorDefecto));

        bdPersonal = new BDPersonal(getApplicationContext());

        btnCrearBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdPersonal = new BDPersonal(getApplicationContext());//Inecesario
            }
        });

        btnVerPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccionesPersonal.this,VerPersonal.class);
                startActivity(intent);
            }
        });
/*
        btnInsertarPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentInsertar = new Intent(AccionesCentros.this,ActivityInsertarCentro.class);
                startActivity(intentInsertar);
            }
        });
*/
        btnBorrarPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBorrar = new Intent(AccionesPersonal.this,ActivityBorrarPersona.class);
                startActivity(intentBorrar);
            }
        });

        btnInsertarPorDefecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdPersonal.insertDefault();
            }
        });

    }
}

