package edu.mooncoder.mapleanalyzer.model.structures;

public class TuplaBivalor {
    private final int x;
    private final int y;
    
    public TuplaBivalor(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
