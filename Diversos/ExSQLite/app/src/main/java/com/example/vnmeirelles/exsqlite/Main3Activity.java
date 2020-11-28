package com.example.vnmeirelles.exsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.vnmeirelles.exsqlite.DAO.CriaBanco;
import com.example.vnmeirelles.exsqlite.DAO.DAOLivro;
import com.example.vnmeirelles.exsqlite.entidade.Livro;

public class Main3Activity extends AppCompatActivity {

    EditText edtId, edtEditora, edtAutor, edtTitulo;
    Cursor livro;
    DAOLivro daoLivro;
    String cod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cod = this.getIntent().getStringExtra("cod");

        edtAutor = findViewById(R.id.edtAutorT3);
        edtEditora = findViewById(R.id.edtEditoraT3);
        edtTitulo = findViewById(R.id.edtTituloT3);
        edtId = findViewById(R.id.edtIdT3);

        edtId.setEnabled(false);
        daoLivro = new DAOLivro(this);

        livro = daoLivro.BuscaPorId(Integer.parseInt(cod));
        edtId.setText(livro.getString(livro.getColumnIndexOrThrow(CriaBanco.ID)));
        edtTitulo.setText(livro.getString(livro.getColumnIndexOrThrow(CriaBanco.TITULO)));
        edtAutor.setText(livro.getString(livro.getColumnIndexOrThrow(CriaBanco.AUTOR)));
        edtEditora.setText(livro.getString(livro.getColumnIndexOrThrow(CriaBanco.EDITORA)));
    }
    public void Alterar(View v){
        Livro livroAlt = new Livro();
        livroAlt.setId(Integer.parseInt(edtId.getText().toString()));
        livroAlt.setTitulo(edtTitulo.getText().toString());
        livroAlt.setAutor(edtAutor.getText().toString());
        livroAlt.setEditora(edtEditora.getText().toString());

        daoLivro.AlterarRegistro(livroAlt);
        Intent it =  new Intent(this, Main2Activity.class);
        startActivity(it);
    }

    public void DeletarAlt(View v){
        daoLivro.DeletarRegistro(Integer.parseInt(edtId.getText().toString()));
        Intent it =  new Intent(this, Main2Activity.class);
        startActivity(it);
    }
}
