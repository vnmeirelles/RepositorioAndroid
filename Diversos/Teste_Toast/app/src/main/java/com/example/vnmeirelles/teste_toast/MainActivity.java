package com.example.vnmeirelles.teste_toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtSobrenome, edtIdade;
    Button btnToast, btnChamaTela, btnCliente, btnFornecedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = (EditText) findViewById(R.id.edtNomeT1);
        edtSobrenome = (EditText) findViewById(R.id.edtSobrenomeT1);
        edtIdade = (EditText) findViewById(R.id.edtIdadeT1);

        btnToast = (Button) findViewById(R.id.btnToastT1);
        btnChamaTela = (Button) findViewById(R.id.btnChamaTelaT1);
        btnCliente = (Button) findViewById(R.id.btnClienteT1);
        btnFornecedor = (Button) findViewById(R.id.btnFornecedorT1);

        // btnToast.setOnClickListener(this);
        // btnChamaTela.setOnClickListener(this);
        // btnCliente.setOnClickListener(this);
        // btnFornecedor.setOnClickListener(this);

    }
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btnToastT1:
                String concat = edtNome.getText().toString() + edtSobrenome.getText().toString() + edtIdade.getText().toString();
                Toast.makeText(this,  concat,Toast.LENGTH_LONG).show();
                break;
            case R.id.btnChamaTelaT1:
                Intent it = new Intent(this, Main2Activity.class);
                it.putExtra("Nome", edtNome.getText().toString());
                it.putExtra("Sobrenome", edtSobrenome.getText().toString());
                it.putExtra("Idade", edtIdade.getText().toString());
                startActivity(it);
                break;
            case R.id.btnClienteT1:
                Cliente cli = new Cliente(Integer.parseInt(edtIdade.getText().toString()), edtNome.getText().toString());
                Intent itc = new Intent(this,Main2Activity.class);
                itc.putExtra("cliente", cli);
                startActivity(itc);
                break;
            case R.id.btnFornecedorT1:
                Intent itf = new Intent(this, Main2Activity.class);
                itf.putExtra("fornecedor", new Fornecedor(edtNome.getText().toString(), Integer.parseInt(edtIdade.getText().toString())));
                startActivity(itf);
                break;
        }

    }

}
