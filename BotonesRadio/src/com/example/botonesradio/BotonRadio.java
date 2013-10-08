package com.example.botonesradio;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BotonRadio extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio);
		
		final RadioGroup rg = (RadioGroup)findViewById(R.id.gruporb);
		final RadioButton op1 = (RadioButton)findViewById(R.id.radio1);
		final RadioButton op2 = (RadioButton)findViewById(R.id.radio2);
		final TextView texto = (TextView)findViewById(R.id.radioOpciones);
		
		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (op1.getId() == checkedId){
					texto.setText("selecionda:" +op1.getText());
				}if (op2.getId() == checkedId){
					texto.setText("selecionda:" + op2.getText());
				}
			}
		});
		
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}