# From Java 17 to Java 18
This kata will help you to discover and experiment new features appeared in Java 18.

You will have to follow the FIXME present into the code which show you where you can use Java 18 new features.

All the new features and other things related to Java 18 can be found [here](https://jdk.java.net/18/)

## What do I need for this kata ?
* Git to check out this code
* Maven for dependencies
* Java 18 of course (look here for new release [OpenJDK](https://jdk.java.net/18/))
* An up-to-date IDE for easier life (the 2022 EAP release of [IntelliJ](https://www.jetbrains.com/idea/nextversion) works perfectly for example)

Some new features in Java 18 you will have to play with :

## Pattern matching for switch (second preview)
Reference : [JEP 420](https://openjdk.java.net/jeps/420)

It's not yet stable but it has been improved since Java 17.

## Simple web server
Reference : [JEP 408](https://openjdk.java.net/jeps/408)

As many other languages, Java has now its own web server for simple purposes.

It even has its own binary for an easier use :
```shell
$ ./jwebserver 
Binding to loopback by default. For all interfaces use "-b 0.0.0.0" or "-b ::".
Serving /current/directory and subdirectories on 127.0.0.1 port 8000
URL http://127.0.0.1:8000/
```

You can also precise the port to bind :
```shell
$ ./jwebserver -p 8888
Binding to loopback by default. For all interfaces use "-b 0.0.0.0" or "-b ::".
Serving /current/directory and subdirectories on 127.0.0.1 port 8888
URL http://127.0.0.1:8888/
```

It's also possible to give the binding address to avoid only listening on local host. It supports both IPv4 and IPv6 :
```shell
$ jwebserver -b 0.0.0.0
Serving /current/directory and subdirectories on 0.0.0.0 (all interfaces) port 8000
URL: http://123.456.7.891:8000/
```

You can also precise the folder you want to share with the _-d_ option.

All the options are displayed in the help section :
```shell
$ ./jwebserver -h
Usage: jwebserver [-b bind address] [-p port] [-d directory]
[-o none|info|verbose] [-h to show options]
[-version to show version information]
Options:
-b, --bind-address    - Address to bind to. Default: 127.0.0.1 (loopback).
For all interfaces use "-b 0.0.0.0" or "-b ::".
-d, --directory       - Directory to serve. Default: current directory.
-o, --output          - Output format. none|info|verbose. Default: info.
-p, --port            - Port to listen on. Default: 8000.
-h, -?, --help        - Prints this help message and exits.
-version, --version   - Prints version information and exits.
To stop the server, press Ctrl + C.
```

There is also an API to control this simple web server. Have a look into the documentation or by looking at the SimpleWebServerTest class.

## Deprecate Finalization for Removal
Reference : [JEP 421](https://openjdk.java.net/jeps/421)

The _finally_ block was not a so great idea and is now deprecated with Java 18.

It's proposed to use instead :
* The try-with-resources from Java 7
* The [cleaners](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/ref/Cleaner.html) introduced with Java 9

## Vector API (Third Incubator)
Reference : [JEP 417](https://openjdk.java.net/jeps/417)

On modern processor, you have vector instructions which can really accelerate some scalar calculations.

You can find an example in this code base which is directly issued from the official documentation.

You will have to play with the Java modules to play with and test this future feature.

Under GNU/Linux systems, you can determine if your CPU supports AVX instructions by typing _lscpu_ command.


## Last words
As you understand, you will have to enable preview features in your IDE and the POM file to play with all the new things brought by Java 18.

Enjoy !
