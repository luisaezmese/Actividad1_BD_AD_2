package com.example.luisangel.actividad1_bd_ad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Alumno extends AppCompatActivity {

    private EditText nombre;
    private EditText edad;
    private EditText ciclo;
    private EditText curso;
    private EditText nota;

    private String nombre1;
    private String edad1;
    private String ciclo1;
    private String curso1;
    private String nota1;


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


        nombre1 = nombre.getText().toString();
        edad1 = edad.getText().toString();
        ciclo1 = ciclo.getText().toString();
        curso1 = curso.getText().toString();
        nota1 = nota.getText().toString();



        Button guardar = (Button) findViewById(R.id.buttonGuardarA);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                dbAdapter.insertarAlumno(nombre1, edad1, ciclo1, curso1, nota1);
            }
        });


    }
}
