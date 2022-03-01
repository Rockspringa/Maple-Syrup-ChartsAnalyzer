package edu.mooncoder.mapleanalyzer.model.structures;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import edu.mooncoder.mapleanalyzer.model.wrappers.ErrorHolder;

public class ParametrizeChanger<T> {
    private final Class<T> example;

    public ParametrizeChanger(T example) {
        this.example = (Class<T>) example.getClass();
    }
    
    public List<T> changeParameter(List<Object> list) {
        ArrayList<T> aux = new ArrayList<>();

        for (Object str : list) {
            if (this.example.isInstance(str))
                aux.add((T) str);
            else
                ErrorHolder.messageThrowed("Una lista solo puede ser de un tipo de valor.", 2);
        }

        return aux;
    }
}
