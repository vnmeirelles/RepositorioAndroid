package com.cursoandroid.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirDialog(View view){

        //Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder( this );

        //Configurar titulo e mensagem
        dialog.setTitle("Título da dialog");
        dialog.setMessage("Mensagem da Dialog");

        //Configurar cancelamento
        dialog.setCancelable(false);

        //Configurar icone
        dialog.setIcon( android.R.drawable.ic_btn_speak_now );

        //Configura acoes para sim e nao
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(
                        getApplicationContext(),
                        "Executar ação ao clicar no botão Sim",
                        Toast.LENGTH_SHORT
                ).show();

            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(
                        getApplicationContext(),
                        "Executar ação ao clicar no botão não",
                        Toast.LENGTH_SHORT
                ).show();

            }
        });

        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();

    }

}
