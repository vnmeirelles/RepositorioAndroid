package com.example.viniciusmeirelles.telas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    Aluno aluno;
    EditText edtFaculdade, edtCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent it2 = getIntent();

        aluno = (Aluno) it2.getSerializableExtra("alunoT2");
        it2.putExtra("alunoT3",aluno);

        edtCurso = findViewById(R.id.edtCursoT2);
        edtFaculdade = findViewById(R.id.edtNomeT2);
    }

    public void ChamaT3(View v){
        Faculdade facul = new Faculdade();
        facul.setCurso(edtFaculdade.getText().toString());
        facul.setNome(edtFaculdade.getText().toString());

        Intent it3 = new Intent(this, Main3Activity.class);
        it3.putExtra("AlunoT3", aluno);
        it3.putExtra("FaculdadeT3", facul);
        startActivity(it3);

    }

}
