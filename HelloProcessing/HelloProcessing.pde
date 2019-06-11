/*
    HelloProcessing.pde

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
}

public void draw()
{
    background(0);
    fill(c);
    ellipse(x, y, radius*2, radius*2);

    x += vx;
    y += vy;

    if (x<radius || x>width-radius)
        vx = -vx;

    if (y<radius || y>height-radius)
        vy = -vy;
}

public void keyPressed()
{
    if (key == ' ')
        c = color(random(255), random(255), random(255));
}

private int x = 200;
private int y = 200;
private int radius = 25;
private int vx = 1;
private int vy = 2;
private int c = color(255);

