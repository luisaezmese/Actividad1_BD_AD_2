package com.example.luisangel.actividad1_bd_ad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.luisangel.actividad1_bd_ad.R.id.editTextCursoB;

public class Buscar extends AppCompatActivity {


    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    private MyDBAdapter dbAdapter;
    private CheckBox alumnos;
    private CheckBox profesores;
    private Button mostrar;
    private String alumnosmarca;
    private String profesoresmarca;
    private EditText ciclo;
    private EditText curso;
    private String ciclo1;
    private String curso1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        alumnos =(CheckBox)findViewById(R.id.checkBoxEstudiantes);
        profesores =(CheckBox)findViewById(R.id.checkBoxProfesores);
        mostrar = (Button)findViewById(R.id.buttonMostrar);



        final ListView lista = (ListView) findViewById(R.id.listview);
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();


        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                ciclo = (EditText)findViewById(R.id.editTextCicloB);
                ciclo1 = ciclo.getText().toString();
                if (TextUtils.isEmpty(ciclo1)){
                    ciclo1="vacio";
                }
                curso = (EditText) findViewById(R.id.editTextCursoB);
                curso1 = curso.getText().toString();
                if (TextUtils.isEmpty(curso1)){
                    curso1="vacio";
                }
                Toast.makeText(getApplicationContext(),curso1, Toast.LENGTH_SHORT).show();
                if (alumnos.isChecked()){
                    alumnosmarca="a";
                    profesoresmarca="b";
                    arrayList = dbAdapter.recuperar(alumnosmarca,profesoresmarca,ciclo1,curso1);
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
                }

                if (profesores.isChecked()){
                    alumnosmarca ="b";
                    profesoresmarca="a";
                    arrayList = dbAdapter.recuperar(alumnosmarca,profesoresmarca,ciclo1,curso1);
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
                    alumnosmarca="b";
                    profesoresmarca="b";
                }
                if (alumnos.isChecked() & profesores.isChecked()){
                    alumnosmarca="a";
                    profesoresmarca="a";
                    arrayList = dbAdapter.recuperar(alumnosmarca,profesoresmarca,ciclo1,curso1);
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
                    alumnosmarca="b";
                    profesoresmarca="b";
                }



                adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
                lista.setAdapter(adapter);
            }
        });


    }

}
