package aguerre.cristian.pmm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends ActionBarActivity {

    static class ViewHolder
    {
        TextView zona;
        TextView continente;
        TextView precio;
    }

    int precioZona = 0;
    String zona = "";
    String continente = "";
    int opRadio = 0;
    final EditText textoPeso = (EditText)findViewById(R.id.textoPeso);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*-----------------------------------------------------------------------------------------------------*/
/* ---------------------------------------SPINNER -----------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------*/
       Spinner spinner = (Spinner)findViewById(R.id.spinerZona);

        final Destino[] datos = new Destino[]
        {
            new Destino ("Zona A", "Asia/Oceania",30),
            new Destino ("Zona B", "America/Africa",20),
            new Destino ("Zona C", "Europa",10)
        };


        class AdaptadorSpinnerZona extends ArrayAdapter {

            Activity context;

            AdaptadorSpinnerZona(Activity context)
            {
                super(context, R.layout.inflade_spinner,datos);
                this.context = context;
            }

            public View getDropDownView(int posicion,View convertView,ViewGroup parent){//Cuando se despliega el spinner
                return getView(posicion,convertView,parent);
            }

            public View getView(int position, View convertView, ViewGroup parent)
            {
                View item = convertView;
                ViewHolder holder;

                if (item == null)// para mejorar la ejecucion, si ya existe no infla nuevamente
                {
                    LayoutInflater inflater = context.getLayoutInflater();
                    item = inflater.inflate(R.layout.inflade_spinner, null);

                    holder = new ViewHolder();
                    holder.zona = (TextView)item.findViewById(R.id.labelZona);
                    holder.continente = (TextView)item.findViewById(R.id.labelContinente);
                    holder.precio = (TextView)item.findViewById(R.id.labelPrecio);

                    item.setTag(holder);

                }else
                {
                    holder = (ViewHolder)item.getTag();
                }

                holder.zona.setText(datos[position].getZona());
                holder.continente.setText(datos[position].getContinente());
                holder.precio.setText(datos[position].getPrecio());

                return(item);
            }

        }
        AdaptadorSpinnerZona adaptadorSpin = new AdaptadorSpinnerZona(this);
        spinner.setAdapter(adaptadorSpin);

/*-----------------------------------------------------------------------------------------------------*/
/*--------------------------------------RADIO BUTTONS--------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------*/
     /*   final RadioGroup rg = (RadioGroup)findViewById(R.id.radioTarifa);
        final RadioButton tarifaN = (RadioButton)findViewById(R.id.tarifaNormal);
        final RadioButton tarifaU = (RadioButton)findViewById(R.id.tarifaUrgente);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (tarifaN.getId() == checkedId){
                   opRadio = 1;
                }if (tarifaU.getId() == checkedId){
                   opRadio = 2;
                }
            }
        });
/*-----------------------------------------------------------------------------------------------------*/
/*-------------------------------------ZONA SELECCIONADA-----------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------*/
        /*
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> a, View v, int position, long id) {

                String zon = ((Destino)a.getAdapter().getItem(position)).getZona();
                String con = ((Destino)a.getAdapter().getItem(position)).getContinente();
                int pre = ((Destino)a.getAdapter().getItem(position)).getPrecio();

                precioZona = pre;
                zona = zon;
                continente = con;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
*/
        /*-----------------------------------------------------------------------------------------------------*/
/*-----------------------------------BUTTON Y PASO DE INFORMACION--------------------------------------*/
/*-----------------------------------------------------------------------------------------------------*/

        /*final Button calcular = (Button)findViewById(R.id.botonCalculos);

        calcular.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {

                double precioTotal = calcularPrecio();
                //Creamos el Itent
                Intent intent = new Intent (MainActivity.this, Resultado.class);

                //Creamos la informacion a pasar entre actividades
                Bundle b = new Bundle();
                b.putDouble("precioT",precioTotal);
                b.putString("zonaSelec",zona);
                b.putString("continente",continente);

                //Añadimos la informacion al intent
                intent.putExtras(b);

                //INiciamos la nueva actividad
                startActivity(intent);
            }
        });


    }*/
/*-----------------------------------------------------------------------------------------------------*/
/*-------------------------------------------CALCULOS--------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------*/

/*
public double calcularPrecio(){
    double res;
    double extra = 0;
    int peso = Integer.parseInt(textoPeso.getText().toString());

    if(peso <=5){
        extra = 1;
    }else if(peso > 5 && peso <= 10){
        extra = 1.5;
    }else{
        extra = 2;
    }
    res = precioZona+extra;

    if(opRadio == 2){
        double porcentaje = res*0.30;
        res = res + porcentaje;
    }
    return res;
}*/
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/


    }}
}
    }

}
