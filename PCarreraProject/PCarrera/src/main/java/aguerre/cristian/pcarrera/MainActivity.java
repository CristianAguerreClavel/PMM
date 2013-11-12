package aguerre.cristian.pcarrera;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiView(this));
    }


    public class MiView extends View Thread{

        public MiView(Context contexto){
            super(contexto);
        }

        protected void onDraw(Canvas canvas){
            Paint pincel = new Paint();
            pincel.setColor(Color.RED);
            pincel.setStrokeWidth(5);
            canvas.drawCircle(150,150,10,pincel);
            pincel.setColor(Color.BLUE);
            canvas.drawCircle(450,150,10,pincel);
        }

        Circulo c1 = new Circulo(10);
        Circulo c2 = new Circulo(15);



    }


    public class Circulo extends Thread{

        int radio;
        int posX;

        Paint pincel = new Paint();

        public Circulo(int radio){
            this.radio = radio;

        }

        public void update(){
            posX += 20;
        }

        protected void onDraw(Canvas canvas){

            pincel.setColor(Color.RED);
            pincel.setStrokeWidth(5);
            canvas.drawCircle(posX,150,10,pincel);
        }

        public void run(){
            update();
        }

    }

    public class Hilo extends Thread{
        public void run(){
            Circulo.update();
        }
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
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
