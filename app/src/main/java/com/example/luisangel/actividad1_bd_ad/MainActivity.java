package com.example.luisangel.actividad1_bd_ad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button alumno;
    Button profesor;
    Button buscar;
    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alumno = (Button)findViewById(R.id.button_Alumno);
        profesor = (Button)findViewById(R.id.button_Profesor);
        buscar = (Button)findViewById(R.id.buttonBuscar);

        alumno.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent alumno = new Intent (MainActivity.this, Alumno.class);
                startActivity(alumno);
            }
        });

        profesor.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent profesor = new Intent (MainActivity.this, Profesor.class);
                startActivity(profesor);
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent buscar = new Intent (MainActivity.this, Buscar.class);
                startActivity(buscar);
            }
        });


    }
}
