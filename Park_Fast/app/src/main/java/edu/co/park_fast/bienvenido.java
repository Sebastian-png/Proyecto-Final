package edu.co.park_fast;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class bienvenido extends AppCompatActivity {

    Button btnReservar;
    Button btnRegistrar;
    Button btnpago;
    Button btnInfo;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
        btnpago=(Button)findViewById(R.id.btn_pagar);
        btnRegistrar=(Button)findViewById(R.id.btn_registrarseA);
        btnReservar=(Button)findViewById(R.id.btn_reservar);
        btnInfo=(Button)findViewById(R.id.btn_informacion);


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(bienvenido.this, info_parqueadero.class);
                startActivity(i);
            }
        });
        btnpago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(bienvenido.this, pagos.class);
                startActivity(i);
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(bienvenido.this, registro_automovil.class);
                startActivity((i));
            }
        });
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(bienvenido.this, reservas.class);
                startActivity(i);
            }
        });
    }
}
