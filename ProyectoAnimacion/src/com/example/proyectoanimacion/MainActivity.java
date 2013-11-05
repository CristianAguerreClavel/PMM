package com.example.proyectoanimacion;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends Activity {
		AnimationDrawable animacion;

	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        //Obtenemos el recurso creado en animacion.xml
	        animacion = (AnimationDrawable) getResources().getDrawable(R.anim.animacion);
	        //Creamos una vista que contendrá una imagen
	        ImageView imagen = new ImageView(this);
	        //Le ponemos color de fondo
	        imagen.setBackgroundColor(Color.WHITE);
	        //Cargamos en lugar de una imagen, una animación.
	        imagen.setImageDrawable(animacion);
	        setContentView(imagen);
	    }
	    
	    public boolean onTouchEvent(MotionEvent evento) {
	    	//Al realizar una pulsación en pantalla
	    	if (evento.getAction() == MotionEvent.ACTION_DOWN) {
	    		//Ponemos en marcha la animación
	    		animacion.start();
	    		return true;
	    	}
	    	return super.onTouchEvent(evento);
	    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
