package com.example.luisangel.actividad1_bd_ad;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Alumno extends AppCompatActivity {

    private EditText nombre;
    private EditText edad;
    private EditText ciclo;
    private EditText curso;
    private EditText nota;
    private EditText idborrar;

    private String nombre1;
    private int edad1;
    private String ciclo1;
    private int curso1;
    private int nota1;
    private String idborrar1;

    private MyDBAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        Button guardar = (Button) findViewById(R.id.buttonGuardarA);
        Button borrar = (Button) findViewById(R.id.buttonBorrarA);

        dbAdapter = new MyDBAdapter(this);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                nombre = (EditText)findViewById(R.id.editNombreA);
                nombre1 = nombre.getText().toString();
                edad = (EditText)findViewById(R.id.editEdadA);
                edad1=Integer.parseInt(edad.getText().toString());
                ciclo = (EditText)findViewById(R.id.editCicloA);
                ciclo1 = ciclo.getText().toString();
                curso = (EditText) findViewById(R.id.editCursoA);
                curso1 = Integer.parseInt(curso.getText().toString());
                nota = (EditText) findViewById(R.id.editNotaA);
                nota1 = Integer.parseInt(nota.getText().toString());

                dbAdapter.open();
                dbAdapter.insertarAlumno(nombre1,edad1,ciclo1,curso1,nota1);
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                idborrar = (EditText) findViewById(R.id.editTextBorrarA);
                idborrar1 = idborrar.getText().toString();

                dbAdapter.open();
                dbAdapter.borrarAlumno("_id="+idborrar1);

            }
        });


    }

}
