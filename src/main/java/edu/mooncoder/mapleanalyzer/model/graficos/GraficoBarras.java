package edu.mooncoder.mapleanalyzer.model.graficos;

import java.util.List;

import edu.mooncoder.mapleanalyzer.exceptions.ReassigningFinalVariable;
import edu.mooncoder.mapleanalyzer.exceptions.RequiredAttributesNotFilledException;
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico;
import edu.mooncoder.mapleanalyzer.model.structures.ParametrizeChanger;

public class GraficoBarras extends Grafico {
    private String[] ejeX;
    private Double[] ejeY;

    public String[] getEjeX() {
        return this.ejeX;
    }

    public void setEjeX(List<Object> ejeX) throws ReassigningFinalVariable {
        if (this.ejeX == null) {
            ParametrizeChanger<String> changer = new ParametrizeChanger<>(String.valueOf(5.2));
            this.ejeX = changer.changeParameter(ejeX).toArray(new String[0]);
        } else {
            throw new ReassigningFinalVariable("eje x");
        }
    }

    public Double[] getEjeY() {
        return this.ejeY;
    }

    public void setEjeY(List<Object> ejeY) throws ReassigningFinalVariable {
        if (this.ejeY == null) {
            ParametrizeChanger<Double> changer = new ParametrizeChanger<>(Double.valueOf(5.2));
            this.ejeY = changer.changeParameter(ejeY).toArray(new Double[0]);
        } else {
            throw new ReassigningFinalVariable("eje y");
        }
    }

    @Override
    protected void block() throws RequiredAttributesNotFilledException {
        if (ejeX == null) {
            throw new RequiredAttributesNotFilledException("eje X");
        } if (ejeY == null) {
            throw new RequiredAttributesNotFilledException("eje Y");
        }
    }
}
