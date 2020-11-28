package com.example.viniciusmeirelles.aula_telas;

import android.content.Intent;
import android.service.autofill.FillEventHistory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt01, edt02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt01 = findViewById(R.id.edtTexto01);
        edt02 = findViewById(R.id.edtTexto02);

    }

    public void ExibirTela2(View v){

        String nome = edt01.getText().toString();
        int idade = Integer.parseInt(edt02.getText().toString());

        Intent main2 = new Intent(this, Main2Activity.class);

        main2.putExtra("nomeExemplo", nome);
        main2.putExtra("idadeExemplo",idade);

        startActivity(main2);
    }

    public void ExibirTela3(View v){
        Pessoa p = new Pessoa();
        p.setNome(edt01.getText().toString());
        p.setIdade(Integer.parseInt(edt02.getText().toString()));

        Intent it = new Intent(this, Main3Activity.class);
        it.putExtra("pessoa",p);
        startActivity(it);

    }
}
