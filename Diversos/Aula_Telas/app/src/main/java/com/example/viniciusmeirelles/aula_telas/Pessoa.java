package com.example.viniciusmeirelles.aula_telas;

import java.io.Serializable;

/**
 * Created by Vinicius Meirelles on 10/03/2018.
 */

public class Pessoa implements Serializable{

    private String nome;
    private Integer idade;

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Integer getIdade(){
        return this.idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }
}

