// Example 94 from page 67 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.awt.Color;
import java.awt.Graphics;

class ColoredPoint extends com.precisely.java.example027.Point implements Colored {
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

class ColoredDrawablePoint extends ColoredPoint implements ColoredDrawable {
    ColoredDrawablePoint(int x, int y, Color c) {
        super(x, y, c);
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(x, y, 1, 1);
    }
}

class ColoredRectangle implements ColoredDrawable {
    int x1, x2, y1, y2;   // (x1, y1) upper left, (x2, y2) lower right corner
    Color c;

    ColoredRectangle(int x1, int y1, int x2, int y2, Color c) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.c = c;
    }

    @Override
    public Color getColor() {
        return c;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(x1, y1, x2 - x1, y2 - y1);
    }
}
