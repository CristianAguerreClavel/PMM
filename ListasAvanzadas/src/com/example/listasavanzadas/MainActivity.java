package com.example.listasavanzadas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity 
{

	static class ViewHolder
	{
		TextView nombre;
		TextView apellido;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		final ListView list= (ListView)findViewById(R.id.lista);
		final Spinner spi = (Spinner)findViewById(R.id.spinner);
		
		final Persona[] datos = new Persona[]
				{
					new Persona ("Cristian", "Aguerre Clavel"),
					new Persona ("Nerea", "Muñoz Lopez"),
					new Persona ("Cristian", "Gutierrez Marinez"),
					new Persona ("Cristian", "Aguerre")
				};
		
		class AdaptadorPersonas extends ArrayAdapter //Adaptador
		{
			Activity context;
			
			AdaptadorPersonas(Activity context)
			{
				super(context, R.layout.listitem_persona,datos);
				this.context = context;
			}
			
			
			public View getView(int position, View convertView, ViewGroup parent)
			{
				View item = convertView;
				ViewHolder holder;
				
				if (item == null)// para mejorar la ejecucion, si ya existe no infla nuevamente
				{
					LayoutInflater inflater = context.getLayoutInflater();
					item = inflater.inflate(R.layout.listitem_persona, null);
					
					holder = new ViewHolder();
					holder.nombre = (TextView)item.findViewById(R.id.LblNombre);
					holder.apellido = (TextView)item.findViewById(R.id.LblApellido);
					
					item.setTag(holder);
							
				}else
				{
					holder = (ViewHolder)item.getTag();
				}
				
				holder.nombre.setText(datos[position].getNombre());
				holder.apellido.setText(datos[position].getApellido());
				
				return(item);
			}
		}
		
		AdaptadorPersonas adaptador = new AdaptadorPersonas(this);
		list.setAdapter(adaptador);
		
		//oyente de la lista
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position,long id) {
				//Alternativa 1
				String nombre = ((Persona)a.getAdapter().getItem(position)).getNombre();
				String apellido = ((Persona)a.getAdapter().getItem(position)).getApellido();
				//bundle para pasar los datos a la actividad persona
				//Creamos el Itent
				Intent intent = new Intent (MainActivity.this, actividadPersona.class);
				
				//Creamos la informacion a pasar entre actividades
				Bundle b = new Bundle();
				b.putString("NOMBRE", nombre.toString());
				b.putString("APELLIDO", apellido.toString());
				
				//Añadimos la informacion al intent
				intent.putExtras(b);
				
				//Iniciamos la nueva actividad
				startActivity(intent);
			}
			
		});
		
		//---------------------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------

		//SPINNER
		class AdaptadorSpinnerPersona extends ArrayAdapter{
			
			Activity context;
			
			AdaptadorSpinnerPersona(Activity context)
			{
				super(context, R.layout.listitem_persona,datos);
				this.context = context;
			}
			
			public View getView(int position, View convertView, ViewGroup parent)
			{
				View item = convertView;
				ViewHolder holder;
				
				if (item == null)// para mejorar la ejecucion, si ya existe no infla nuevamente
				{
					LayoutInflater inflater = context.getLayoutInflater();
					item = inflater.inflate(R.layout.listitem_persona, null);
					
					holder = new ViewHolder();
					holder.nombre = (TextView)item.findViewById(R.id.LblNombre);
					holder.apellido = (TextView)item.findViewById(R.id.LblApellido);
					
					item.setTag(holder);
							
				}else
				{
					holder = (ViewHolder)item.getTag();
				}
				
				holder.nombre.setText(datos[position].getNombre());
				holder.apellido.setText(datos[position].getApellido());
				
				return(item);
			}
			
		}
		AdaptadorSpinnerPersona adaptadorSpin = new AdaptadorSpinnerPersona(this);
		spi.setAdapter(adaptadorSpin);
		
	}
	
	
	
}
	
