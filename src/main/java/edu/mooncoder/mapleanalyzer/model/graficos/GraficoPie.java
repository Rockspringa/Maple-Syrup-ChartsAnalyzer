package edu.mooncoder.mapleanalyzer.model.graficos;

import java.util.List;

import edu.mooncoder.mapleanalyzer.exceptions.ReassigningFinalVariable;
import edu.mooncoder.mapleanalyzer.exceptions.RequiredAttributesNotFilledException;
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico;
import edu.mooncoder.mapleanalyzer.model.contracts.Tipo;
import edu.mooncoder.mapleanalyzer.model.structures.ParametrizeChanger;

public class GraficoPie extends Grafico {
    private Double[] valores;
    private String[] etiquetas;
    private Double total;
    private String extra;
    private Tipo tipo;

    public Double[] getValores() {
        return valores;
    }

    public void setValores(List<Object> valores) throws ReassigningFinalVariable {
        if (this.valores == null) {
            ParametrizeChanger<Double> changer = new ParametrizeChanger<>(5.2);
            this.valores = changer.changeParameter(valores).toArray(new Double[0]);
        } else {
            throw new ReassigningFinalVariable("valores");
        }
    }

    public String[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Object> etiquetas) throws ReassigningFinalVariable {
        if (this.etiquetas == null) {
            ParametrizeChanger<String> changer = new ParametrizeChanger<>("5.2");
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

            if (this.tipo == Tipo.PORCENTAJE) {
                this.setTotal(360.0);
            } 
        } else {
            throw new ReassigningFinalVariable("tipo");
        }
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) throws ReassigningFinalVariable {
        if (this.total == null) {
            this.total = total;
        } else {
            throw new ReassigningFinalVariable("total");
        }
    }

    @Override
    protected void block() throws RequiredAttributesNotFilledException {
        if (valores == null) {
            throw new RequiredAttributesNotFilledException("valores");
        } if (etiquetas == null) {
            throw new RequiredAttributesNotFilledException("etiquetas");
        } if (total == null) {
            throw new RequiredAttributesNotFilledException("total");
        } if (extra == null) {
            throw new RequiredAttributesNotFilledException("extra");
        } if (tipo == null) {
            throw new RequiredAttributesNotFilledException("extra");
        }
    }
}
