package aguerre.cristian.pmm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cristian Aguerre Clavel on 6/02/14.
 */
public class ActivityInsertarCentro extends Activity {
    BDCentros bd = new BDCentros(this);

    EditText codCentro;
    EditText nomCentro;
    EditText tipoCentro;
    EditText direccionCentro;
    EditText telefonoCentro;
    EditText plazasCentro;
    Button btnInsertar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_centro);

        codCentro = (EditText)findViewById(R.id.editCodCentro);
        nomCentro = (EditText)findViewById(R.id.editNombre);
        tipoCentro = (EditText)findViewById(R.id.editTipo);
        direccionCentro = (EditText)findViewById(R.id.editDireccion);
        telefonoCentro = (EditText)findViewById(R.id.editTelefono);
        plazasCentro = (EditText)findViewById(R.id.editNumPlazas);
        btnInsertar = (Button)findViewById(R.id.btnInsert);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cod = Integer.parseInt(codCentro.getText().toString());
                String tipo = tipoCentro.getText().toString();
                String nombre = nomCentro.getText().toString();
                String direccion = direccionCentro.getText().toString();
                String telefono = telefonoCentro.getText().toString();
                int plazas = Integer.parseInt(plazasCentro.getText().toString());
                bd.insertarCentro(cod,tipo,nombre,direccion,telefono,plazas);
                finish();
            }
        });

        //(int id, String tipoCentro, String nombre, String direccion, String telefono, int numPlazas){
    }

    public boolean comprobar(int cod, String tipo, String nombre, String direccion, String telefono, int plazas){
        //if(cod == 0 || tipo == "" || nombre == "" || direccion == "" || telefono == "" || plazas == 0){
          //  return false;
        //}
        return true;
    }

}
