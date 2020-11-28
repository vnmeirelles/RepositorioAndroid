package com.example.vnmeirelles.porondeestive;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.vnmeirelles.porondeestive.DAO.DAOLocais;

public class actRelatorio extends AppCompatActivity {

    private CursorAdapter adaptador;
    private Cursor locais;
    private ListView lstLocais;
    private DAOLocais daoLocais;
    private static final String CAMPOS[] = {//"_id",
                                            "LOC_DTAENT",
                                            "LOC_HRSENT",
                                            //"LOC_LATITU",
                                            //"LOC_LONGIT",
                                            "LOC_ENDERE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_relatorio);

        //getIntent();

        daoLocais = new DAOLocais(getApplicationContext());
        lstLocais = findViewById(R.id.lstLocaisVisitados);
        locais = daoLocais.ListarLocais();

        if(locais.getCount() > 0){
            adaptador = new SimpleCursorAdapter(getApplicationContext(),
                                                R.layout.activity_act_relatorio,
                                                locais,
                                                CAMPOS,
                                                new int[]{//R.id.txtAutoincrem,
                                                          R.id.txtData,
                                                          R.id.txtHora,
                                                          //R.id.txtLatitude,
                                                          //R.id.txtLongitude,
                                                          R.id.txtEndereco
                                                         }, 2);
            lstLocais.setAdapter(adaptador);

            lstLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String cod;
                    locais.moveToPosition(position);
                    cod = locais.getString(locais.getColumnIndexOrThrow("_id"));
                    Intent it = new Intent(getApplicationContext(), actRelatorio.class);
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
