package com.example.listasandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ListView lista= (ListView)findViewById(R.id.lista);
		final Spinner spinner = (Spinner)findViewById(R.id.spinner);
		final TextView textoLista = (TextView)findViewById(R.id.textoLista);
		final TextView textoSpinner = (TextView)findViewById(R.id.textoSpinner);
		
		final String[] datos = new String[]{"uno","dos","tres","cuatro"};
		
		//Adaptador para la lista
		ArrayAdapter<String> adaptadorLista = 
				new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);

		//Adaptador para el spinner
		ArrayAdapter<String> adaptadorSpinner = 
				new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos);
		adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		
		lista.setAdapter(adaptadorLista);
		spinner.setAdapter(adaptadorSpinner);
		
		//Evento control sobre lista -> milista.setOnItemClickListener(new OnItemClick on itemclick
		//Evento control sobre spinner -> mispinner.setOnItemSelectListener OnItemSelect on
		
		/* Evento spinner */
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int posicion, long arg3) {
				textoSpinner.setText(datos[posicion]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
	
		/* Evento lista */
		lista.setOnItemClickListener(new OnItemClickListener (){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int posicion,
					long arg3) {
				textoLista.setText(lista.getItemAtPosition(posicion).toString());
			}
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
