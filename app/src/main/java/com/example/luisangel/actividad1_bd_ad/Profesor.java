package com.example.luisangel.actividad1_bd_ad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Profesor extends AppCompatActivity {

    private EditText nombre;
    private EditText edad;
    private EditText ciclo;
    private EditText curso;
    private EditText despacho;
    private EditText idborrar;

    private String nombre1;
    private String edad1;
    private String ciclo1;
    private String curso1;
    private String despacho1;
    private String idborrar1;

    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);

        nombre = (EditText)findViewById(R.id.editNombre);
        edad = (EditText)findViewById(R.id.editEdad);
        ciclo = (EditText)findViewById(R.id.editCiclo);
        curso = (EditText) findViewById(R.id.editCurso);
        despacho = (EditText) findViewById(R.id.editDespacho);
        idborrar = (EditText) findViewById(R.id.editTextBorrarP);

        nombre1 = nombre.getText().toString();
        edad1 = edad.getText().toString();
        ciclo1 = ciclo.getText().toString();
        curso1 = curso.getText().toString();
        despacho1 = despacho.getText().toString();
        idborrar1 = idborrar.getText().toString();



        Button guardarP = (Button) findViewById(R.id.buttonGuardar);
        Button borrar = (Button) findViewById(R.id.buttonBorrarP);

        dbAdapter = new MyDBAdapter(this);


        guardarP.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                dbAdapter.open();
                dbAdapter.insertarProfesor(nombre1, edad1, ciclo1, curso1, despacho1);
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                dbAdapter.open();
                dbAdapter.borrarAlumno("_id="+idborrar1);

            }
        });
    }
}
