package com.example.viniciusmeirelles.aula_telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView txt;
        txt = findViewById(R.id.txtTextoT2);

        Intent it2 = getIntent();
        String nome = it2.getStringExtra("nomeExemplo");
        int idade = it2.getIntExtra("idadeExemplo",-1);

        //maneira 1
        txt.setText(String.format("Nome: %s / Idade: %d", nome, idade));
        //maneira2
        //txt.setText("Nome: " + nome + "Idade: " + idade);

    }
}
