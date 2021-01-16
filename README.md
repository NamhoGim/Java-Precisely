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

A _class-declaration_ of class `C` has the form

    class-modifiers class C extends-clause implements-clause
        class-body

A declaration of class `C` introduces a new reference type `C`. The _class body_ may contain declaration of fields,
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

* If a top-level class `C` is declared `public`, then it is accessible also outside its package (chapter 17). 
* If a class `C` is declared `final` one cannot declare subclsses of `C` and hence cannot override any methods declared in `C`.
* If a class `C` is declared `abstract`, then it cannot be instantiated, but non-abstract subclasses of `C` can be instantiated.

## 9.5. Subclasses, Superclasses, Class Hierarchy, Inheritance, and Overriding

A class `C` may be declared a _subclass_ of class `B` by an _extends-clause of the form

    class C extends B { ... }

Class `C` is a subclass and hence a subtype (section 5.5) of `B` and its supertypes. It inherits all methods and fields
(even private ones, although they are not accessible in class `C`), but not the constructors, from `B`.

## 9.6. Field Declarations in Classes

The purpose of a _field_ is to hold a value inside an object (if non-static) or a class (if static). A field must be
declared in a class declaration. A _field-declaration_ has one of the forms

    field-modifiers type fieldname1, fieldname2, ... ;
    field-modifiers type fieldname1 = initializer1, ... ;

The _field-modifiers_ may be a list of the modifiers `static`, `final`, `transient` (section 26.12), and `volatile`,
and at most one of the access modifiers `private`, `protected`, `public` (section 9.7).

If a field `f` in class `C` is declared `static`, then `f` is associated with class `C` and can be referred to independently of any object of class `C`.
A _field initializer_ may be an expression or an array initializer (section 8.2). A static field initializer can refer only to static members of `C`
an can throw no checked exceptions (chapter 15).

Static fields are initialized when the class is loaded. First all static fields are givien default initial values;
then the static initializer blocks (section 9.13) and static field initializers are executed, in order of appearance.

Non-static fields are initialized when a constructor is called, at which time all static fields have been initialized already (section 9.10).

If a class `C` declares a non-static field `f`, and `C` is a sub-class of a class `B` that has a non-static field `f`,
then every object of class `C` has two fields, both called `f`: one is the `B`-field `f` declared in the superclass `B`,
and one is the `C` field `f` declared in `C` itself. What field is referred to by a field access `o.f` is determined by the compile-type type of `o` (section 11.9).

## 9.7. The Member com.precisely.java.example035.Access Modifiers `private`, `protected`, `public`

A member (field, method, nested class, or interface) is always accessible in the class in which it is declared,
except where shadowed by a variable, parameter, or field (of a nested class). The _access modifier_ `private`, `protected`,
and `public` determine where else the member is accessible.

If a member is declared `private` in top-level class `C` or a nested class within `C`, it is accessible on all object instances,
not only `this`, in `C` and its nested classes, but not in their subclasses outside `C` nor in other classes.

If a member in class `C` is declared `protected`, it is accessible in all classes in the same package (chapter 17) as `C`
and on the same object instance (`this`) in subclasses of `C`, but not in non-subclasses in other packages.

If a member in class `C` is not declared `private`, `protected`, or `public`, it has _package access_, or _default access_,
and is accessible only in classes with in the same package as `C`, not in classes in other packages.

If a member in class `C` is declared `public`, it is accessible in all classes, including classes in other packages.
Thus, in order of increasing accessibility, we have `private` access, package (or default) access, `protected` access, and `public` access.

## 9.8. Method Declarations

A _method_ must be declared inside a class. A _method-declaration declaring method `m` has the form

    method-modifiers return type m(formal-list) throws-clause
        method-body

The _formal-list is comma-separated list of zero or more _formal parameter declarations_, of one of the forms
    
    parameter-modifier type parameter-name
    parameter-modifier type... parameter-name

The _parameter-modifier_ may be `final`, meaning that the parameter cannot be modified inside the method, or absent.

The _method-modifiers_ may be `abstract` or a list of `static`, `final`, `synchronized` (section 20.2),
and at most one of the access modifiers `private`, `protected`, or `public` (section 9.7).

If a method `m` in class `C` is declared `final`, it cannot be overridden (redefined) in subclasses.

