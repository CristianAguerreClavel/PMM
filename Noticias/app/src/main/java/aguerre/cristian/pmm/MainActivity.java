package aguerre.cristian.pmm;

import android.app.Activity;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends Activity {
    private Button boton;
    private Button boton2;
    private TextView texto;
    private ListView lista;
    private List datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button)findViewById(R.id.Boton1);
        boton2 = (Button)findViewById(R.id.Boton2);

        texto = (TextView)findViewById(R.id.text1);
        lista = (ListView)findViewById(R.id.lista);
        //Lisener del boton
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String noticias = buscarNoticias();
                    texto.append(noticias);
                }catch (Exception e){
                    texto.append("Error al conectar");
                    e.printStackTrace();
                }
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarLista();
            }
        });


    }

    private String buscarNoticias() throws Exception {
        String salida ="";
        int i =0, j=0;

        //Direccion de la pagina (RSS) que queremos obtener (Corresponde a titulares del periodico)
        URL url = new URL("http://www.elpais.com/rss/feed.html?feedId=1022");
        //Conexion de tipo HTTP
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        //Añadimos una cabecera HTTP para que identificarnos y evitar obtener un error de aquellos
        //servidores que prohiben la respuesta a aquiellos clientes que no se identifican.
        conexion.setRequestProperty("User-Agent", "Mozilla/5.0" + "(Linux; Android 1.5; es.ES) Ejemplo HTTP");

        if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK){
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream()));
            String linea = lector.readLine();
            while (linea != null){
                //Si encontramos la etiqueta <title> podemos recuperar la noticia
                if(linea.indexOf("<title>")>=0){
                    i = linea.indexOf("<title>")+16;
                    j = linea.indexOf("</title>")-3;
                    //Noticia n = new Noticia(salida);
                    //salida += linea.substring(i,j);
                    //Noticia noticia = new Noticia(salida);
                    accionesSql accionesSql1 = new accionesSql(this);
                    accionesSql1.insertarNoticia(String.valueOf(linea.substring(i,j)));
                    //salida += "\n------------------------\n";
                    //leemos la siguiente linea
                }
                linea = lector.readLine();
            }
            lector.close();
        } else {
            salida = "No encontrado";
        }
        conexion.disconnect();
        return salida;
    }

    public void cargarLista(){
        accionesSql a = new accionesSql(this);
        datos = a.recuperarNOTICIAS();
        ArrayAdapter <Noticia> adapter = new ArrayAdapter<Noticia>(this,android.R.layout.simple_list_item_1,android.R.id.text1,datos);
        lista.setAdapter(adapter);
    }



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
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
