package com.example.vnmeirelles.porondeestive.Entidade;

import android.content.Intent;

import java.io.Serializable;

public class Configuracao implements Serializable {
    private boolean habilitado;
    private double tempo;
    private double distancia;

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

}
