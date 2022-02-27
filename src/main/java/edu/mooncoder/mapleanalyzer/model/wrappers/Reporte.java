package edu.mooncoder.mapleanalyzer.model.wrappers;

import java.util.ArrayList;
import java.util.List;

import edu.mooncoder.mapleanalyzer.model.contracts.Grafico;
import edu.mooncoder.mapleanalyzer.model.graficos.GraficoPie;

public class Reporte {
    private static Reporte singleton;

    private final List<OcurrenciaMatematica> ocurrenciasMatematicas;
    private int piesDefinidos;
    private int barsDefinidos;

    private Reporte() {
        this.ocurrenciasMatematicas = new ArrayList<>();
        this.piesDefinidos = 0;
        this.barsDefinidos = 0;
    }

    public static Reporte getReporte() {
        if (singleton == null) {
            singleton = new Reporte();
        }
        return singleton;
    }

    public static void getReporte(boolean clear) {
        singleton = null;
    }

    public void graficoDefinido(Grafico grafico) {
        if (grafico instanceof GraficoPie)
            this.piesDefinidos++;
        else
            this.barsDefinidos++;
    }

    public void addOcurrenciaMatematica(OcurrenciaMatematica ocurrenciaMatematica) {
        this.ocurrenciasMatematicas.add(ocurrenciaMatematica);
    }

    public int getPiesDefinidos() {
        return this.piesDefinidos;
    }

    public int getBarsDefinidos() {
        return this.barsDefinidos;
    }

    public List<OcurrenciaMatematica> getOcurrenciasMatematicas() {
        return this.ocurrenciasMatematicas;
    }
}
