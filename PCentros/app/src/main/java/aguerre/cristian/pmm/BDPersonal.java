package aguerre.cristian.pmm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Cristian Aguerre Clavel on 17/02/14.
 */
public class BDPersonal extends SQLiteOpenHelper {

    public static final String TABLA_PERSONAL = "CREATE TABLE personal ("+
                                               " cod_centro   SMALLINT NOT NULL,"+
                                               "dni INT UNSIGNED NOT NULL,"+
                                               " apellidos    VARCHAR(30),"+
                                               " funcion      VARCHAR(15),"+
                                               " salario      FLOAT(7,2),"+
                                                "PRIMARY KEY (dni),"+
                                                "FOREIGN KEY (cod_centro) REFERENCES centros (cod_centro));";


    public static final String NOMBRE_BASEDATOS = "personal";
    public static final int VERSION_BASEDATOS = 1;
    public SQLiteDatabase miTabla;
    public BDPersonal(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_PERSONAL);//CREAR BASE DE DATOS
        //miTabla = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_PERSONAL);
        onCreate(sqLiteDatabase);
    }

    public void insertDefault(){
        miTabla = getWritableDatabase();
        miTabla.execSQL("INSERT INTO personal VALUES (10,4480099, 'Ruano Cerezo, Manuel','ADMINISTRATIVO', 1800.00)" );
        miTabla.execSQL("INSERT INTO personal VALUES (15,1002345, 'Albarrán Serrano, Alicia', 'ADMINISTRATIVO', 1800.00)");
        miTabla.execSQL("INSERT INTO personal VALUES (15,7002660, 'Munyoz Rey, Felicia', 'ADMINISTRATIVO', 1800.00)");
        miTabla.execSQL("INSERT INTO personal VALUES (22,5502678, 'Marín Marn, Pedro', 'ADMINISTRATIVO', 1800.00)");
        miTabla.execSQL("INSERT INTO personal VALUES (22,6600980, 'Peinado Gil, Elena','CONSERJE', 1750.00)");
        miTabla.execSQL("INSERT INTO personal VALUES (45,4163222, 'Sarro Molina, Carmen','CONSERJE', 1750.00);");
        miTabla.execSQL("INSERT INTO personal VALUES (10,1112345,'Martnez Salas, Fernando',  'PROFESOR',2200.00);");
        miTabla.execSQL("INSERT INTO personal VALUES (10,4123005,'Bueno Zarco, Elisa', 'PROFESOR',2200.00);");
        miTabla.execSQL("INSERT INTO personal VALUES (10,4122025,'Montes Garca, M.Pilar', 'PROFESOR',2200.00);");
        miTabla.execSQL("INSERT INTO personal VALUES (15,9800990, 'Ramos Ruiz, Luis','PROFESOR',2050.00);");
        miTabla.execSQL("INSERT INTO personal VALUES (15,1112355,'Rivera Silvestre, Ana', 'PROFESOR',2050.00);");
        miTabla.execSQL("INSERT INTO personal VALUES (15,8660990, 'De Lucas Fdez, M.Angel',  'PROFESOR',2050.00);");
        miTabla.execSQL("INSERT INTO personal VALUES (22,7650000, 'Ruiz Lafuente, Manuel',  'PROFESOR',2200.00);\n");
        miTabla.execSQL("INSERT INTO personal VALUES (45,43526789, 'Serrano Lagua, María','PROFESOR',2050.00);");
        miTabla.close();
    }

    public  void insertarPersona(int cod_centro,int dni, String apellidos,String funcion,double salaraio){
        miTabla = getWritableDatabase();
        if (miTabla != null){
            ContentValues valores = new ContentValues();
            valores.put("cod_centro",cod_centro);
            valores.put("dni", dni);
            valores.put("apellidos",apellidos);
            valores.put("funcion", funcion);
            valores.put("salario", salaraio);

            miTabla.insert("personal",null,valores);
            miTabla.close();
        }
    }


    public void borrarPersona(int dni){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("personal","dni="+String.valueOf(dni),null);
    }

    public Personal recuperarPersona(int dni){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String[] valores_recuperar = {"cod_centro","dni","apellidos","funcion","salario"};
        Cursor cursor = sqLiteDatabase.query("personal",valores_recuperar,"dni="+dni,null,null,null,null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        Personal personal = new Personal(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getDouble(4));
        sqLiteDatabase.close();
        cursor.close();
        return  personal;
    }

    public ArrayList<Personal> recuperarPersonal(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        SQLiteDatabase sq = getWritableDatabase();
        ArrayList<Personal> lista_personal = new ArrayList<Personal>();
        String[] valores_recuperar = {"cod_centro","dni","apellidos","funcion","salario"};
        Cursor cursor = sqLiteDatabase.query("personal",valores_recuperar,null,null,null,null,null,null);
        cursor.moveToFirst();
        do {
            Personal personal = new Personal(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getDouble(4));
            lista_personal.add(personal);
        }while (cursor.moveToNext());
        sqLiteDatabase.close();
        cursor.close();
        return lista_personal;
    }


}


