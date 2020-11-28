package com.example.viniciusmeirelles.telas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView txtNome;
        TextView txtIdade;
        TextView txtRA;
        TextView txtFaculdade;
        TextView txtCurso;

        txtNome = findViewById(R.id.txtNomeT3);
        txtIdade = findViewById(R.id.txtIdadeT3);
        txtRA = findViewById(R.id.txtRaT3);
        txtFaculdade = findViewById(R.id.txtFaculdadeT3);
        txtCurso = findViewById(R.id.txtCursoT3);

        Intent it4 = getIntent();

        Aluno alunoT3 = (Aluno) it4.getSerializableExtra("AlunoT3");
        Faculdade faculT3 = (Faculdade) it4.getSerializableExtra("FaculdadeT3");

        txtNome.setText("Nome: " + alunoT3.getNome());
        txtRA.setText("RA: " + alunoT3.getRA());
        txtIdade.setText("Idade: " + alunoT3.getIdade());

        txtFaculdade.setText("Faculdade: " + faculT3.getNome());
        txtCurso.setText("Curso: " + faculT3.getCurso());

    }

}
