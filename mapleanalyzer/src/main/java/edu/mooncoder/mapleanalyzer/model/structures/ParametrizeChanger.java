package edu.mooncoder.mapleanalyzer.model.structures;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class ParametrizeChanger<T> {
    private Class<T> example;

    public ParametrizeChanger(T example) {
        this.example = (Class<T>) example.getClass();
    }
    
    public List<T> changeParameter(List<Object> list) {
        ArrayList<T> aux = new ArrayList<>();

        for (Object str : list) {
            if (this.example.isInstance(str))
                aux.add((T) str);
            else
                throw new InputMismatchException();
        }

        return aux;
    }
}
