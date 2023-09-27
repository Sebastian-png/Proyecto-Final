package edu.co.park_fast;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registro_usuario extends AppCompatActivity {

    EditText edtxt_nombres,edtxt_apellidos,edtxt_cedula,edtxt_edad,edtxt_correo,edtxt_contra1;
    Button btn_registrarse2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        edtxt_nombres = findViewById(R.id.edtxt_nombres);
        edtxt_apellidos = findViewById(R.id.edtxt_apellidos);
        edtxt_cedula = findViewById(R.id.edtxt_cedula);
        edtxt_edad = findViewById(R.id.edtxt_edad);
        edtxt_correo = findViewById(R.id.edtxt_correo);
        edtxt_contra1 = findViewById(R.id.edtxt_contra1);


        btn_registrarse2 = findViewById(R.id.btn_registrarse2);
        btn_registrarse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
    }

    private void registrar() {
        String nombre=edtxt_nombres.getText().toString().trim();
        String apellido=edtxt_apellidos.getText().toString().trim();
        String cedula=edtxt_cedula.getText().toString().trim();
        String edad=edtxt_edad.getText().toString().trim();
        String correo=edtxt_correo.getText().toString().trim();
        String contra1=edtxt_contra1.getText().toString().trim();


        ProgressDialog progressDialog=new ProgressDialog(this);
        if (nombre.isEmpty()){
            edtxt_nombres.setError("Complete los campos");
        } else if (apellido.isEmpty()){
            edtxt_apellidos.setError("Complete los campos");
        } else if (cedula.isEmpty()){
            edtxt_cedula.setError("Complete los campos");
        } else if (edad.isEmpty()){
            edtxt_edad.setError("Complete los campos");
        } else if (correo.isEmpty()){
            edtxt_correo.setError("Complete los campos");
        } else if (contra1.isEmpty()){
            edtxt_contra1.setError("Complete los campos");

        } else {
            progressDialog.show();
            StringRequest request= new StringRequest(Request.Method.POST, "http://192.168.0.8/users", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Datos insertados")) {
                        Toast.makeText(registro_usuario.this, "Datos ingresados", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    } else {
                        Toast.makeText(registro_usuario.this, response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(registro_usuario.this,error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String>params=new HashMap<String, String>();

                    params.put("usu_nombre",nombre);
                    params.put("usu_apellido",apellido);
                    params.put("usu_edad",edad);
                    params.put("usu_cedula",cedula);
                    params.put("usu_mail",correo);
                    params.put("usu_password",contra1);
                    return params;
                }
            };
            RequestQueue requestQueue= Volley.newRequestQueue(registro_usuario.this);
            requestQueue.add(request);
        }
    }
}