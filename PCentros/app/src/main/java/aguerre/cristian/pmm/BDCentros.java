package aguerre.cristian.pmm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Cristian Aguerre Clavel on 3/02/14.
 */
public class BDCentros extends SQLiteOpenHelper {

    public static final String TABLA_CENTROS = "CREATE TABLE centros (" +
            " cod_centro   SMALLINT NOT NULL," +
            " tipo_centro  CHAR(1)," +
            " nombre       VARCHAR(30)," +
            " direccion    VARCHAR(26)," +
            " telefono     VARCHAR(10)," +
            " num_plazas   SMALLINT  UNSIGNED," +
            "  PRIMARY KEY (cod_centro)" +
            " )";

    public static final String NOMBRE_BASEDATOS = "centros";
    public static final int VERSION_BASEDATOS = 1;
    public SQLiteDatabase miTabla;
    public BDCentros(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CENTROS);//CREAR BASE DE DATOS
        //miTabla = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_CENTROS);
        onCreate(sqLiteDatabase);
    }

   public void insertDefault(){
        miTabla = getWritableDatabase();
        miTabla.execSQL("INSERT INTO centros VALUES (10,'S','IES El Quijote','Avda. Los Molinos 25', '965-887654',538)");
        miTabla.execSQL("INSERT INTO centros VALUES (15,'P','CP Los Danzantes', 'C/Las Musas s/n','985-112322',250)");
        miTabla.execSQL("INSERT INTO centros VALUES (22,'S', 'IES Planeta Tierra', 'C/Mina 45','925-443400',300)");
        miTabla.execSQL("INSERT INTO centros VALUES (45,'P', 'CP Manuel Hidalgo', 'C/Granada 5','926-202310',2200)");
        miTabla.execSQL("INSERT INTO centros VALUES (50,'S', 'IES Antoñete 1', 'C/Los Toreros 21','989-406090',310)");
        miTabla.close();
    }

    public  void insertarCentro(int id, String tipoCentro, String nombre, String direccion, String telefono, int numPlazas){
        miTabla = getWritableDatabase();
        if (miTabla != null){
            ContentValues valores = new ContentValues();
            valores.put("cod_centro",id);
            valores.put("tipo_centro", tipoCentro);
            valores.put("nombre",nombre);
            valores.put("direccion", direccion);
            valores.put("telefono", telefono);
            valores.put("num_plazas",numPlazas);

            miTabla.insert("centros",null,valores);
            miTabla.close();
        }
    }

    //TODO modificar centro

    public void borrarCentro(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("centros","cod_centro="+String.valueOf(id),null);
    }

    public Centros recuperarCentro(int id){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String[] valores_recuperar = {"cod_centro","tipo_centro","nombre","direccion","telefono","num_plazas"};
        Cursor cursor = sqLiteDatabase.query("centros",valores_recuperar,"cod_centro="+id,null,null,null,null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        Centros centro = new Centros(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5));
        sqLiteDatabase.close();
        cursor.close();
        return  centro;
    }

    public ArrayList<Centros> recuperarCentros(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        SQLiteDatabase sq = getWritableDatabase();
        ArrayList<Centros> lista_centros = new ArrayList<Centros>();
        String[] valores_recuperar = {"cod_centro","tipo_centro","nombre","direccion","telefono","num_plazas"};
        Cursor cursor = sqLiteDatabase.query("centros",valores_recuperar,null,null,null,null,null,null);
        cursor.moveToFirst();
        do {
            Centros centro = new Centros(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5));
            lista_centros.add(centro);
        }while (cursor.moveToNext());
        sqLiteDatabase.close();
        cursor.close();
        return lista_centros;
    }


}
