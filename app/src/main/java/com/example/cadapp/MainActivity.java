package com.example.cadapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button bt;
    private EditText campo1;
    private EditText campo2;
    private EditText campo3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Define a activity que será chamada no Create
        setContentView(R.layout.content_main);
        //Chama o método para criar instâncias dos controles da tela
        criarObjetos();

        Log.d(TAG , "Activity executada");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.MSobre) {
            Intent intent = new Intent(this, TerceiraTela.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String resultado = data.getStringExtra("resultado");
                Toast.makeText(getApplicationContext(), "Dados salvos com sucesso!", Toast.LENGTH_SHORT).show();
                campo1.setText("");
                campo2.setText("");
                campo3.setText("");


                Log.e(TAG, "Resultado");

            }
        }
    }

    public void criarObjetos(){
        bt = (Button)findViewById(R.id.btSalvar);
        campo1 = (EditText)findViewById(R.id.campo1);
        campo2 = (EditText)findViewById(R.id. campo2);
        campo3 = (EditText)findViewById(R.id.campo3);

        //Criar um listener para escutar o evento de click no botão
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cria um bundle para passar os dados para a outra Activity
                Bundle b = new Bundle();
                b.putString("nome", campo1.getText().toString());
                Integer idade = Integer.parseInt(campo2.getText().toString());
                b.putInt("idade", idade);
                b.putString("endereco", campo3.getText().toString());

                //Cria uma intent para abrir a outra Activity
                Intent segundaTela = new Intent(getApplicationContext(), SegundaTela.class);
                //adiciona os dados na instância criada
                segundaTela.putExtras(b);
                startActivityForResult(segundaTela, 1);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}
