package com.example.vnmeirelles.porondeestive.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.vnmeirelles.porondeestive.Entidade.Locais;

import java.util.Date;

public class DAOLocais {

    private SQLiteDatabase db;
    private CreateDatabase banco;
    private static final String CAMPOS[] = {"_id","LOC_DTAENT","LOC_HRSENT", "LOC_LATITU", "LOC_LONGIT", "LOC_ENDERE"};

    public DAOLocais(Context context){
        banco = new CreateDatabase(context);
    }

    public DAOLocais(Context context, String endereco){
        banco = new CreateDatabase(context);
    }

    public String InsereLocais(Locais locais, String end){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(CreateDatabase.LATITUDE,locais.getLatitude());
        valores.put(CreateDatabase.LONGITUDE,locais.getLongitude());
        valores.put(CreateDatabase.ENDERECO, end);

        resultado = db.insert(CreateDatabase.TABELA, null, valores);
        db.close();


        if(resultado == -1){
            return "Erro ao inserir";
        }else{
            return "Inserido com sucesso";
        }

    }

    public Cursor ListarLocais(){
        db = banco.getWritableDatabase();

        Cursor locais = db.query(CreateDatabase.TABELA, CAMPOS, null,null,null,null, null);

        if(locais != null){
            locais.moveToFirst();
        }

        db.close();
        return locais;
    }

    public Cursor BuscaPorData(Date data){
        String where = CreateDatabase.DATA + " = " + data;

        db = banco.getWritableDatabase();

        Cursor selecao = db.query(CreateDatabase.TABELA, CAMPOS, where,null,null,null,"LOC_DTAENT");

        if(selecao != null){
            selecao.moveToFirst();
        }

        db.close();
        return selecao;
    }

    public void DeletarRegistro(int data){
        String where = CreateDatabase.DATA + " = " + data;
        db = banco.getWritableDatabase();
        db.delete(CreateDatabase.TABELA, where, null);
        db.close();
    }

    public void DeletarTodoRegistro(){
        db = banco.getWritableDatabase();
        db.delete(CreateDatabase.TABELA, null, null);
        db.close();
    }

}
