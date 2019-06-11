---
title: Processing Library Examples
---

This is a set of short Java code examples that use the Processing libraries.

These examples may be useful to computer science educators who are teaching a
course with the Java language (e.g. AP Computer Science A).  Processing
provides an easy entry point to computer graphics programming.  The Processing
libraries are open source and can be used directly from Java programs.

Computer graphics applications are a natural place to use object oriented
programming techniques.  In addition, concepts such as 2D arrays and recursion
can be illustrated nicely with computer graphics.


## Install Processing

First, download Processing and install it:
[https://processing.org/](https://processing.org/)

_Pay attention to where you install it!_


## Java CLASSPATH

This is the most important part, and the biggest headache.  The Java compiler
(`javac`) and runtime (`java`) use the `CLASSPATH` environment variable to find
external libraries, which are stored in files with the extension `.jar` (Java
archive).  You need to set the `CLASSPATH` environment variable to point to the
Processing libraries.

### OSX (Mac)

After you extract the Processing application, you should drag it to the
Applications folder in Finder.

The path to the folder with the Processing libraries (`.jar` files) will then be:
```
/Applications/Processing.app/Contents/Java/core/library
```

You can set the `CLASSPATH` on the command line.  You can put the current
directory (`.`) in the `CLASSPATH` ahead of everything else, so your local
classes are found first.
```
export CLASSPATH=".:/Applications/Processing.app/Contents/Java/core/library/*"
```

If you are using an IDE, you will want to set the `CLASSPATH` in the project or
application settings.

### Windows

After you extract the Processing application, find the extracted folder.  If
it's in your Downloads directory, you might want to drag it to the Desktop or a
folder where your other applications are located.

The path to the folder with the Processing libraries (`.jar` files) will then
be something like: 
```
C:\Users\YourName\Desktop\processing_????\core\library
```

You want to edit the Environment Variables in the Control Panel.  You can create a new
variable named `CLASSPATH` with a value of something like:
```
.;%UserProfile%\Desktop\processing_????\core\library
```

Note: `%UserProfile%` is an environment variable set to your home directory
(`C:\Users\YourName`).  Also, on Windows, paths are delimited by semi-colons
(`;`) and the path separator is a backslash (`\`).

If you are using an IDE, you will want to set the `CLASSPATH` in the project or
application settings.

### Linux/Unix

Like OSX, you can set `CLASSPATH` on the command line to point to where you
have Processing installed:
```
export CLASSPATH=".:$HOME/path/to/processing_????/core/library/*"
```



## Processing and the `PApplet` class

Processing embeds everything into a Java class.

[HelloProcessing.java](HelloProcessing.java)

## Using external classes

You need to give other classes a reference to the `PApplet` class.  

[HelloProcessing2.java](HelloProcessing2.java)  
[Ball.java](Ball.java)


## Applications

Graphics programming is a natural place to use object oriented programming
techniques, e.g. the `Ball` class in the `HelloProcessing2` example.

__2D array application: image processing__

[ImageProcessing.java](ImageProcessing.java)

__Recursion application: fractals__

[Snowflake.java](Snowflake.java)


## More info

These code examples are licensed under the [GPL v2.0](license), which means you are free
to copy and use the code, but if you distribute a modified program, you must
also distribute your code.   

You can download all the code examples from the Github repository:  
[https://github.com/dkessner/ProcessingLibraryExamples](https://github.com/dkessner/ProcessingLibraryExamples)

Dr. Darren Kessner  
[Darren.Kessner@marlborough.org](mailto:Darren.Kessner@marlborough.org)  
[STEM+ Program](http://stem.marlborough.org)  
[Marlborough School, Los Angeles](http://marlborough.org)  


