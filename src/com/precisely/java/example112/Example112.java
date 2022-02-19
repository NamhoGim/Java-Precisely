package com.precisely.java.example112;// Example 112 from page 85 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;

class AnimatedCanvas extends Canvas implements Runnable {
    static final long serialVersionUID = 50L;
    private int scale = 50, step = 5;

    AnimatedCanvas() {
        Thread u = new Thread(this);
        u.start();
    }

    @Override
    public void run() {                           // from Runnable
        for (; ; ) { // forever sleep and repaint
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            if (scale <= 0 || scale >= 100)
                step = -step;
            scale += step;
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {               // from Canvas
        Dimension size = getSize();
        g.fillRect(scale * (size.width - 20) / 100, 0, 20, 20);
        g.fillRect((100 - scale) * (size.width - 20) / 100, size.height - 20, 20, 20);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 100);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}

class Example112 {
    public static void main(String[] args) {
        Canvas anim1 = new AnimatedCanvas();
        Canvas anim2 = new AnimatedCanvas();
        Frame f = new Frame("Animation with threads");
        f.add(anim1, "North");
        f.add(anim2, "South");
        f.pack();
        f.setVisible(true);
    }
}
