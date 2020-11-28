package com.example.viniciusmeirelles.aula_telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText edt01 = findViewById(R.id.edt01T3);
        EditText edt02 = findViewById(R.id.edt02T3);

        Intent it = getIntent();

        Pessoa p = (Pessoa) it.getSerializableExtra("pessoa");
        edt01.setText("Nome: " + p.getNome());
        edt02.setText("Idade: " + p.getIdade());

    }
}
