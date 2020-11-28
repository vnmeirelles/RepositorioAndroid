package com.example.viniciusmeirelles.lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtTexto;
    ArrayList <String> nomes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTexto = findViewById(R.id.edtTexto);
        ListView lista = findViewById(R.id.Lista);

        if(savedInstanceState != null){
            nomes = savedInstanceState.getStringArrayList("nomesTeste");
        }else {
            nomes = new ArrayList<String>();
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nomes);
        lista.setAdapter(adapter);
    }

    public void botao (View v){
        nomes.add(edtTexto.getText().toString());
        adapter.notifyDataSetChanged();
        edtTexto.setText("");
    }

    @Override
    protected void onSaveInstanceState(Bundle status){
        super.onSaveInstanceState(status);

        status.putStringArrayList("nomesTeste", nomes);
    }
}
