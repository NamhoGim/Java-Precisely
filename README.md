# Java Precisely
File examples/README.md * Last update 2015-05-03

![](bookcover.jpg)

## Examples from Peter Sestoft: Java Precisely, third edition, MIT Press 2016

These files are from http://www.itu.dk/~sestoft/javaprecisely/

Java Precisely and its example programs come with no warranty of any
kind, either expressed or implied.  In no event shall the author or
the IT University of Copenhagen or the MIT Press be liable for any
damage resulting from its use.

The source code for Example 1 is in file Example1.java, and so on.

Most examples are compiled and ready to run; running them requires
Java Development Kit 8.0 or later.

For instance, to run the program from Example 5, unpack the example
archive and type

   java Example5

Some example programs require additional command line argument; they
will say so if invoked without command line arguments.

The programs Example91.java and Example92.java may be run with option
-ea or -enableassertions like this:

    java -enableassertions Example91
    java -enableassertions Example92

---

# 1. Running Java: Compilation, Loading, and Execution
# 2. Names and Reserved Names

A _legal name_ (of a variable, method, field, parameter, class, interface or package) starts with a letter or dollar sign($)
or underscore(_), and continues with zero or more letters or dollar signs or underscores or digits(0-9).
Avoid dollar signs in class and interface names. Uppercase letters and lowercase letters are considered distinct.
A legal name cannot be one of the following _reserved names_:

| `abstract` | `char`    | `else`    | `for`        | `interface` | `protected` | `switch`       | `try`      |
|------------|-----------|-----------|--------------|-------------|-------------|----------------|------------|
| `assert`   | `class`   | `enum`    | `goto`       | `long`      | `public`    | `synchronized` | `void`     |
| `boolean`  | `const`   | `extends` | `if`         | `native`    | `return`    | `this`         | `volatile` |
| `byte`     | `default` | `final`   | `import`     | `null`      | `static`    | `throw`        |            |
| `case`     | `do`      | `finally` | `instanceof` | `package`   | `strictfp`  | `transient`    |            |
| `catch`    | `double`  | `float`   | `int`        | `private`   | `super`     | `true`         |            |

# 3. Java Naming Convetions

The following naming conventions are often followed, although not enforced by Java.

* If a name is composed of several words, then each word(except possibly the first one)
begins with an uppercase letter. Examples: `setLayout`, `addLayoutComponent`.

* Names of variables, fields, and methods begin with a lowercase letter. Examples: `vehicle`, `myVehicle`.

* Named constance (such as `final static` fields and enum values) are written entirely in uppercase, and the parts of
composite names are separated by underscores(_). Examples: `CENTER`, `MAX_VALUE`.
  
* Package names are sequences of dot-separated lowercase names. Examples: `java.awt.event`.
For uniqueness, they are often prefixed with reverse domain names, as in `com.sun.xml.util`.