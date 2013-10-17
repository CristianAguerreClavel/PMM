package aguerre.cristian.pagrupaciondecontroles;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	static TextView lblMensaje;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lblMensaje = (TextView)findViewById(R.id.opSeleccionada);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		
		switch (item.getItemId()) {
			case R.id.controlesSeleccion:
				lblMensaje.setText("Controles de seleccion");
				Intent intent = new Intent (MainActivity.this, controlesSeleccion.class);
				startActivity(intent);
				return true;
			case R.id.listas:
				lblMensaje.setText("Listas");;
				return true;
			case R.id.acercaDe:
				lblMensaje.setText("Acerca de");;
				return true;
			default:
				return super.onOptionsItemSelected(item);
			}
	}

}
