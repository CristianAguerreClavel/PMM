package com.example.listasavanzadas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class actividadPersona extends Activity {

	public void onCreate(Bundle savedInstaceState){
		super.onCreate(savedInstaceState);
		setContentView(R.layout.persona);
		
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
