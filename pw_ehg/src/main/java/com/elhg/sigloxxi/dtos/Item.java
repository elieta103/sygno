package com.elhg.sigloxxi.dtos;

import java.io.Serializable;

public class Item implements Serializable {
    private String noMes;
    private String montoInicial;
    private String montoPorRend;
    private String montoFinal;


    public Item(String noMes, String montoInicial, String montoPorRend, String montoFinal) {
        this.noMes = noMes;
        this.montoInicial = montoInicial;
        this.montoPorRend = montoPorRend;
        this.montoFinal = montoFinal;
    }

    public String getNoMes() {
        return noMes;
    }

    public void setNoMes(String noMes) {
        this.noMes = noMes;
    }

    public String getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(String montoInicial) {
        this.montoInicial = montoInicial;
    }

    public String getMontoPorRend() {
        return montoPorRend;
    }

    public void setMontoPorRend(String montoPorRend) {
        this.montoPorRend = montoPorRend;
    }

    public String getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(String montoFinal) {
        this.montoFinal = montoFinal;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "noMes='" + noMes + '\'' +
                ", montoInicial='" + montoInicial + '\'' +
                ", montoPorRend='" + montoPorRend + '\'' +
                ", montoFinal='" + montoFinal + '\'' +
                '}';
    }
}
