package com.example.vnmeirelles.seek;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CompoundButton checkBox;
    SeekBar seekBar;
    Spinner spinner;
    RadioGroup radioGroup;
    TextView textView;
    AlertDialog.Builder msgAlerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.ckbHabilitado);
        seekBar = findViewById(R.id.skbValor);
        spinner = findViewById(R.id.spnNomes);
        radioGroup = findViewById(R.id.rgOpcoes);
        textView = findViewById(R.id.txtValor);

        msgAlerta = new AlertDialog.Builder(this);
        //chamada de metodos para configuração
        configurarSpinner();
        configurarSeekBar();

        //valores padrão
        checkBox.setChecked(true);
        seekBar.setProgress(30);
        radioGroup.check(R.id.rbOpcao2);
        spinner.setSelection(2);

    }

    private void configurarSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void configurarSpinner() {

        String[] nomes = new String[]{ "Menino 1", "Menino 2", "Menino 3", "Menino 4" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nomes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void verValores(View v){
        int idRadioSelecionado = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(idRadioSelecionado);

        String habilitado = checkBox.isChecked() ? "Habilitado" : "Desabilitado";
        String opcao = radioButton.getText().toString();
        String spinnersNomes = spinner.getSelectedItem().toString();
        String barSeek = "Valor: " + String.valueOf(seekBar.getProgress());

        String msg = habilitado + "\n" +
                     opcao + "\n" +
                     spinnersNomes + "\n" +
                     barSeek;

        msgAlerta.setMessage(msg);
        msgAlerta.setTitle("Exemplo Componentes");
        msgAlerta.setPositiveButton("OK", null);
        msgAlerta.setNegativeButton("Não", null);
        msgAlerta.setCancelable(false);
        msgAlerta.create().show();
    }

    public void cliqueLongo(View v){
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                msgAlerta.setMessage("Exemplo de Clique Longo");
                msgAlerta.setTitle("Longo");
                msgAlerta.setPositiveButton("OI", null);
                msgAlerta.create().show();
                return true;
            }
        });

        Button button = findViewById(R.id.btn01);
        button.setText("Alterado");
        Toast.makeText(getBaseContext(), "Click Rapido", Toast.LENGTH_LONG).show();
    }
}
