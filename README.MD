Sample code for training support
================================

### Pre-requisites:

This code was tested on Debian GNU/Linux Jessie. It should run on other platforms if you use the applications with the
same versions as below. A UNIX-like working terminal environment is recommended.

* git >= 2.0
* maven >= 3.0.5
* Java JDK >= 7 (OpenJDK-7)

### Structure

The following trainings are available:

* Dependency injection - DI with Spring Framework, samples with CDI
* Java Persistence - with JPA
* OSGi - introduction to OSGi and modularity
* Apache Camel - integration with Apache Camel

### Building and running

Download the code:
```
    $ git clone https://github.com/ieugen/trainings trainings
```

Build it:
```
    cd trainings
    mvn clean install
```

Run it using maven exec plugin:

To run Main classes you can use the [Maven Exec plugin](http://mojo.codehaus.org/exec-maven-plugin/usage.html)
```
    mvn exec:java -Dexec.mainClass="com.example.Main" [-Dexec.args="argument1"]
```




