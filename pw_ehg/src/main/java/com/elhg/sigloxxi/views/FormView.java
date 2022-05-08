package com.elhg.sigloxxi.views;

import com.elhg.sigloxxi.dtos.CalculosIniciales;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.Map;


@Named("formulario")
@ViewScoped
public class FormView implements Serializable {

    private String name;
    private String apellidos;
    private String correo;
    private String opcionAnios;
    private Double monto = Double.valueOf(0);


    public String submitAnswer() {
        CalculosIniciales calculosIniciales = new CalculosIniciales(this.name, this.apellidos, this.correo, this.opcionAnios, this.monto );
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("calculosIniciales", calculosIniciales);
        return "table.xhtml";
    }

    public void reset() {
        System.out.println("Reset ");
        PrimeFaces.current().resetInputs("form:panel");
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
