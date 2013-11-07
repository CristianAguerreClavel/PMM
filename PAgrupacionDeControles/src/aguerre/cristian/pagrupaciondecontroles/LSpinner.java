package aguerre.cristian.pagrupaciondecontroles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;

/**
 * Created by Cristian on 29/10/13.
 */
public class LSpinner extends Activity {

    static class ViewHolder
    {
        TextView nombre;
        TextView apellido;
        ImageView img;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        Spinner spinner = (Spinner)findViewById(R.id.Tspinner);


        final Persona[] datos = new Persona[]
                {
                        new Persona ("Cristian", "Aguerre Clavel",R.drawable.ic_launcher),
                        new Persona ("Nerea", "Muñoz Lopez",R.drawable.ic_launcher),
                        new Persona ("Cristian", "Gutierrez Marinez",R.drawable.ic_launcher),
                        new Persona ("Cristian", "Aguerre",R.drawable.ic_launcher)
                };


        class AdaptadorSpinnerPersona extends ArrayAdapter {

            Activity context;

            AdaptadorSpinnerPersona(Activity context)
            {
                super(context, R.layout.inflado_spinner,datos);
                this.context = context;
            }

            public View getDropDownView(int posicion,View convertView,ViewGroup parent){
                return getView(posicion,convertView,parent);
            }

            public View getView(int position, View convertView, ViewGroup parent)
            {
                View item = convertView;
                ViewHolder holder;

                if (item == null)// para mejorar la ejecucion, si ya existe no infla nuevamente
                {
                    LayoutInflater inflater = context.getLayoutInflater();
                    item = inflater.inflate(R.layout.inflado_spinner, null);

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
        spinner.setAdapter(adaptadorSpin);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> a, View v, int position, long id) {
                //Alternativa 1
                String nombre = ((Persona)a.getAdapter().getItem(position)).getNombre();
                String apellido = ((Persona)a.getAdapter().getItem(position)).getApellido();
                //bundle para pasar los datos a la actividad persona
                //Creamos el Itent
                Intent intent = new Intent (LSpinner.this, SegundaPantallaSpinner.class);

                //Creamos la informacion a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("NOMBRE", nombre.toString());
                b.putString("APELLIDO", apellido.toString());

                //Añadimos la informacion al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


}