If a method `m` in class `C` is declared `abstract`, class `C` must itself be abstract(and so cannot  be instantiated).

An `abstract` method cannot be `static`, `final` or `synchronaized`, and its declaration has no method body:

    abstract method-modifiers return-type m(formal-list) throw-clause;

The _throws-clause_ of a method or constructor has the form `throw E1, ..., En`
where `E1, ..., En` are the names of exception types covering all the checked exceptions that the method or constructor may throw.
If execution of the method or constructor body may throw some exception `e`, then `e` must be either an unchecked exception (chapter 15)
or a checked exception whose class is a subtype of one of `E1`, ..., `En`. An `Ei` may be a generic type parameter provided it is constrained (section 21.5) to be subtype of Throwable.

## 9.9. Parameter Arrays and Variable-Arity Methods

The last parameter of a method may be declared to be a _parameter array_, using the syntax

    t... x

where `t` is a type, x is a parameter name, and the three dots ... are part of the concrete syntax.
In the method, parameter `x` will have type `t[]`.

## 9.10. Constructor Declarations

The purpose of a constructor in class `C` is to initialize new objects (instances) of the class. A _constructor-declaration_
in class `C` has the form

    constructor-modifiers C(formal-list) throws-clause
        constructor-body

The _constructor-modifiers_ may be a list of at most one of `private`, `protected`, and `public` (section 9.7);
a constructor cannot be `abstract`, `final`, or `static`. A constructor has no return type.

Constructors may be overloaded in the same way as methods: the _constructor signature_ (a list of the parameter types in _formal-list_)
is used to deistinguish constructors in the same class.
A constructor may call another overloaded constructor in the same class using the syntax:

    this(actual-list)

## 9.11 Nested Classes, Member Classes, Local Classes, and Inner Classes

A non-static nested class, that is, a non-static member class `NMC` or a local class `NLC` in a non-static member,
is called an _inner class_. An object of an inner class always contains a reference to an object of the enclosing class `C`,
called the _enclosing object_. That object can be referred to as `C.this` in non-static code (example 47),
so a non-static member `x` of the enclosing object cna be referred to as `C.this.x`.

An inner class or local class cannot have static members. More precisely, all static fields must also be final,
and methods and nested classes in an inner class or local class must be non-static.

A static nested class, that is, a static member class `SMC` or a local class in a static member, has no enclosing object
and cannot refer to non-static members of the enclosing class `C`.

A static member class may itself have static as well as non-static members.

## 9.12 Anonymous Classes

An _anonymous class_ is a special kind of local class; hence it must be declared inside a method, constructor, or initializer.
An anonymous class can be declared, and exactly one instance created, using the special expresion syntax:

    new C(actual-list)
        class-body

## 9.13 Initializer Blocks, Field Initializers, and Initializers

In addition to field initializers (section 9.6), class may contain _initializer-blocks_.
Initializer blocks may be used when field initializers or constructors do not suffice. We use the term _initializer_ to mean field initializers
as well as initializer blocks. A _static initializer block_ has the form:
    
    static block-statement

# 10. Classes and Object in the Computer

## 10.1 What Is a Class?

Conceptually, a class represents a concept, a template for creating instances(object).
In the computer, a class is a chunk of memory, set aside once, when the class is loaded at run-time.
A class has the following parts:

* The name of the class
* Room for all the static members of the class

## 10.2 What is an Object?

Conceptually, an object is an instance of a concept(a class). In the computer, an object is a chunk of memory,
set aside by an object creation expression `new C(...);` see section 11.7. Every evaluation of an object creation expression
`new C(...)` creates a distinc object, with its own chunk of computer memory. An object has the following parts:

* A reference to the run-time `class C` of the object; this is the class `C` used when creating the object
* Room for all the non-static members of the object

## 10.3 Inner Objects

When `NMC` is an inner class(a non-static membmer class, or a local class in non-static code) in a class `C`,
then an object of class `NMC` is an _inner object_. In addition to the object's class and the non-static fields
an inner object always contains a reference to an _enclosing object_, which is an object of the innermost enclosing class `C`.
The enclosing object reference can be written `C.this` in non-static code in the inner class.
An object of a static nested class `SMC`, on the other hand, contains no reference to an enclosing object.

# 11. Expressions

## 11.13 Lambda Expressions (Java 8.0)

