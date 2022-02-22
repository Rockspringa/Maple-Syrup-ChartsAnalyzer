package edu.mooncoder.mapleanalyzer.model.graficos;

import java.util.List;

import edu.mooncoder.mapleanalyzer.exceptions.ReassigningFinalVariable;
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico;
import edu.mooncoder.mapleanalyzer.model.contracts.Tipo;
import edu.mooncoder.mapleanalyzer.model.structures.ParametrizeChanger;

public class GraficoPie extends Grafico {
    private Integer[] valores;
    private String[] etiquetas;
    private Integer total;
    private String extra;
    private Tipo tipo;

    public Integer[] getValores() {
        return valores;
    }

    public void setValores(List<Object> valores) throws ReassigningFinalVariable {
        if (this.valores == null) {
            ParametrizeChanger<String> changer = new ParametrizeChanger<>(String.valueOf(5.2));
            this.valores = changer.changeParameter(valores).toArray(new Integer[0]);
        } else {
            throw new ReassigningFinalVariable("valores");
        }
    }

    public String[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Object> etiquetas) throws ReassigningFinalVariable {
        if (this.etiquetas == null) {
            ParametrizeChanger<String> changer = new ParametrizeChanger<>(String.valueOf(5.2));
            this.etiquetas = changer.changeParameter(etiquetas).toArray(new String[0]);
        } else {
            throw new ReassigningFinalVariable("etiquetas");
        }
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) throws ReassigningFinalVariable {
        if (this.extra == null) {
            this.extra = extra;
        } else {
            throw new ReassigningFinalVariable("extra");
        }
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) throws ReassigningFinalVariable {
        if (this.tipo == null) {
            this.tipo = tipo;
        } else {
            throw new ReassigningFinalVariable("tipo");
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) throws ReassigningFinalVariable {
        if (this.total == null) {
            this.total = total;
        } else {
            throw new ReassigningFinalVariable("total");
        }
    }
}
