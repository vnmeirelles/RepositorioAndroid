package com.example.vnmeirelles.porondeestive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.vnmeirelles.porondeestive.Entidade.Configuracao;

public class actConfiguracao extends AppCompatActivity {
    CompoundButton chkMonitora;
    SeekBar skbTempo, skbDistancia;
    TextView txtTempo, txtDistancia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_configuracao);

        chkMonitora = findViewById(R.id.chkMonitora);
        skbTempo = findViewById(R.id.skbTempo);
        skbDistancia = findViewById(R.id.skbDistancia);
        txtTempo = findViewById(R.id.txtTempo);
        txtDistancia = findViewById(R.id.txtDistancia);

        cfgskBTempo();
        cfgskbDistamcia();

        chkMonitora.setChecked(true);
        skbTempo.setProgress(60000);
        skbDistancia.setProgress(100);
    }

    private void cfgskBTempo() {
        skbTempo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtTempo.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void cfgskbDistamcia() {
        skbDistancia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtDistancia.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void EnviaCfg(View v) {
        Configuracao cfg = new Configuracao();

        cfg.setHabilitado(chkMonitora.isChecked());
        cfg.setTempo(skbTempo.getProgress());
        cfg.setDistancia(skbDistancia.getProgress());

        Intent it = new Intent(this, actPrincipal.class);
        it.putExtra("cfg", cfg);
        startActivity(it);
    }

}