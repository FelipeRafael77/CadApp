package com.example.cadapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaTela extends AppCompatActivity {

    private static final String TAG = "SegundaTela";

    private TextView tNome;
    private TextView tIdade;
    private TextView tEndereco;
    private Button btSim;
    private Button btNao;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.segundo_content);
        criarObjetos();
        popularDados();

        Log.d(TAG, "Activity criada");
    }

    private void criarObjetos()
    {
        tNome = (TextView)findViewById(R.id.tNome);
        tIdade = (TextView)findViewById(R.id.tIdade);
        tEndereco = (TextView)findViewById(R.id.tEndereco);
        btSim = (Button)findViewById(R.id.btSim);
        btNao = (Button)findViewById(R.id.btNao);
    }

    private void popularDados(){
        //Preenche uma instância de um Bundle com os dados que foram passados
        Bundle b = getIntent().getExtras();
        //Lê os dados do Bundle passando os dados para os componentes da Activity
        tNome.setText(tNome.getText() + " " + b.getString("nome"));
        Integer idade = b.getInt("idade");
        tIdade.setText(tIdade.getText() + " " + idade.toString());
        tEndereco.setText(tEndereco.getText() + " " + b.getString("endereco"));

        btSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                setResult(Activity.RESULT_OK, it);
                finish();

            }
        });

        btNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                setResult(Activity.RESULT_CANCELED, it);
                finish();

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

