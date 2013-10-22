package aguerre.cristian.pagrupaciondecontroles;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by mati on 22/10/13.
 */
public class Chekbox  extends Activity {

    CheckBox check1=null;
    CheckBox check2=null;
    CheckBox check3=null;
    Button btnActivar=null;
    TextView texto=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        check1 = (CheckBox) findViewById(R.id.chek1);
        check2 = (CheckBox) findViewById(R.id.chek2);
        check3 = (CheckBox) findViewById(R.id.chek3);
        btnActivar = (Button) findViewById(R.id.btnActivar);
        texto = (TextView)findViewById(R.id.lblTexto);

        btnActivar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                escribirEnEtiqueta();
            }
        });

    }

    public void escribirEnEtiqueta(){
        String msg = "";
        if (check1.isChecked()){
            msg += check1.getText();
        }
        if (check2.isChecked()){
            msg += " "+check2.getText();
        }if(check3.isChecked()){
            msg += " "+check3.getText();
        }
        texto.setText(msg);
    }

}
