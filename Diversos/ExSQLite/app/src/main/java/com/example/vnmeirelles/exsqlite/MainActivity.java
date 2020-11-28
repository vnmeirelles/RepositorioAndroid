package com.example.vnmeirelles.exsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vnmeirelles.exsqlite.DAO.DAOLivro;
import com.example.vnmeirelles.exsqlite.entidade.Livro;

public class MainActivity extends AppCompatActivity {

    EditText edtTitulo, edtAutor, edtEditora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTitulo = findViewById(R.id.edtTituloT1);
        edtAutor = findViewById(R.id.edtAutorT1);
        edtEditora = findViewById(R.id.edtEditoraT1);

    }

        public void SalvarLivro (View v){

            Livro livro = new Livro();
            livro.setAutor(edtAutor.getText().toString());
            livro.setEditora(edtEditora.getText().toString());
            livro.setTitulo(edtTitulo.getText().toString());

            DAOLivro daoLivro = new DAOLivro(this);

            String resultado;

            resultado = daoLivro.InsereLivro(livro);
            Toast.makeText(this, resultado,Toast.LENGTH_LONG).show();

        }

        public void ListarLivros (View v){
            Intent it = new Intent(this, Main2Activity.class);
            startActivity(it);
        }
    }

