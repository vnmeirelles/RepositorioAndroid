package com.example.vnmeirelles.exsqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.vnmeirelles.exsqlite.entidade.Livro;

public class DAOLivro {

    private SQLiteDatabase db;
    private CriaBanco banco;
    private static final String CAMPOS[] = {"titulo", "autor", "editora", "_id"};

    public DAOLivro(Context context){
        banco = new CriaBanco(context);
    }

    public String InsereLivro(Livro livro){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(CriaBanco.TITULO, livro.getTitulo());
        valores.put(CriaBanco.EDITORA, livro.getEditora());
        valores.put(CriaBanco.AUTOR,livro.getAutor());

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if(resultado == -1){
            return "Erro ao inserir";
        }else{
            return "Inserido com sucesso";
        }
    }

    public Cursor ListarLivros(){
        db = banco.getWritableDatabase();

        Cursor livros = db.query(CriaBanco.TABELA, CAMPOS, null,null,null,null,null);

        if(livros != null){
            livros.moveToFirst();
        }

        db.close();
        return livros;
    }

    public void AlterarRegistro(Livro livro){
        ContentValues valores;

        db = banco .getWritableDatabase();

        valores = new ContentValues();
        valores.put(CriaBanco.AUTOR,livro.getAutor());
        valores.put(CriaBanco.EDITORA,livro.getEditora());
        valores.put(CriaBanco.TITULO,livro.getTitulo());

        String where;
        where = CriaBanco.ID + " = " + livro.getId();

        db.update(CriaBanco.TABELA, valores, where, null);
        db.close();
    }

    public void DeletarRegistro(int id){
        String where = CriaBanco.ID + " = " + id;
        db = banco.getWritableDatabase();
        db.delete(CriaBanco.TABELA, where, null);
        db.close();
    }

    public Cursor BuscaPorId(int id){
        String where = CriaBanco.ID + " = " + id;

        db = banco.getWritableDatabase();

        Cursor selecao = db.query(CriaBanco.TABELA, CAMPOS, where,null,null,null,null);

        if(selecao != null){
            selecao.moveToFirst();
        }

        db.close();
        return selecao;
    }


}
