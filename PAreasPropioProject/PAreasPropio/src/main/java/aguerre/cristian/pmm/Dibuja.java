package aguerre.cristian.pmm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Cristian Aguerre Clavel on 8/12/13.
 */
public class Dibuja extends View {

    public Dibuja(Context contexto){
        super(contexto);
    }

    public void onDraw(Canvas canvas){
        //Los metodos a pintar
        Paint pincel = new Paint();
        confPincel(pincel,Color.BLACK,10);
        dibujarFigura(10,pincel,canvas,1);


    }

    public void confPincel(Paint pincel, int color, int grosor){
        pincel.setColor(color);
        pincel.setStrokeWidth(grosor);
        pincel.setStyle(Paint.Style.STROKE);
    }

    public void dibujarFigura(int area,Paint pincel, Canvas canvas, int figura){
        //TODO contruccion de figura apartir de llos parametros
        canvas.drawCircle(150,150,80,pincel);

        area = reducirArea(area);

        if (figura == 1){
            canvas.drawCircle(150,150,area,pincel);
        }
        if (figura == 2){
            canvas.drawRect(new Rect(10,10,10,10),pincel);//todo

        }

    }

    public int reducirArea(int area){
        while(area > 100){
            area = area/2;
        }
        return area;
    }


}
