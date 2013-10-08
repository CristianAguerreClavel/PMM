package com.example.holausuarioclase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PantallaMensaje extends Activity {
	
	public void onCreate(Bundle savedInstaceState){
		super.onCreate(savedInstaceState);
		setContentView(R.layout.pantallamensaje);
		
		//Localizar los controles
		TextView txtMensaje = (TextView)findViewById(R.id.TxtMensaje);
		
		//Accedemos al intent que ha originado la actividad origianl y recuperamos su informaicon asociada
		Bundle bundle = getIntent().getExtras();
		
		//Consturimos el mensaje a mostrar
		txtMensaje.setText("Hola " + bundle.getString("NOMBRE"));
	}
	

}
