/*
    Snowflake.pde

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


public static final int windowSize = 400;

public void setup()
{
    size(400, 400);
}

private int level = 0;

void snowflakeSegment(int depth)
{
    stroke(255);

    if (depth <= 0)
    {
        // draw single segment 

        line(-100, 0, 100, 0);            
    }
    else
    {
        // reduce depth and recursively draw 4 transformed segments

        pushMatrix();
        translate(-200/3f, 0);
        scale(1/3f);
        snowflakeSegment(depth-1);
        popMatrix();

        pushMatrix();
        translate(-100/6f, 50*sqrt(3)/3);
        rotate(PI/3);
        scale(1/3f);
        snowflakeSegment(depth-1);
        popMatrix();

        pushMatrix();
        translate(100/6f, 50*sqrt(3)/3);
        rotate(-PI/3);
        scale(1/3f);
        snowflakeSegment(depth-1);
        popMatrix();

        pushMatrix();
        translate(200/3f, 0);
        scale(1/3f);
        snowflakeSegment(depth-1);
        popMatrix();
    }
}

private boolean showSnowflake = false;

public void draw()
{
    background(0);

    // print level

    fill(255);
    textSize(15);
    text("Change level: UP/DOWN", 50, 30);
    text("Toggle snowflake: s", 50, 60);
    textSize(30);
    text("" + level, width-50, 30);

    // transform to standard coordinate system

    translate(width/2, height/2);   // move origin to center of window
    scale(1, -1);                   // flip y-axis
    scale((float)windowSize/200);   // scale: [-100, 100] x [-100, 100]

    if (showSnowflake)
    {
        float s = .8f;
        scale(s);
        strokeWeight(pow(3, level)/s);

        // draw 3 transformed copies of snowflake segment

        pushMatrix();
        translate(0, 100*sqrt(3)/3);
        snowflakeSegment(level);
        popMatrix();

        pushMatrix();
        rotate(2*PI/3);
        translate(0, 100*sqrt(3)/3);
        snowflakeSegment(level);
        popMatrix();

        pushMatrix();
        rotate(-2*PI/3);
        translate(0, 100*sqrt(3)/3);
        snowflakeSegment(level);
        popMatrix();
     }
    else // show single snowflake segment
    {
        strokeWeight(pow(3, level));
        snowflakeSegment(level);
    }
}

public void keyPressed()
{
    if (keyCode == UP)
    {
        if (level < 6)
            level++;
    }
    else if (keyCode == DOWN)
    {
        if (level > 0) 
            level--;
    }
    else if (key == 's')
    {
        showSnowflake = !showSnowflake;
    }
}


