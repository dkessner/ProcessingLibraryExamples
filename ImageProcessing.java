/*
    ImageProcessing.java

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


// This example demonstrates the use of Processing's PImage class to load an
// image and access the pixel data.  It also illustrates a natural use of 2D
// array iteration to create image filters.


import processing.core.*;


public class ImageProcessing extends PApplet
{
    public void settings()
    {
        size(600, 400);
    }

    public void setup()
    {
        processImage();
    }

    public void draw()
    {
        background(0);

        if (img != null)
            image(img, 0, 0);

        fill((red || green || blue) ? 0 : 255);
        textAlign(CENTER);
        text("R/G/B: toggle channel", 300, 370);
        text("M: mirror", 300, 390);
    }

    public void processImage()
    {
        // load image

        img = loadImage("izzi.jpg");

        if (img == null)
        {
            System.out.println("Failed to load image.");
            return;
        }

        // apply filters

        img.loadPixels();
        int[][] pixels2D = create2DArray(img.pixels, img.width, img.height);

        if (!red)
            removeRed(pixels2D);

        if (!green)
            removeGreen(pixels2D);

        if (!blue)
            removeBlue(pixels2D);

        if (mirror)
            reflect(pixels2D);

        copyPixelsFrom2DArray(pixels2D, img.pixels);
        img.updatePixels();
    }

    public void keyPressed()
    {
        if (key == 'r')
        {
            red = !red;
            processImage();
        }
        else if (key == 'g')
        {
            green = !green;
            processImage();
        }
        else if (key == 'b')
        {
            blue = !blue;
            processImage();
        }
        else if (key == 'm')
        {
            mirror = !mirror;
            processImage();
        }
    }

    public static void main(String[] args)
    {
        PApplet.main("ImageProcessing");
    }

    // image filters

    private void removeRed(int[][] pixels)
    {
        for (int i=0; i<height; i++)
        {
            for (int j=0; j<width; j++)
            {
                pixels[i][j] &= 0x00ffff;
            }
        }
    }

    private void removeGreen(int[][] pixels)
    {
        for (int i=0; i<height; i++)
        {
            for (int j=0; j<width; j++)
            {
                pixels[i][j] &= 0xff00ff;
            }
        }
    }

    private void removeBlue(int[][] pixels)
    {
        for (int i=0; i<height; i++)
        {
            for (int j=0; j<width; j++)
            {
                pixels[i][j] &= 0xffff00;
            }
        }
    }

    private void reflect(int[][] pixels)
    {
        for (int i=0; i<height; i++)
        {
            for (int j=width/2; j<width; j++)
            {
                pixels[i][j] = pixels[i][width-j-1];
            }
        }
    }

    // reference to image object

    private PImage img;

    // flags for filters

    private boolean red = true;
    private boolean blue = true;
    private boolean green = true;
    private boolean mirror = false;

    // helper functions to translate between PImage's 1-D pixel array
    // and a more natural 2-D array

    private static int[][] create2DArray(int[] pixels, int width, int height)
    {
        int[][] result = new int[height][width];

        for (int i=0; i<height; i++)
        {
            for (int j=0; j<width; j++)
            {
                result[i][j] = pixels[i*width + j];
            }
        }

        return result;
    }

    private static void copyPixelsFrom2DArray(int[][] pixels2D, int[] pixels)
    {
        int height = pixels2D.length;                  // note: hides PApplet::height
        int width = height>0 ? pixels2D[0].length : 0; // note: hides PApplet::width

        for (int i=0; i<height; i++)
        {
            for (int j=0; j<width; j++)
            {
                pixels[i*width + j] = pixels2D[i][j];
            }
        }
    }
}


