package com.example.luisangel.actividad1_bd_ad;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Alumno extends AppCompatActivity {

    private EditText nombre;
    private EditText edad;
    private EditText ciclo;
    private EditText curso;
    private EditText nota;
    private EditText idborrar;

    private String nombre1;
    private String edad1;
    private String ciclo1;
    private String curso1;
    private String nota1;
    private String idborrar1;

    private MyDBAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        nombre = (EditText)findViewById(R.id.editNombreA);
        edad = (EditText)findViewById(R.id.editEdadA);
        ciclo = (EditText)findViewById(R.id.editCicloA);
        curso = (EditText) findViewById(R.id.editCursoA);
        nota = (EditText) findViewById(R.id.editNotaA);
        idborrar = (EditText) findViewById(R.id.editTextBorrarA);

        nombre1 = nombre.getText().toString();
        edad1 = edad.getText().toString();
        ciclo1 = ciclo.getText().toString();
        curso1 = curso.getText().toString();
        nota1 = nota.getText().toString();
        idborrar1 = idborrar.getText().toString();



        Button guardar = (Button) findViewById(R.id.buttonGuardarA);
        Button borrar = (Button) findViewById(R.id.buttonBorrarA);
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                dbAdapter.insertarAlumno(nombre1, edad1, ciclo1, curso1, nota1);
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                dbAdapter.borrarAlumno("_id="+idborrar1);

            }
        });



    }

}
