package aguerre.cristia.pmm;

import android.os.StrictMode;
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
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import org.apache.http.util.EntityUtils;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        httpHandler handler = new httpHandler();
        String txt = handler.post("http://192.168.24.192:8080/hola.php");

        TextView t = (TextView)findViewById(R.id.text1);
        t.setText(txt);
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

    public class httpHandler {

        public String post(String posturl){

            try {

                HttpClient httpclient = new DefaultHttpClient();
                /*Creamos el objeto de HttpClient que nos permitira conectarnos mediante peticiones http*/
                HttpPost httppost = new HttpPost(posturl);
                /*El objeto HttpPost permite que enviemos una peticion de tipo POST a una URL especificada*/
                //AÑADIR PARAMETROS
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("data","Variable 1"));
                params.add(new BasicNameValuePair("info","Otro mensaje"));
		    /*Una vez añadidos los parametros actualizamos la entidad de httppost, esto quiere decir en pocas palabras anexamos los parametros al objeto para que al enviarse al servidor envien los datos que hemos añadido*/
                httppost.setEntity(new UrlEncodedFormEntity(params));

                  /*Finalmente ejecutamos enviando la info al server*/
                HttpResponse resp = httpclient.execute(httppost);
                HttpEntity ent = resp.getEntity();/*y obtenemos una respuesta*/

                String text = EntityUtils.toString(ent);

                return text;

            }
            catch(Exception e) { return "error";}

        }

    }

}
