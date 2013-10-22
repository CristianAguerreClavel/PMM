package aguerre.cristian.pagrupaciondecontroles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by mati on 22/10/13.
 */
public class Radio extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        final RadioGroup rg = (RadioGroup)findViewById(R.id.grupo1);
        final RadioButton op1 = (RadioButton)findViewById(R.id.radio1);
        final RadioButton op2 = (RadioButton)findViewById(R.id.radio2);
        final TextView texto = (TextView)findViewById(R.id.textView1);

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
}
