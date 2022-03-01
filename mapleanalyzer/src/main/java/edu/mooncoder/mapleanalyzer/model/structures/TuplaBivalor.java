package edu.mooncoder.mapleanalyzer.model.structures;

import edu.mooncoder.mapleanalyzer.exceptions.NotIntegerException;
import edu.mooncoder.mapleanalyzer.model.wrappers.ErrorHolder;

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

    public TuplaBivalor(double x, double y, int xl, int xc, int yl, int yc) {
        if (x % 1 != 0.0)
            ErrorHolder.messageThrowed(new NotIntegerException(x).getMessage(), 1, xl, xc);
        if (y % 1 != 0.0)
            ErrorHolder.messageThrowed(new NotIntegerException(y).getMessage(), 1, yl, yc);

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
