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

## 5.5. Subtypes and compatibility

A type `t1` may be a _subtype_ of a type `t2`, in which case `t2` is a _supertype_ of `t1`.
The following rules determine when a type `t1` is a subtype of a type `t2`:

* Every type is a subtype of itself.
* If `t1` is a subtype of `t2`, and `t2` is a subtype of `t3`, then `t1` is a subtype of `t3`.
* if `t1` and `t2` are primitive types, and there is widening (W or L) conversion from `t1` to `t2` according to the table apposite, then `t1` is a subtype of `t2`.
* If `t1` and `t2` are classes, then `t1` is a subtype of `t2` if `t1` is subclass of `t2`.
* If `t1` and `t2` are interfaces, then `t1` is a subtype of `t2` if `t1` is a subinterface of `t2`.
* If `t1` is a class and `t2` is an interface, then `t1` is a subtype of `t2` provided that `t1` (is subclass of a class that) implements `t2` or implements a subinterface of `t2`.
* Array type `t1[]` is a subtype of array type `t2[]` if reference type `t1` is a subtype of reference type `t2`.
* Any reference type `t`, including any array type, is also a subtype of predefined _class_ Object.

## 5.6. Signatures and Subsumption

## 5.7. Type Conversion

A _type conversion_ converts a value from on type to another. A _widening_ conversion converts from a type to a supertype (or the type itself).
A _narrowing_ conversion converts from a type to another type. A narrowing conversion requires an explicit _type cast_ (section 11.11),
except in an assignment `x = e` or initialization where `e` is a compile-time integer constants (section 11.5).

# 6. Variables, Parameters, Fields, and Scope

A _variable_ is declared inside a method, constructor, initializer block, or block statement (section 12.2).
The variable can be used only in that block statement (or method or constructor or initializer block), and only after its declaration.

A _parameter_ is a special kind of variable: it is declared in the parameter list of a method or constructor,
and is given a value when the method or constructor is called. The parameter can be used only in that method or constructor.

A _field_ is declared inside a class, but not inside a method or constructor or initializer block of the class.
It can be used anywhere in the class, also textually before its declaration.

## 6.1 Values Bound to Variables, Parameters, or Fields

## 6.2 Variable Declarations

The purpose of a variable is to hold a value during the execution of a block statement (or method or constructor or initializer block).
A _variable-declaration_ has one of the forms

    variable-modifier type varname1, varname2, ... ;
    variable-modifier type varname1 = initializer, ... ;

# 7. Strings

A _string_ is an object of the predefined class String. It is immutable: one created it cannot be changed.

# 8. Arrays

An _array_ is an indexed collection of variables, called _elements_. An array has a given _length l ≥ 0_ and a given _element type t_.
The elements are indexed by the integers _0, 1, ..., l-1_. The value of an expression of array type `u[]` is ether `null`
or a reference to an array whose element type `t` is a subtype of `u`. If `u` is a primitive type, then `t` must equal `u`.

## 8.1. Array Creation and Access

A new array of length _l_ with element type `t` is created (allocated) using an _array creation expression_:

```
new t[l]
```

## 8.2. Array Initializers

A variable or field of array type may be initialized at declaration, using an existing array or an _array initailizer_
for the initial value. An array initializer is a comma-separated list of zero or more expression enclosed in braces `{ ... }`:


    t[] x = { expression, ..., expression };


The type of each _expression_ must be a subtype of `t`. Evaluation of the initializer causes a distinct new array,
whose length equals the number of expressions, to be allocated.

Array initializer may also be used in connection with array creation expressions:


    new t[] { expression, ..., expression }


## 8.3. Multidimensional Arrays

## 8.4. The Utility Class Arrays

# 9. Classes

## 9.1. Class Declarations and Class Bodies

A _class-declaration_ of class `com.precisely.java.example033.C` has the form

    class-modifiers class com.precisely.java.example033.C extends-clause implements-clause
        class-body

A declaration of class `com.precisely.java.example033.C` introduces a new reference type `com.precisely.java.example033.C`. The _class body_ may contain declaration of fields,
constructors, methods, nested classes, nested interfaces, and initializer blocks.
A class declaration may take type parameters and be generic; see section 21.4. The declarations in a class may appear in any order:

    {
        field-declarations
        constructor-declarations
        method-declarations 
        class-declarations
        interface-declarations
        enum-type-declaration
        intiializer-blocks
    }

A field, method, nested class, nested interface, or nested enum type is called a _member_ of the class. A member may be declared `static`.
A non-static member is also called an _instance member_.

## 9.2. Top-Level Classes, Nested Classes, Member Classes, and Local Classes

A _top-level class_ is a class declared outside any other class or interface declaration.
A _nested class_ is a class declared inside another class or interface. There are two kinds of nested classes:
a _local class_ is declared inside a method, constructor, or initializer block; a _member class_ is not.
A non-static member class, or a local class in a non-static member, is called an _inner class_,
because an object of the inner class will contain a reference to an object of the enclosing class. See also section 9.11.

