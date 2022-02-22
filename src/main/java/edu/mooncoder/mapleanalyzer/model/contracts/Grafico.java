package edu.mooncoder.mapleanalyzer.model.contracts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mooncoder.mapleanalyzer.exceptions.ReassigningFinalVariable;
import edu.mooncoder.mapleanalyzer.model.structures.ParametrizeChanger;
import edu.mooncoder.mapleanalyzer.model.structures.TuplaBivalor;

public abstract class Grafico {
    private static final Map<String, Grafico> graficos = new HashMap<>();

    private TuplaBivalor[] unir;
    private String titulo;

    protected void addGrafico(String titulo, Grafico grafico) {
        graficos.put(titulo, grafico);
    }

    public static Grafico getGrafico(String titulo) {
        return graficos.get(titulo);
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

    public void setUnir(List<Object> unir) throws ReassigningFinalVariable {
        if (this.unir == null) {
            ParametrizeChanger<String> changer = new ParametrizeChanger<>(String.valueOf(5.2));
            this.unir = changer.changeParameter(unir).toArray(new TuplaBivalor[0]);
        } else {
            throw new ReassigningFinalVariable("unir");
        }
    }
}
