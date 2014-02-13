package aguerre.cristian.pmm;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cristian Aguerre Clavel on 3/02/14.
 */
public class VerCentros extends Activity {

    class ViewHolder
    {
        TextView cod_centro;
        TextView tipo_centro;
        TextView nombre;
        TextView direccion;
        TextView telefono;
        TextView plazas;
    }

    ListView lista_centros;
    ArrayList<Centros> centros;
    BDCentros bd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ver_centros);
        lista_centros = (ListView)findViewById(R.id.lista_centros);
        centros = new ArrayList<Centros>();
        bd = new BDCentros(getApplicationContext());
        centros = bd.recuperarCentros();

        //Centros c = new Centros(1,"a","ies serpis","calle serpis","3654128",850);
        //centros.add(c);

        class AdapterCentros extends ArrayAdapter{

            Activity context;
            ViewHolder holder;

            public AdapterCentros(Activity context){
                super(context, R.layout.layour_lista_centros, centros);
                this.context = context;
            }

            public View getView(int posicion, View convertView, ViewGroup parent){
                View item = convertView;
                holder = new ViewHolder();
              if(item == null){
                LayoutInflater layoutInflater = context.getLayoutInflater();
                item = layoutInflater.inflate(R.layout.layour_lista_centros,null);

                holder.nombre = (TextView)item.findViewById(R.id.LabelCentro);
                holder.cod_centro = (TextView)item.findViewById(R.id.LabelCodCentro);
                holder.tipo_centro = (TextView) item.findViewById(R.id.LabelTipoCentro);
                holder.direccion = (TextView) item.findViewById(R.id.LabelDireccion);
                holder.telefono = (TextView)item.findViewById(R.id.LabelTelefono);
                holder.plazas = (TextView)item.findViewById(R.id.LabelPlazas);
                item.setTag(holder);
              }else{
                  holder = (ViewHolder)item.getTag();
               }
                holder.nombre.setText(centros.get(posicion).getNombre());
                holder.cod_centro.setText(String.valueOf(centros.get(posicion).getCod_centro()));
                holder.tipo_centro.setText(centros.get(posicion).getTipo_centro());
                holder.direccion.setText(centros.get(posicion).getDireccion());
                holder.plazas.setText(String.valueOf(centros.get(posicion).getNum_plazas()));
                holder.telefono.setText(centros.get(posicion).getTelefono());

                return item;

            }
        }
        AdapterCentros adapteerCentros = new AdapterCentros(this);
        lista_centros.setAdapter(adapteerCentros);

    }



}

