package com.example.vnmeirelles.exsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.example.vnmeirelles.exsqlite.DAO.CriaBanco;

import com.example.vnmeirelles.exsqlite.DAO.CriaBanco;
import com.example.vnmeirelles.exsqlite.DAO.DAOLivro;

public class Main2Activity extends AppCompatActivity {

    private CursorAdapter apaptador;
    private Cursor livros;
    private ListView lstLivros;
    private DAOLivro daoLivro;
    private static final String CAMPOS[]={"titulo", "autor", "editora", "_id"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        daoLivro = new DAOLivro(this);
        lstLivros = findViewById(R.id.lstLivrosT2);
        livros = daoLivro.ListarLivros();

        if(livros.getCount() > 0){
            apaptador = new SimpleCursorAdapter(this,
                                                R.layout.activity_main2,
                                                livros,
                                                CAMPOS,
                                                new int[]{R.id.txtTituloT2,
                                                          R.id.txtAutorT2,
                                                          R.id.txtEditoraT2}, 1);
            lstLivros.setAdapter(apaptador);

            lstLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String cod;
                    livros.moveToPosition(position);
                    cod = livros.getString(livros.getColumnIndexOrThrow("_id"));
                    Intent it = new Intent(getApplicationContext(), Main3Activity.class);
                    it.putExtra("cod", cod);
                    startActivity(it);
                    finish();
                }
            });

        }else {
        Toast.makeText(this, "Nenhum Registro Encontado",Toast.LENGTH_LONG).show();
        }
    }
}
