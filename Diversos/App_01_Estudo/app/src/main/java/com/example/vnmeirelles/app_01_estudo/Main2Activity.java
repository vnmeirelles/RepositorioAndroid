package com.example.vnmeirelles.app_01_estudo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent it = getIntent();
        TextView txt2 = (TextView) findViewById(R.id.textViewT2);

        String tmp = it.getStringExtra("nome");
        txt2.setText("teste " + tmp);

    }
}
