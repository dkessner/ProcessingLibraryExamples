---
title: Setting the Java CLASSPATH
---

# Setting the Java CLASSPATH

The Java compiler (`javac`) and runtime (`java`) use the `CLASSPATH`
environment variable to find external libraries, which are stored in files with
the extension `.jar` (Java archive).  You need to set the `CLASSPATH`
environment variable to point to the Processing libraries.

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
application settings.  If you are running your programs from the command line,
you will want to include the above `export` line in a script (e.g. your
`.profile` or `.bash_profile` file).

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
application settings, though this may be set from the system environment.

### Linux/Unix

Like OSX, you can set `CLASSPATH` on the command line to point to where you
have Processing installed:
```
export CLASSPATH=".:$HOME/path/to/processing_????/core/library/*"
```

If you are using an IDE, you will want to set the `CLASSPATH` in the project or
application settings.  If you are running your programs from the command line,
you will want to include the above `export` line in a script (e.g. your
`.profile` or `.bash_profile` file).




