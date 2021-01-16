package com.precisely.java.example094;

import java.awt.*;

import com.precisely.java.example027.Point;
import com.precisely.java.example093.Colored;

class ColoredPoint extends Point implements Colored {
    Color c;

    ColoredPoint(int x, int y, Color c) {
        super(x, y);
        this.c = c;
    }

    @Override
    public Color getColor() {
        return c;
    }
}
