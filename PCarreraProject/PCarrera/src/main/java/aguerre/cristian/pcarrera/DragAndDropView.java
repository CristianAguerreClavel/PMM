package aguerre.cristian.pcarrera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DragAndDropView extends SurfaceView implements SurfaceHolder.Callback {
    DragAndDropThread thread;

    public DragAndDropView(Context context) {
        super(context);
        getHolder().addCallback(this);//añadir en el constructor la línea getHolder().addCallback(this) para que se use esta clase como el manejador.

    }

    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
    }


    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
        thread = new DragAndDropThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();


    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) { }
        }
    }

}

