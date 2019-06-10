/*
    HelloProcessing2.java

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


// This is a second example of using the Processing libraries to create a
// graphics application in Java.  This example illustrates how other classes
// (e.g. the Ball class) can hold a reference to the PApplet class in order to
// use the Processing drawing functions.


import processing.core.*;
import java.util.*;


public class HelloProcessing2 extends PApplet
{
    public void settings()
    {
        size(400, 400); // must be in settings(), not setup()
    }

    public void setup()
    {
        balls.add(new Ball(this)); // start with single ball
    }

    public void draw()
    {
        background(0);

        fill(255);
        textSize(20);
        text("UP/DOWN: add/remove ball", 20, 50);

        for (Ball b : balls)
            b.display();
    }

    public void keyPressed()
    {
        if (keyCode == UP)
            balls.add(new Ball(this));
        else if (keyCode == DOWN && balls.size()>0)
            balls.remove(0);
    }

    private ArrayList<Ball> balls = new ArrayList<Ball>();

    public static void main(String[] args)
    {
        PApplet.main("HelloProcessing2");
    }
}


