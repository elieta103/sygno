package com.elhg.sigloxxi.dtos;

public class CalculosIniciales {
    private String name;
    private String apellidos;
    private String correo;
    private String opcionAnios;
    private Double monto = Double.valueOf(0);


    public CalculosIniciales() {
    }

    public CalculosIniciales(String name, String apellidos, String correo, String opcionAnios, Double monto) {
        this.name = name;
        this.apellidos = apellidos;
        this.correo = correo;
        this.opcionAnios = opcionAnios;
        this.monto = monto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOpcionAnios() {
        return opcionAnios;
    }

    public void setOpcionAnios(String opcionAnios) {
        this.opcionAnios = opcionAnios;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
