package com.example.botonesradio;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class BotonCheck extends Activity {
	
	CheckBox checkbox1;
    CheckBox checkbox2 ;
	CheckBox checkbox3;
	Button btnActivar; 
	TextView texto = null ; 
	
	String msg = null;
	
	public void escribirEnEtiqueta(){
		msg = "Te gusta ";
		if (checkbox1.isChecked()){
			msg += checkbox1.getText();
		}
		if (checkbox2.isChecked()){
			msg += " "+checkbox2.getText();
		}if(checkbox3.isChecked()){
			msg += " "+checkbox3.getText();
		}
		texto.setText(msg);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checked);
		
		checkbox1 = (CheckBox)findViewById(R.id.Chk1);
		checkbox2 = (CheckBox)findViewById(R.id.Chk2);
		checkbox3 = (CheckBox)findViewById(R.id.Chk3);
		btnActivar = (Button)findViewById(R.id.BtnActivar);
		texto = (TextView)findViewById(R.id.TxtOpciones);
		
		btnActivar.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				escribirEnEtiqueta();	
			}
		});
	}
	
}
