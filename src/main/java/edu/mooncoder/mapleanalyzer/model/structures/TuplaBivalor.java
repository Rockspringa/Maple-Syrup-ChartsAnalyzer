package edu.mooncoder.mapleanalyzer.model.structures;

public class TuplaBivalor {
    private final int key;
    private final int val;
    
    public TuplaBivalor(double key, double val) {
        this.key = (int) key;
        this.val = (int) val;
    }

    public int getKey() {
        return key;
    }

    public int getVal() {
        return val;
    }
}
