package aguerre.cristian.pmm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Cristian Aguerre Clavel on 3/02/14.
 */
public class AccionesCentros extends Activity {
    Button btnCrearBD;
    Button btnVerCentros;
    Button btnInsertarCentros;
    Button btnBorrarCentro;
    Button btnInsertarPorDefecto;
    BDCentros bdCentros;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_acciones_bd_centros);

        btnCrearBD = (Button)findViewById(R.id.btnCrearBDCentros);
        btnVerCentros = (Button)findViewById(R.id.btnVerCentros);
        btnInsertarCentros = (Button)findViewById(R.id.btnInsertarCentro);
        btnBorrarCentro = (Button)findViewById((R.id.btnBorrarCentro));
        btnInsertarPorDefecto = (Button)findViewById((R.id.btnInsertarPorDefecto));

        bdCentros = new BDCentros(getApplicationContext());

        btnCrearBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdCentros = new BDCentros(getApplicationContext());//Inecesario
            }
        });

        btnVerCentros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccionesCentros.this,VerCentros.class);
                startActivity(intent);
            }
        });

        btnInsertarCentros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intentInsertar = new Intent(AccionesCentros.this,ActivityInsertarCentro.class);
              startActivity(intentInsertar);
            }
        });

        btnBorrarCentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBorrar = new Intent(AccionesCentros.this,ActivityBorrarCentro.class);
                startActivity(intentBorrar);
            }
        });

        btnInsertarPorDefecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdCentros.insertDefault();
            }
        });

    }
}
