package com.example.vnmeirelles.app_02_estudo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    Button btn;
    ListView lst;
    ArrayList<String> nomes;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt = (EditText) findViewById(R.id.edtTextoT1);
        Button btn = (Button) findViewById(R.id.btnAcaoT1);
        ListView lst = (ListView) findViewById(R.id.lstT1);

        if(savedInstanceState != null) {
            nomes = savedInstanceState.getStringArrayList("nomes");
        } else {
            nomes = new ArrayList<String>();
        }

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nomes);
        lst.setAdapter(adaptador);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomes.add(edt.getText().toString());
                edt.setText("");
                adaptador.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("nomes", nomes);
    }
}