A lambda expression evaluates to a function, a value that implements a functional interface (chapter 23).
A lambda expression has one of these three forms, each having zero or more parameters and a lambda body.

    x -> ebs
    (x1, ... xn) -> ebs
    (formal-list) -> ebs

## 11.14 Method Reference Expressions (Java 8.0)

A method reference expression has one of these six forms, where `t` is a type, `m` a method neam, `e` and expression,
and `C` a class name. Example 67 illustrates all of these:
    
    t::m
    e::m
    super::m
    C::new
    t[]...[] :: new

# 12. Statements
## 12.1. Expression Statements
## 12.2. Block Statements
## 12.3. The Empty Statement
## 12.4. Choice Statements
## 12.5. Loop Statements
## 12.6. Returns, Labeled Statements, Exits, and Exceptions
### 12.6.1 The `return` Statement
### 12.6.2 Labeled Statement
### 12.6.3 The `break` Statement
### 12.6.4 The `continue` Statement
### 12.6.5. The `throw` Statement

A `throw` statement has the form
    
    throw expression;

where the type of the _expression_ must be a subtype of class Throwable (chapter 15).
The `throw` statement is executed as follows: The _expression_ is evaluated to obtain an exception object `v`.
If it is `null`, the a NullPointerException is thrown; otherwise the exception object `v` is thrown.
Thus a thrown exception is never `null`. In any case, the enclosing block statement terminates abruptly (chapter 15).
The thrown exception may be caught by a dynamically enclosing `try-catch` statement (section 12.6.6). If the exception is not caught,
then the entire program execution will be aborted, and information from the exception will be printed on the console.

### 12.6.6. The `try-catch-finally` Statement

A `try-catch` statement is used to catch (particular) execptions thrown by a code block; it has this form:

    try
        body
    catch (E1 x1) catchbody1
    catch (E21 | E22 | ... | E2k) catchbody2
    ...
    finally finallybody

## 12.7. The Try-with-Resources Statement

## 12.8. The `assert` Statement

The `assert` statement has one of the following forms:

    assert boolean-expression ;
    assert boolean-expression : expression ;

# 13. Interfaces

## 13.1 Interface Declarations

An _interface_ describes fields and methods but does not implement them. An _interface-declaration_ may contain field descriptions,
method descriptions, class declarations, and interface declarations, in any order.

    interface-modifier interface I extends-clause {
        field-descriptions
        method-descriptions
        method-declarations
        class-declarations
        interface-declarations
    }

## 13.2 Classes Implementing Interfaces

A class `C` may be declared to implement one or more interfaces by an _implements-clause_:

    class C implements I1, I2, ...
        class-body

In this case, `C` is a subtype (section 5.5) of `I1`, `I2`, and so on, and `C` must declare all the methods described by `I1`, `I2`, ...
with exactly the prescribed signatures and return types. A class may implement any number of interfaces. Fields, classes,
and interfaces declared in `I1`, `I2`,... can be used in class `C`.

## 13.3 Default and Static Methods on Interfaces (Java 8.0)

An interface can declare _default methods_, which must have a body in the form of a block statement.
The method body can refer only to the interface's (abstract, default, or static) methods and (final static) fields, as well as other static methods.
A default methods is inherited by any class that implements the interface or any of its subinterfaces.
Many predefined functional interfaces have default methods; see chapter 23 and example 214.

An interface can declare _static methods_, which have a body in the form of a block statement.
The method body can refer only to other static methods and (final static) fields of the interface.
A static method `m` declared on interface `I` can be called directly on the interface type as `I.m(...)`
and must be called like this also in implementing classes and in subinterfaces; it is not "inherited" by them.

# 14. Enum Types

# 15. Exceptions, Checked and Unchecked

# 16. Compilation, Source Files, Class Names, and Class Files

# 17. Packages and Jar Files

# 18. Mathematical Functions

# 19. String Builders and String Buffers

# 20. Threads, Concurrent Execution, and Synchronization

# 21. Generic Types and Methods

# 22. Generic Collections and Maps

# 23. Functional Interfaces (Java 8.0)

# 24. Streams for Bulk Data (Java 8.0)

# 25. Class Optional<T> (Java 8.0)

# 26. Input and Output

# 27. Reflection

# 28. Metadata Annotations

# 29. What Is New in Java 8.0
