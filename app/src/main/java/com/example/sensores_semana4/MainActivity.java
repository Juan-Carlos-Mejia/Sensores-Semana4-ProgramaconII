package com.example.sensores_semana4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Opcion1 = (Button) findViewById(R.id.btnOpcion1);
        Button Opcion2 = (Button) findViewById(R.id.btnOpcion2);
        Button Opcion3 = (Button) findViewById(R.id.btnOpcion3);

        //ejecutar boton
        Opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent Ant = new Intent(MainActivity. this, Acelerometro.class);
                startActivity(Ant);
            }
        });

        Opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent Ant = new Intent(MainActivity. this, SensorDeProximidad.class);
                startActivity(Ant);
            }
        });

        Opcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent Ant = new Intent(MainActivity. this, Temperatura.class);
                startActivity(Ant);
            }
        });
    }
}