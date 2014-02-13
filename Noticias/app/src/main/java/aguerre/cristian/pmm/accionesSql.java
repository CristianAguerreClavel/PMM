package aguerre.cristian.pmm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian Aguerre Clavel on 1/02/14.
 */
public class accionesSql extends SQLiteOpenHelper {

    private static final String NOMBRE_BASEDATOS = "noticias.db";
    private static final int VERSION_BASEDATOS = 1;

    private static final String TABLA_NOTICIAS = "CREATE TABLE IF NOT EXISTS noticias" +
            "(_id INT PRIMARY KEY, noticia TEXT)";

    public accionesSql(Context context){
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_NOTICIAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_NOTICIAS);
        onCreate(db);
    }

    public void insertarNoticia(String noticia) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();

            valores.put("noticia", noticia);//Inserta en la columna noticia el valor noticia

            db.insert("noticias", null, valores);
            db.close();
        }
    }

    public List<Noticia> recuperarNOTICIAS() {
        SQLiteDatabase db = getReadableDatabase();
        List<Noticia> lista_noticias = new ArrayList<Noticia>();
        String[] valores_recuperar = {"noticia"};
        Cursor c = db.query("noticias", valores_recuperar,
                null, null, null, null, null, null);
        c.moveToFirst();
        do {
            Noticia noticia = new Noticia(c.getString(0));
            lista_noticias.add(noticia);
        } while (c.moveToNext());
        db.close();
        c.close();
        return lista_noticias;
    }

}