## 9.3. Class Modifiers

For a **top-level class**, the _class-modifiers_ may be a list of `public` and at most one of `abstract` or `final`.
For a **member class**, they may be a list of `static`, at most one of `abstract` or `final`, and at most one of `private`
`protected`, or `public`. For a **local class**, they may be at most one of `abstract` or `final`.

## 9.4. The Class Modifiers `pulbic`, `final`, `abstract`

* If a top-level class `com.precisely.java.example033.C` is declared `public`, then it is accessible also outside its package (chapter 17). 
* If a class `com.precisely.java.example033.C` is declared `final` one cannot declare subclsses of `com.precisely.java.example033.C` and hence cannot override any methods declared in `com.precisely.java.example033.C`.
* If a class `com.precisely.java.example033.C` is declared `abstract`, then it cannot be instantiated, but non-abstract subclasses of `com.precisely.java.example033.C` can be instantiated.

## 9.5. Subclasses, Superclasses, Class Hierarchy, Inheritance, and Overriding

A class `com.precisely.java.example033.C` may be declared a _subclass_ of class `com.precisely.java.example033.B` by an _extends-clause of the form

    class com.precisely.java.example033.C extends com.precisely.java.example033.B { ... }

Class `com.precisely.java.example033.C` is a subclass and hence a subtype (section 5.5) of `com.precisely.java.example033.B` and its supertypes. It inherits all methods and fields
(even private ones, although they are not accessible in class `com.precisely.java.example033.C`), but not the constructors, from `com.precisely.java.example033.B`.

## 9.6. Field Declarations in Classes

The purpose of a _field_ is to hold a value inside an object (if non-static) or a class (if static). A field must be
declared in a class declaration. A _field-declaration_ has one of the forms

    field-modifiers type fieldname1, fieldname2, ... ;
    field-modifiers type fieldname1 = initializer1, ... ;

The _field-modifiers_ may be a list of the modifiers `static`, `final`, `transient` (section 26.12), and `volatile`,
and at most one of the access modifiers `private`, `protected`, `public` (section 9.7).

If a field `f` in class `com.precisely.java.example033.C` is declared `static`, then `f` is associated with class `com.precisely.java.example033.C` and can be referred to independently of any object of class `com.precisely.java.example033.C`.
A _field initializer_ may be an expression or an array initializer (section 8.2). A static field initializer can refer only to static members of `com.precisely.java.example033.C`
an can throw no checked exceptions (chapter 15).

Static fields are initialized when the class is loaded. First all static fields are givien default initial values;
then the static initializer blocks (section 9.13) and static field initializers are executed, in order of appearance.

Non-static fields are initialized when a constructor is called, at which time all static fields have been initialized already (section 9.10).

If a class `com.precisely.java.example033.C` declares a non-static field `f`, and `com.precisely.java.example033.C` is a sub-class of a class `com.precisely.java.example033.B` that has a non-static field `f`,
then every object of class `com.precisely.java.example033.C` has two fields, both called `f`: one is the `com.precisely.java.example033.B`-field `f` declared in the superclass `com.precisely.java.example033.B`,
and one is the `com.precisely.java.example033.C` field `f` declared in `com.precisely.java.example033.C` itself. What field is referred to by a field access `o.f` is determined by the compile-type type of `o` (section 11.9).

## 9.7. The Member com.precisely.java.example035.Access Modifiers `private`, `protected`, `public`

A member (field, method, nested class, or interface) is always accessible in the class in which it is declared,
except where shadowed by a variable, parameter, or field (of a nested class). The _access modifier_ `private`, `protected`,
and `public` determine where else the member is accessible.

If a member is declared `private` in top-level class `com.precisely.java.example033.C` or a nested class within `com.precisely.java.example033.C`, it is accessible on all object instances,
not only `this`, in `com.precisely.java.example033.C` and its nested classes, but not in their subclasses outside `com.precisely.java.example033.C` nor in other classes.

If a member in class `com.precisely.java.example033.C` is declared `protected`, it is accessible in all classes in the same package (chapter 17) as `com.precisely.java.example033.C`
and on the same object instance (`this`) in subclasses of `com.precisely.java.example033.C`, but not in non-subclasses in other packages.

If a member in class `com.precisely.java.example033.C` is not declared `private`, `protected`, or `public`, it has _package access_, or _default access_,
and is accessible only in classes with in the same package as `com.precisely.java.example033.C`, not in classes in other packages.

If a member in class `com.precisely.java.example033.C` is declared `public`, it is accessible in all classes, including classes in other packages.
Thus, in order of increasing accessibility, we have `private` access, package (or default) access, `protected` access, and `public` access.

## 9.8. Method Declarations

## 9.9. Parameter Arrays and Variable-Arity Methods

## 9.10. Constructor Declarations

## 9.11 Nested Classes, Member Classes, Local Classes, and Inner Classes

## 9.12 Anonymous Classes

## 9.13 Initializer Blocks, Field Initializers, and Initializers
