/*
    Ball.java

    Dr. Darren Kessner
    Copyright (C) 2019 Marlborough School

    This program is free software; you can redistribute it and/or modify it
    under the terms of the GNU General Public License as published by the Free
    Software Foundation; either version 2 of the License, or (at your option)
    any later version.

    This program is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
    more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc., 51
    Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/


// This Ball class shows how to use an external PApplet reference to draw.


import processing.core.*;


public class Ball
{
    public Ball(PApplet papplet)
    {
        // save reference to PApplet

        this.papplet = papplet;

        // set other properties to random values

        c = papplet.color(papplet.random(255), papplet.random(255), papplet.random(255));
        x = papplet.random(radius, papplet.width-radius);
        y = papplet.random(radius, papplet.height-radius);
        vx = papplet.random(-3, 3);
        vy = papplet.random(-3, 3);
    }

    public void display()
    {
        // draw

        papplet.fill(c);
        papplet.ellipse(x, y, radius*2, radius*2);

        // update position

        x += vx;
        y += vy;

        // bounce off walls

        if (x<radius || x>papplet.width-radius)
            vx = -vx;

        if (y<radius || y>papplet.height-radius)
            vy = -vy;
    }

    private PApplet papplet;

    private int radius = 25;
    private int c;

    private float x;
    private float y;
    private float vx;
    private float vy;
}

