package com.example.luisangel.actividad1_bd_ad;

import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;



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


    private static final String DATABASE_CREATE_A = "CREATE TABLE "+DATABASE_TABLE_A+" (_id integer primary key autoincrement, nombre text, edad text, ciclo text, curso text, nota text);";
    private static final String DATABASE_DROP_A = "DROP TABLE IF EXISTS "+DATABASE_TABLE_A+";";
    private static final String DATABASE_CREATE_P = "CREATE TABLE "+DATABASE_TABLE_P+" (_id integer primary key autoincrement, nombre text, edad text, ciclo text, curso text, despacho text);";
    private static final String DATABASE_DROP_P = "DROP TABLE IF EXISTS "+DATABASE_TABLE_P+";";

    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelperA dbHelperA;
    private MyDbHelperP dbHelperP;
    // Instancia de la base de datos
    private SQLiteDatabase dbA;
    private SQLiteDatabase dbP;

    public MyDBAdapter (Context c){
        context = c;
        dbHelperA = new MyDbHelperA(context, DATABASE_NAME, null, DATABASE_VERSION);
        dbHelperP = new MyDbHelperP(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open(){

        try{
            dbA = dbHelperA.getWritableDatabase();
            dbP = dbHelperP.getWritableDatabase();
        }catch(SQLiteException e){
            dbA = dbHelperA.getReadableDatabase();
            dbP = dbHelperP.getReadableDatabase();
        }

    }

    public void insertarAlumno(String a, String b, String c, String d, String e){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBRE,a);
        newValues.put(EDAD,b);
        newValues.put(CICLO,c);
        newValues.put(CURSO,d);
        newValues.put(NOTA,e);
        dbA.insert(DATABASE_TABLE_A,null,newValues);
    }

    public void borrarAlumno(String b){
        dbA.delete("alumnos", b, null);

    }

    public void insertarProfesor(String a, String b, String c, String d, String e){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBRE,a);
        newValues.put(EDAD,b);
        newValues.put(CICLO,c);
        newValues.put(CURSO,d);
        newValues.put(DESPACHO,e);
        dbP.insert(DATABASE_TABLE_P,null,newValues);
    }

    public void borrarProfesor(String b) {
        dbA.delete("profesores", b, null);
    }


    private static class MyDbHelperA extends SQLiteOpenHelper {

            public MyDbHelperA (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
                super(context,name,factory,version);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL(DATABASE_CREATE_A);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL(DATABASE_DROP_A);
                onCreate(db);
            }

    }

    private static class MyDbHelperP extends SQLiteOpenHelper {

        public MyDbHelperP (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_P);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP_P);
            onCreate(db);
        }

    }
}