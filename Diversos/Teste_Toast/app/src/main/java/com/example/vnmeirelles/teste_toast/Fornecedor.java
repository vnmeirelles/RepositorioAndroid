package com.example.vnmeirelles.teste_toast;

import java.io.Serializable;

public class Fornecedor implements Serializable {
    public int fundacao;
    public String nome;

    public Fornecedor(String nome, int fundacao){
        this.nome = nome;
        this.fundacao = fundacao;
    }
}
