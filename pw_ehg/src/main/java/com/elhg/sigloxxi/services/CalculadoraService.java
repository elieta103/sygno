package com.elhg.sigloxxi.services;

import com.elhg.sigloxxi.dtos.CalculosIniciales;
import com.elhg.sigloxxi.dtos.Item;
import com.elhg.sigloxxi.dtos.TablaResumen;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;


@Named
@ApplicationScoped
public class CalculadoraService {

    private List<Item> items;
    private List<Item> itemsFormato;


    @PostConstruct
    public void init() {
        items = new ArrayList<Item>();
    }

    public TablaResumen getCalculosItems() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        CalculosIniciales calculosIniciales = (CalculosIniciales) sessionMap.get("calculosIniciales");

        int totalMeses = Integer.valueOf(calculosIniciales.getOpcionAnios().split("-")[0]).intValue();
        Double interesAnual = Double.valueOf(calculosIniciales.getOpcionAnios().split("-")[1]);
        Double interesMensual = interesAnual / 12.0 ;
        Double deduccion = Double.valueOf(calculosIniciales.getOpcionAnios().split("-")[2]);

        Double montoInicial = Double.valueOf(calculosIniciales.getMonto());
        Double montoPorRen = (montoInicial * interesMensual) / 100;
        Double montoFinal = montoInicial + montoPorRen;

        System.out.println("totalMeses --- "+totalMeses);
        System.out.println("interesAnual --- "+interesAnual);
        System.out.println("interesMensual --- "+interesMensual);
        System.out.println("deduccion --- "+deduccion);

        items.clear();

        double amount =200.0;
        System.out.println();

        for (int i=1; i<=totalMeses; i++){
            Item item = new Item(Integer.toString(i),
                    montoInicial.toString(),
                    montoPorRen.toString(),
                    montoFinal.toString());

            items.add(item);

            montoInicial = montoFinal;
            montoPorRen = (montoInicial * interesMensual) / 100.00;
            montoFinal = montoInicial + montoPorRen;
        }

        Double diferencia =
                Double.valueOf(items.get(totalMeses-1).getMontoFinal()) - Double.valueOf(calculosIniciales.getMonto()) ;
        System.out.println("Diferencia "+diferencia);

        Double deduccionDiferencia = (diferencia * deduccion) / 100.00;
        System.out.println("deduccionDiferencia "+deduccionDiferencia);

        Double totalDeduccionDiferencia =
                ( Double.valueOf(items.get(totalMeses-1).getMontoFinal()) - deduccionDiferencia) ;

        String strMontoNetoPagar =
                NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(totalDeduccionDiferencia);



        itemsFormato = new ArrayList<>();
        for(Item item: items){
            Double mi = Double.valueOf(item.getMontoInicial());
            Double mpr = Double.valueOf(item.getMontoPorRend());
            Double mf = Double.valueOf(item.getMontoFinal());

            Item itemFormato = new Item(item.getNoMes(),
                    NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(mi.doubleValue()),
                    NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(mpr.doubleValue()),
                    NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(mf.doubleValue()));

            itemsFormato.add(itemFormato);
        }




        TablaResumen tablaResumen = new TablaResumen(itemsFormato, strMontoNetoPagar);

        return tablaResumen;
    }
}
