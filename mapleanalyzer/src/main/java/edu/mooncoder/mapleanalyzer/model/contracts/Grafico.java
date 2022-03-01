package edu.mooncoder.mapleanalyzer.model.contracts;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import edu.mooncoder.mapleanalyzer.exceptions.NotIntegerException;
import edu.mooncoder.mapleanalyzer.exceptions.ReassigningFinalVariable;
import edu.mooncoder.mapleanalyzer.exceptions.RequiredAttributesNotFilledException;
import edu.mooncoder.mapleanalyzer.exceptions.UnknownChartException;
import edu.mooncoder.mapleanalyzer.model.structures.ParametrizeChanger;
import edu.mooncoder.mapleanalyzer.model.structures.TuplaBivalor;
import edu.mooncoder.mapleanalyzer.model.wrappers.Reporte;

public abstract class Grafico {
    private static final Map<String, Grafico> graficos = new HashMap<>();
    private static final LinkedList<Grafico> colaEjecucion = new LinkedList<>();

    private TuplaBivalor[] unir;
    private String titulo;

    abstract protected void block() throws RequiredAttributesNotFilledException;

    public static void clean() {
        graficos.clear();
        colaEjecucion.clear();
    }

    public static Queue<Grafico> getColaEjecucion() {
        return colaEjecucion;
    }

    public static void ejecutar(String titulo) throws UnknownChartException {
        if (graficos.containsKey(titulo)) {
            colaEjecucion.add(graficos.get(titulo));
        } else {
            throw new UnknownChartException(titulo);
        }
    }

    public static Map<String, Grafico> getGraficos() {
        return graficos;
    }

    public void addGrafico() throws RequiredAttributesNotFilledException {
        if (unir == null) {
            throw new RequiredAttributesNotFilledException("unir");
        } if (titulo == null) {
            throw new RequiredAttributesNotFilledException("titulo");
        }
        block();
        graficos.put(this.titulo, this);

        Reporte.getReporte().graficoDefinido(this);
    }
    
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) throws ReassigningFinalVariable {
        if (this.titulo == null)
            this.titulo = titulo;
        else
            throw new ReassigningFinalVariable("titulo");
    }

    public TuplaBivalor[] getUnir() {
        return this.unir;
    }

    public void setUnir(List<Object> unir) throws ReassigningFinalVariable, NotIntegerException {
        if (this.unir == null) {
            ParametrizeChanger<TuplaBivalor> changer = new ParametrizeChanger<>(new TuplaBivalor(0.0, 0.0));
            this.unir = changer.changeParameter(unir).toArray(new TuplaBivalor[0]);
        } else {
            throw new ReassigningFinalVariable("unir");
        }
    }
}
