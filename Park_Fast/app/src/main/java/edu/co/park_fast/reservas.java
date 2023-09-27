package edu.co.park_fast;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class reservas extends AppCompatActivity {

    Button btn_reservar;
    Button btn_atras;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
        btn_reservar =(Button)findViewById(R.id.btn_reservar2);

        btn_reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Reserva Realizada Exitosamente", Toast.LENGTH_SHORT).show();
            }
        });

        btn_atras =(Button)findViewById(R.id.btn_volver3);

        btn_atras.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view) {

                 onBackPressed();
             }
         }
        );
    }
}