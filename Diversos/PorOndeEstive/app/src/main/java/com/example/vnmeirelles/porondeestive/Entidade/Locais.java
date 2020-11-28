package com.example.vnmeirelles.porondeestive.Entidade;

import android.provider.ContactsContract;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Date;

public class Locais {
    private Integer _id;
    private Date data;
    private Time hora;
    private Double latitude;
    private Double longitude;
    public Text endereco;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Text getEndereco() {
        return endereco;
    }

    public void setEndereco(Text endereco) {
        this.endereco = endereco;
    }
}
