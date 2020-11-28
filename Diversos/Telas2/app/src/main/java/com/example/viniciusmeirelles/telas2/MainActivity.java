package com.example.viniciusmeirelles.telas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtIdade,edtRA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNomeT1);
        edtIdade = findViewById(R.id.edtIdadeT1);
        edtRA = findViewById(R.id.edtRAT1);
    }

        public void ChamaT2(View v){
        Aluno aluno = new Aluno();

        aluno.setNome(edtNome.getText().toString());
        aluno.setRA(edtRA.getText().toString());
        aluno.setIdade(Integer.parseInt(edtIdade.getText().toString()));

        Intent it = new Intent(this, Main2Activity.class);
        it.putExtra("alunoT2",aluno);
        startActivity(it);


    }
}
