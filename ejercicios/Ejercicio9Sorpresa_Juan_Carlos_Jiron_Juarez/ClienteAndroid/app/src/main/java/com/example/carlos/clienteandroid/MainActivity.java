package com.example.carlos.clienteandroid;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    private Button btnEnviar;
    private EditText etPeticion;
    private EditText etResp;

    private static final int SERVER_PORT = 5000;
    private  static final String DIRECCION_SERVIDOR = "192.168.100.2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponets();
    }

    public void initComponets(){
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        etPeticion = (EditText) findViewById(R.id.etPeticion);
        etResp = (EditText) findViewById(R.id.etResp);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etPeticion.getText().toString().length() > 0){
                    TareaAsincronaCliente tac = new TareaAsincronaCliente();
                    tac.execute(etPeticion.getText().toString());
                    if(etPeticion.getText().toString().equals("salir")){
                        finish();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Acciones permitidas \"frase\" o \"libro\"", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    class TareaAsincronaCliente extends AsyncTask<String,Void,String>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setTitle("Conectando con el servidor");
            progressDialog.setMessage("Espere por favor");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            try {
                InetAddress direccionIpDelServidor = InetAddress.getByName(DIRECCION_SERVIDOR);
                Log.i("MENSAJE","Conectando...");
                Socket socket = new Socket(direccionIpDelServidor,SERVER_PORT);
                Log.i("MENSAJE","Conectado al servidor");
                Log.i("MENSAJE","Enviar datos al servidor");
                PrintStream ps = new PrintStream(socket.getOutputStream());
                String peticion = params[0];
                ps.println(peticion);

                //Recibe repuesta del servidor y formatea a String
                Log.i("MENSAJE", "Datos recibios en el servidor");
                InputStream is = socket.getInputStream();
                byte[] lenBytes = new byte[256];
                is.read(lenBytes,0,256);
                String recibido = new String(lenBytes, "UTF-8").trim();
                Log.i("MENSAJE","Recibido: "+ recibido);
                Log.i("MENSAJE","");
                socket.close();
                return recibido;
            } catch (IOException e) {
                Log.e("ERROR"," "+e.getMessage());
            }
            return null;
        }

        @Override
        protected void  onPostExecute(String value){
            progressDialog.dismiss();
            etResp.setText(value);
        }
    }
}
