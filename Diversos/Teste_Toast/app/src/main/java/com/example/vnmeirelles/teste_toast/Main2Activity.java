package com.example.vnmeirelles.teste_toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

import java.io.Serializable;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent it = getIntent();
        TextView txt = (TextView) findViewById(R.id.txtTextoT2);
        Cliente cli = it.getParcelableExtra("cliente");
        Fornecedor forn =  (Fornecedor) it.getSerializableExtra("fornecedor");

        if(cli != null) {
            String strTmp = String.format("Nome: %s / Código: %d", cli.nome, cli.codigo);
            txt.setText(strTmp);
        } else if (forn != null){
            String strTmp = String.format("Nome: %s / Fundação: %d", forn.nome, forn.fundacao);
            txt.setText(strTmp);
        } else{
            String nome = it.getStringExtra("Nome");
            String sobrenome = it.getStringExtra("Sobrenome");
            String idade = it.getStringExtra("Idade");
            txt.setText(String.format("Nome: %s  Sobrenome: %s Idade: %s",nome, sobrenome, idade));
        }
    }
}
