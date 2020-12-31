// Example 93 from page 67 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.awt.Color;
import java.awt.Graphics;

interface Colored {
    Color getColor();
}

interface Drawable {
    void draw(Graphics g);
}

interface ColoredDrawable extends Colored, Drawable {
}
