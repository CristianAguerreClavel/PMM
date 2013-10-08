package com.example.botonesradio;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button ejeRadio = (Button)findViewById(R.id.btnRadios);
		final Button ejeCheck = (Button)findViewById(R.id.btnChekeds);
		
		ejeRadio.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Creamos el Itent
				Intent intent = new Intent (MainActivity.this, BotonRadio.class);
				//Iniciamos la nueva actividad
				startActivity(intent);
			}
		});
		
		ejeCheck.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Creamos el Itent
				Intent intent2 = new Intent (MainActivity.this, BotonCheck.class);
				//Iniciamos la nueva actividad
				startActivity(intent2);
			}
		});
	}

	

}
