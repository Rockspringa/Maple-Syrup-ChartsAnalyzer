package edu.mooncoder.mapleanalyzer.model.structures;

import edu.mooncoder.mapleanalyzer.exceptions.NotIntegerException;

public class TuplaBivalor {
    private final int x;
    private final int y;
    
    public TuplaBivalor(double x, double y) throws NotIntegerException {
        if (x % 1 != 0.0)
            throw new NotIntegerException(x);
        if (y % 1 != 0.0)
            throw new NotIntegerException(y);

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
