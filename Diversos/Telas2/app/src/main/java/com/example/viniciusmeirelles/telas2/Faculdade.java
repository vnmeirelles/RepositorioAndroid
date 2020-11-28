package com.example.viniciusmeirelles.telas2;

import java.io.Serializable;

/**
 * Created by Vinicius Meirelles on 17/03/2018.
 */

public class Faculdade implements Serializable{
    private String Nome;
    private String Curso;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome=nome;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso=curso;
    }
}
