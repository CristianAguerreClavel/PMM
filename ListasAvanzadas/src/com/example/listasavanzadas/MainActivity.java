package com.example.listasavanzadas;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		final ListView list= (ListView)findViewById(R.id.lista);
		
		final Persona[] datos = new Persona[]
				{
					new Persona ("Cristian", "Aguerre Clavel"),
					new Persona ("Nerea", "Muñoz Lopez"),
					new Persona ("Cristian", "Gutierrez Marinez"),
					new Persona ("Cristian", "Aguerre")
				};
		
		class AdaptadorPersonas extends ArrayAdapter
		{
			Activity context;
			
			AdaptadorPersonas(Activity context)
			{
				super(context, R.layout.listitem_persona,datos);
				this.context = context;
			}
			
			public View getView(int position, View convertView, ViewGroup parent)
			{
				LayoutInflater inflater = context.getLayoutInflater();
				View item = inflater.inflate(R.layout.listitem_persona, null);
				
				TextView lblNombre = (TextView)item.findViewById(R.id.LblNombre);
				lblNombre.setText(datos[position].getNombre());
				
				TextView lblApellido = (TextView)item.findViewById(R.id.LblApellido);
				lblApellido.setText(datos[position].getApellido());
				
				return(item);
			}
		}
		
		AdaptadorPersonas adaptador = new AdaptadorPersonas(this);
		list.setAdapter(adaptador);
	}
	
	
	
}
