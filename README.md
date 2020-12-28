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
|------------:|-----------:|-----------:|--------------:|-------------:|-------------:|----------------:|------------:|
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
  
# 4. Comments and Program Layout
# 5. Type

A _type_ is a set of values and operations on them. A type is either a primitive type or a reference type.

## 5.1. Primitive Types

A _primitive type_ is either `boolean` or one of the _numeric types_ `char`, `byte`, `short`, `int`, `long`, `float`, or `double`.

## 5.2. Reference Types

A _reference type_ is a class type defined by a class declaration(section 9.1),
or an interface type defined by and interface declaration(section 13.1), or and array type(section 5.3), or an enum type(chapter 14).

## 5.3. Array Types

An _array type_ has the form `t[]`, where `t` is any type. An array type `t[]` is a reference type.
Hence a value of array type `t[]` is ether `null` or a reference to an array whose element type is precisely `t`(when `t` is a primitive type),
or is a subtype of `t`(when `t` is a reference type).

## 5.4. Boxing: Wrapping Primitive Types as Reference Types

For every primitive type there is a corresponding wrapper class, which is a reference type.