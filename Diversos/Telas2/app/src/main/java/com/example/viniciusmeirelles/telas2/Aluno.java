package com.example.viniciusmeirelles.telas2;

import java.io.Serializable;

/**
 * Created by Vinicius Meirelles on 17/03/2018.
 */

public class Aluno implements Serializable {
    private String Nome;
    private int Idade;
    private String RA;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome=nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade=idade;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA=RA;
    }
}

