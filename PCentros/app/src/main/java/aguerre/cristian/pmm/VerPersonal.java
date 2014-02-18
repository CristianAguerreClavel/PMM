package aguerre.cristian.pmm;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cristian Aguerre Clavel on 17/02/14.
 */
public class VerPersonal extends Activity {

    class ViewHolder
    {
        TextView cod_centro;
        TextView dni;
        TextView apellido;
        TextView funcion;
        TextView salario;
    }

    ListView lista_personal;
    ArrayList<Personal> personal;
    BDPersonal bd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ver_personal);
        lista_personal = (ListView)findViewById(R.id.lista_personal);
        personal = new ArrayList<Personal>();
        bd = new BDPersonal(getApplicationContext());
        personal = bd.recuperarPersonal();

        //Centros c = new Centros(1,"a","ies serpis","calle serpis","3654128",850);
        //centros.add(c);

        class AdapterPersonal extends ArrayAdapter {

            Activity context;
            ViewHolder holder;

            public AdapterPersonal(Activity context){
                super(context, R.layout.layout_lista_personal, personal);
                this.context = context;
            }

            public View getView(int posicion, View convertView, ViewGroup parent){
                View item = convertView;
                holder = new ViewHolder();
                if(item == null){
                    LayoutInflater layoutInflater = context.getLayoutInflater();
                    item = layoutInflater.inflate(R.layout.layour_lista_centros,null);

                    holder.apellido = (TextView)item.findViewById(R.id.LabelCentro);
                    holder.cod_centro = (TextView)item.findViewById(R.id.LabelCodCentro);
                    holder.dni = (TextView) item.findViewById(R.id.LabelTipoCentro);
                    holder.funcion = (TextView) item.findViewById(R.id.LabelDireccion);
                    holder.salario = (TextView)item.findViewById(R.id.LabelTelefono);
                    item.setTag(holder);
                }else{
                    holder = (ViewHolder)item.getTag();
                }
                holder.cod_centro.setText(String.valueOf(personal.get(posicion).getCod_centro()));
                holder.dni.setText(String.valueOf(personal.get(posicion).getDni()));
                holder.apellido.setText(personal.get(posicion).getApellido());
                holder.funcion.setText(String.valueOf(personal.get(posicion).getFuncion()));
                holder.salario.setText(String.valueOf(personal.get(posicion).getSalario()));

                return item;

            }
        }
        AdapterPersonal adapteerPersonal = new AdapterPersonal(this);
        lista_personal.setAdapter(adapteerPersonal);

    }



}

