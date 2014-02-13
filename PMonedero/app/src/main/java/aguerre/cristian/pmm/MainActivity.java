package aguerre.cristian.pmm;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private Button button;
    public EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.botton);
        editText = (EditText)findViewById(R.id.dinero);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Dentro de onClick");
                int dinero = Integer.valueOf(getEditText());
                System.out.println(dinero);
                activityDesglose(dinero);
            }
        });
    }

    public String getEditText(){
        System.out.print("hola");
        String dinero2;
        dinero2 = editText.getText().toString();
        System.out.println(dinero2);
        return dinero2;
    }

    public void activityDesglose(int dinero){
        Intent intent = new Intent(MainActivity.this,desglose_dinero.class);
        Bundle bundle = new Bundle();
        bundle.putInt("dinero",dinero);
        intent.putExtras(bundle);
        startActivity(intent);
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
