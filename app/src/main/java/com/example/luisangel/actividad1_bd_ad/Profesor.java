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
    private int edad1;
    private String ciclo1;
    private int curso1;
    private String despacho1;
    private String idborrar1;

    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);

        Button guardarP = (Button) findViewById(R.id.buttonGuardar);
        Button borrar = (Button) findViewById(R.id.buttonBorrarP);

        dbAdapter = new MyDBAdapter(this);


        guardarP.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                dbAdapter.open();
                nombre = (EditText)findViewById(R.id.editNombre);
                nombre1 = nombre.getText().toString();
                edad = (EditText)findViewById(R.id.editEdad);
                edad1 = Integer.parseInt(edad.getText().toString());
                ciclo = (EditText)findViewById(R.id.editCiclo);
                ciclo1 = ciclo.getText().toString();
                curso = (EditText) findViewById(R.id.editCurso);
                curso1 = Integer.parseInt(curso.getText().toString());
                despacho = (EditText) findViewById(R.id.editDespacho);
                despacho1 = despacho.getText().toString();

                dbAdapter.insertarProfesor(nombre1,edad1,ciclo1,curso1,despacho1);
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                idborrar = (EditText) findViewById(R.id.editTextBorrarP);
                idborrar1 = idborrar.getText().toString();

                dbAdapter.open();
                dbAdapter.borrarProfesor("_id="+idborrar1);

            }
        });
    }
}
