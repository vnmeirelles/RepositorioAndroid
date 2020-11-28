package com.example.vnmeirelles.app_01_estudo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bnt;
    TextView txt;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt = (EditText) findViewById(R.id.edtt1);
        final TextView txt = (TextView) findViewById(R.id.textViewT1);
        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), Main2Activity.class);
                it.putExtra("nome", edt.getText().toString());
                startActivity(it);

               // txt.setText(String.format("TEXTO /%s",  edt.getText()));
            }
        });

        }
}


