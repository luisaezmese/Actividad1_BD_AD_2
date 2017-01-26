package com.example.luisangel.actividad1_bd_ad;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;


public class MyDBAdapter {

    // Definiciones y constantes
    private static final String DATABASE_NAME = "dbuniversidad.db";
    private static final String DATABASE_TABLE_A = "alumnos";
    private static final String DATABASE_TABLE_P = "profesores";
    private static final int DATABASE_VERSION = 1;

    private static final String NOMBRE = "nombre";
    private static final String EDAD = "edad";
    private static final String CICLO = "ciclo";
    private static final String CURSO = "curso";
    private static final String NOTA = "nota";
    private static final String DESPACHO = "despacho";

    private static final String DATABASE_CREATE_A = "CREATE TABLE "+DATABASE_TABLE_A+" (_id integer primary key autoincrement, nombre text, edad int, ciclo text, curso int, nota int);";
    private static final String DATABASE_DROP_A = "DROP TABLE IF EXISTS "+DATABASE_TABLE_A+";";
    private static final String DATABASE_CREATE_P = "CREATE TABLE "+DATABASE_TABLE_P+" (_id integer primary key autoincrement, nombre text, edad int, ciclo text, curso int, despacho text);";
    private static final String DATABASE_DROP_P = "DROP TABLE IF EXISTS "+DATABASE_TABLE_P+";";

    private Cursor cursora;
    private Cursor cursorp;

    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    private MyDBAdapter dbAdapter;




    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void open(){

        try{
            db = dbHelper.getWritableDatabase();

        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

    public ArrayList<String> recuperar(String alumnosmarca, String profesoresmarca, String ciclo, String curso){
        ArrayList<String> listado = new ArrayList<String>();

        if ((alumnosmarca=="a") & (ciclo =="vacio") & (curso == "vacio")) {
            //Recuperamos en un cursor la consulta realizada
            cursora = db.query(DATABASE_TABLE_A, null, null, null, null, null, null);
        }

        if ((profesoresmarca=="a") & (ciclo == "vacio") & (curso == "vacio")) {
            //Recuperamos en un cursor la consulta realizada
            cursorp = db.query(DATABASE_TABLE_P, null, null, null, null, null, null);
        }

        if (profesoresmarca=="a" & alumnosmarca=="a" & (ciclo == "vacio") & (curso == "vacio")) {
            //Recuperamos en un cursor la consulta realizada
            cursora = db.query(DATABASE_TABLE_A, null, null, null, null, null, null);
            cursorp = db.query(DATABASE_TABLE_P, null, null, null, null, null, null);
        }
        //Recorremos el cursor
        if (cursora != null && cursora.moveToFirst()){
            do{
                listado.add(cursora.getString(0)+" "+cursora.getString(1));
            }while (cursora.moveToNext());
        }
        if (cursorp != null && cursorp.moveToFirst()){
            do{
                listado.add(cursorp.getString(0)+" "+cursorp.getString(1));
            }while (cursorp.moveToNext());
        }
        return listado;
    }

    public void insertarAlumno(String a, int b, String c, int d, int e){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBRE,a);
        newValues.put(EDAD,b);
        newValues.put(CICLO,c);
        newValues.put(CURSO,d);
        newValues.put(NOTA,e);
        db.insert(DATABASE_TABLE_A,null,newValues);

    }

    public void borrarAlumno(String b){
        db.delete("alumnos", b, null);

    }

    public void insertarProfesor(String a, int b, String c, int d, String e){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBRE,a);
        newValues.put(EDAD,b);
        newValues.put(CICLO,c);
        newValues.put(CURSO,d);
        newValues.put(DESPACHO,e);
        db.insert(DATABASE_TABLE_P,null,newValues);

    }

    public void borrarProfesor(String b) {
        db.delete("profesores", b, null);
    }


    private static class MyDbHelper extends SQLiteOpenHelper {

            public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
                super(context,name,factory,version);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL(DATABASE_CREATE_A);
                db.execSQL(DATABASE_CREATE_P);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL(DATABASE_DROP_A);
                db.execSQL(DATABASE_DROP_P);
                onCreate(db);
            }

    }



}