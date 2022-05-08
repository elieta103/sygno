package com.elhg.sigloxxi.views;


import com.elhg.sigloxxi.dtos.Item;
import com.elhg.sigloxxi.dtos.TablaResumen;
import com.elhg.sigloxxi.services.CalculadoraService;
import jakarta.annotation.PostConstruct;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("tabla")
@ViewScoped
public class TableView implements Serializable {

    private TablaResumen tablaResumen;

    @Inject
    private CalculadoraService service;

    @PostConstruct
    public void init() {
        tablaResumen = new TablaResumen();
        tablaResumen = service.getCalculosItems();
    }

    public List<Item> getItems() {
        return this.tablaResumen.getItems();
    }

    public TablaResumen getTablaResumen() {
        return this.tablaResumen;
    }

    public void setService(CalculadoraService service) {
        this.service = service;
    }


}
