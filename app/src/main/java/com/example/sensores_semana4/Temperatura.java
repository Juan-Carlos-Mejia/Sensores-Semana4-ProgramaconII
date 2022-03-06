package com.example.sensores_semana4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Temperatura extends AppCompatActivity implements SensorEventListener {

   private TextView mTemperatura;
    private Sensor tempSensor;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_temperatura);
        Button regresar = (Button) findViewById(R.id.btnRegre);

        //ejecutar boton
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent Ant = new Intent(Temperatura. this, MainActivity.class);
                startActivity(Ant);
            }
        });

        mTemperatura=findViewById(R.id.temperatura);
        TextView fallo = findViewById(R.id.fallo);
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //¿existe sensor en el dispositivo?

        boolean sensorTempDisponible;
        if(sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) !=null){
            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            sensorTempDisponible = true;
            fallo.setVisibility(View.GONE);
        }else{
            fallo.setText("Su dispositivo no cuenta con un sensor de temperatura");
            mTemperatura.setVisibility(View.GONE);
            sensorTempDisponible = false;
        }

        if(sensorTempDisponible){
            sensorManager.registerListener(this,tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        int temperatura = (int) event.values[0];
        mTemperatura.setText(temperatura +" ºC");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}