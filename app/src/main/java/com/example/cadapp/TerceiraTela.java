package com.example.cadapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class TerceiraTela extends AppCompatActivity {

    private static final String TAG = "TerceiraTela";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceiro_content);

        Log.i(TAG, "onCreate");
    }
}
