/*
    HelloProcessing2.pde

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


public void setup()
{
    size(400, 400);
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

