package com.example.vnmeirelles.porondeestive.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Text;

public class CreateDatabase extends SQLiteOpenHelper{
    static final String NOME_BANCO = "BANCO.DB";
    public static final String TABELA = "LOCAIS";
    public static final String ID = "_id";
    public static final String LATITUDE = "LOC_LATITU";
    public static final String LONGITUDE = "LOC_LONGIT";
    public static final String DATA = "LOC_DTAENT";
    public static final String HORA = "LOC_HRSENT";
    public static final String ENDERECO = "LOC_ENDERE";
    static final int VERSAO = 1;

    public CreateDatabase(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE " + TABELA + " ( "
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LATITUDE + " Real, "
                + LONGITUDE + " Real, "
                + DATA + " Date DEFAULT CURRENT_DATE, "
                + HORA + " Time DEFAULT CURRENT_TIME, "
                + ENDERECO + " Text)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
