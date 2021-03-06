package com.precisely.java.example095;
// Example 95 from page 67 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;

import com.precisely.java.example093.Colored;
import com.precisely.java.example093.ColoredDrawable;
import com.precisely.java.example094.ColoredDrawablePoint;
import com.precisely.java.example094.ColoredRectangle;

class Example95 {
    static void printcolors(Colored[] cs) {
        for (int i = 0; i < cs.length; i++)
            System.out.println(cs[i].getColor().toString());
    }

    static void draw(Graphics g, ColoredDrawable[] cs) {
        for (int i = 0; i < cs.length; i++) {
            g.setColor(cs[i].getColor());
            cs[i].draw(g);
        }
    }

    public static void main(String[] args) {
        final ColoredDrawable[] cs =
                {new ColoredDrawablePoint(3, 4, Color.red),
                        new ColoredRectangle(50, 100, 60, 110, Color.green)};
        printcolors(cs);
        Frame f = new Frame();
        // Anonymous local inner class, subclass of java.awt.Canvas
        f.add(new Canvas() {
            static final long serialVersionUID = 50L;

            public void paint(Graphics g) {
                draw(g, cs);
            }

            public Dimension getPreferredSize() {
                return new Dimension(400, 300);
            }
        });
        f.pack();
        f.setVisible(true);
    }
}
