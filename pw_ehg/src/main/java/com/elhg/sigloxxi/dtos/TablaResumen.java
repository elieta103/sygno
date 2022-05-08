package com.elhg.sigloxxi.dtos;

import java.io.Serializable;
import java.util.List;

public class TablaResumen implements Serializable {
    private List<Item> items;
    private String montoNetoPagar;

    public TablaResumen() {
    }

    public TablaResumen(List<Item> items, String montoNetoPagar) {
        this.items = items;
        this.montoNetoPagar = montoNetoPagar;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getMontoNetoPagar() {
        return montoNetoPagar;
    }

    public void setMontoNetoPagar(String montoNetoPagar) {
        this.montoNetoPagar = montoNetoPagar;
    }
}
