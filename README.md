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

|  `abstract` |     `char` |    `else` |        `for` | `interface` | `protected` |       `switch` |      `try` |
|------------:|-----------:|----------:|-------------:|------------:|------------:|---------------:|-----------:|
|    `assert` |    `class` |    `enum` |       `goto` |      `long` |    `public` | `synchronized` |     `void` |
|   `boolean` |    `const` | `extends` |         `if` |    `native` |    `return` |         `this` | `volatile` |
|      `byte` |  `default` |   `final` |     `import` |      `null` |    `static` |        `throw` |            |
|      `case` |       `do` | `finally` | `instanceof` |   `package` |  `strictfp` |    `transient` |            |
|     `catch` |   `double` |   `float` |        `int` |   `private` |     `super` |         `true` |            |

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

## 13.4 Annotation Type Declarations

An annotation type `@Anno` is a special kind of interface; its declaration has this form:

    interface-modifiers @interface Anno { annotations-members }

Each _annotations-member_ has one of these forms, where an _annotations-member-expression_ is a constant:

    type f();
    type f() default annotation-member-expression;
    final type f = constant;

Several meta-annotations may be used when declaring an annotations type. Type `@Target({...})`
meta-annotations specifies the legal targets for an annotations type; the default is any target:

| `@Target` Value   | Legal Targets                                                     |
|:------------------|:------------------------------------------------------------------|
| `ANNOTATION_TYPE` | Annotations type declarations                                     |
| `CONSTRUCTOR`     | Constructor declarations                                          |
| `FIELD`           | Field declarations or enum value declarations                     |
| `LOCAL_VARIABLE`  | Local variable declarations                                       |
| `METHOD`          | Method declarations                                               |
| `PACKAGE`         | Package declarations                                              |
| `PARAMETER`       | Parameter declarations in method or constructor                   |
| `TYPE`            | Class, interface, or enum type declarations                       |
| `TYPE_PARAMETER`  | Type parameter of generic class, interface, method or constructor |

The `@Retentions(...)` meta-annotations specifies the retention policy for an annotation type:

| Value     | Meaning                                                                               |
|:----------|:--------------------------------------------------------------------------------------|
| `SOURCE ` | The annotations is discarded by the compiler and will not be stored in the class file |
| `CLASS`   | The annotations is stored in the class-file (default) but unavailable at run-time     |
| `RUNTIME` | The annotations is available for reflective inspections at run-time                   |

# 14. Enum Types

An enum type is used to declare distinct enum values; an enum type is a reference type. An _enum-type-declaration_
is a specialized form of class declaration that begins with a list of enum value declarations:

    enum-modifiers enum t implements-cluse {
        enum-value-list;
        field-declarations
        method-declarations
        method-declarations
        class-declarations
        interface-declarations
        intitializer-blocks
    }

# 15. Exceptions, Checked and Unchecked

An _exception_ is an object of an exception type: a non-generic subclass of Throwable. It is used to signal and describe
and abnormal situation during program execution. The evaluation of an expression or the execution of a statement
may throw an exception, either by executing a `throw` statement (section 12.6.5) or by executing a primitive operation,
such as array element assignment, that may throw an exception.

There are two kinds of exception types: _checked_ (thos that mus be delcared in the _throws-clause_ of a method or 
constructor; see section 9.8) and _unchecked_ (those that not be). If the execution of a method or constructor body
can throw a checked exception of class `E`, then class `E` or a supertype of `E` must be declared in the _throws-clause_
of the method or constructor.

# 16. Compilation, Source Files, Class Names, and Class Files
# 17. Packages and Jar Files
# 18. Mathematical Functions

# 19. String Builders and String Buffers

_String builders_, which are objects of the predefined class java.lang.StringBuilder, provide extensible and modifiable strings.
Characters can be appended to a string builder without copying those characters already in the string builder;
the string builder automatically and efficiently extended as needed. To concatenate _n_ strings each of length _k_ using string builder
requires only time proportional to _kn_, considerably faster than _kn^2_ for large _n_.

A _StringBuffer_ has the same methods as a _StringBuilder_, but is thread safe: several concurrent threads (chapter 20)
can safely modify the same string buffer. Both classes implement the Appendable and CharSequence interfaces (section 26.7).

# 20. Threads, Concurrent Execution, and Synchronization

## 20.1 Treads and Concurrent Execution

### States and State Transitions of a Thread

A thread is alive if it has been started and has not died. A thread dies by existing its `run()` method,
either by returning or by throwing an exception. A live thread is in one of the states Enabled (ready to run),
Running (actually executing), Sleeping (waiting for a timeout), Joining (waiting for another thread to die),
Locking (trying to obtain the lock on object `o`), or Waiting (for notification on object `o`).
The thread state transition are shown in the following table and figure.

| From State | To State                                                                            | Reason for Transition                                                                                                                                                                                                                                                                                                                 |
|:-----------|:------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Enabled    | Running                                                                             | System schedules thread for execution                                                                                                                                                                                                                                                                                                 |
| Running    | Enabled<br/> Enabled<br/> Waiting<br/> Locking<br/> Sleeping<br/> Joining<br/> Dead | System preempts thread and schedules another one<br/> Thread executes `yield()`<br/> Thread executes `o.waits()`, releasing lock on `o`<br/> Thead attempts to executes `synchronized (o) { ... }`<br/> Thread executes `sleep()`<br/> Thread executes `u.join()`<br/> Thread exited `run()` by returning or by throwing an exception |
| Sleeping   | Enabled<br/> Enabled                                                                | Sleeping period expired<br/> Thread was interrupted; throws InterruptedException when run                                                                                                                                                                                                                                             |
| Joining    | Enabled<br/> Enabled                                                                | Thread `u` being joined died, or join timed out<br/>  Thread was interrupted; throws InterruptedException when run                                                                                                                                                                                                                    |
| Waiting    | Locking<br/> Locking<br/> Locking                                                   | Another thread executed `o.notify()` or `o.notifyAll()`<br/> Wait for lock on `o` timed out<br/> Thread was interrupted; throws InterruptedException when run                                                                                                                                                                         |
| Locking    | Enabled                                                                             | Lock on `o` became available and was given to this thread                                                                                                                                                                                                                                                                             |


# 21. Generic Types and Methods

Generic types and methods provide away to strengthen type checking at compile-time while at the same time making programs more expressive,
reusable and readable. The ability to have generic types and methods is also known as _parametric polymorphism._

## 21.2 Generic Types, Type Prameters, and Type Instances

A _generic class_ declarations `class C<T1, ..., Tn> { ... }` has one more _type parameters_ `T1, ..., Tn`.
Type body of the delcaration is an ordinary class body (section 9.1)
in which the type parameter `Ti` can be used almost as if they were ordinary types; see section 21.6.
A generic class is also called _parameterized class_.
The resulting classes are called _type instances._

Generic interfaces (section 21.7) can be declared also, and type instances can be created from them.
Again, a generic interface is not an interface, but a type instance of a generic interface is an interface.

Generic method (section 21.8) can be declared by specifying type parameters on the method declaration
in addition to any type parameters specified on the enclosing class or interface type.

## 21.3 How Can Type Instance Be Used?

A type instance such as `C<Integer>` can be used almost anywhere an ordinary reference type can be used:
as type of a field, variable, parameter or return type; as the element type in an array type in the same contexts;
as a constructor name `new C<T>(...);` and so on. However, there are the following restrictions:

* One can use a type instance in cast expression such as `(C<Integer>)e` but such a cast is sometimes reported by the complier to be unchecked (see section 21.6).
* One cannot use a type instance in an instance test expression such as `(e instanceof C<Integer>)`
* One cannot use a type instance as the element type of an array in an array creation expression such as `new C<Integer>[8]`. But `new ArrayList<C<Integer>>()` is legal; see section 21.11

## 21.4 Generic Classes

A delcaration of a _generic class_ `C<T1,...,Tn>` may have this form:

    class-modifiers class C<T1,...,Tn> class-base-clause
        class body

The `T1, ..., Tn` are _type parameters._ The _class-modifiers_, _class-body_, and _class-base_ are as for a non-generic class declaration (section 9.1).

The type parameters `T1, ..., Tn` may be used whereber a type is expected in the _class-base-clause_ and in non-static members of the _class-body_, and so may the type parameters of any enclosing generic class, if the parsent class is a non-static member class.

All type instnaces of a generic class `C<T1,...Tn>` are represented by the same _raw type_ `C`
at run-time. All type instance of a generic class `C<T1,...Tn>` share the same static fields (if any) declared in _class-body_.
As a consequence, the type parameters of the class cannot be used in any static members.

An object instance of a type instance `C<t1, ..., tn>` of a generic class is created using the `new` operator to invoke a constructor of the type instance, as in `new C<t1, ..., tn>()` for and argument-less constructor.
If the type arguments `t1,...,tn` can be inferred from the context, the argument list may be left empty as a "diamond" <> as in `new C<>()`.

## 21.5 Constraints on Type Parameters

## 21.6 How Can Type Parameters Be Used?

Within the body `{ ... }` of a genric class `class C<T1,...,Tn> { ... }` or generic interface, a type parameter `Ti` may be used almost as if it were a public type.

* One can use type parameter `Ti` as a type argument in the supertype and in the implemented interfaces of the generic class or generic interface (but `Ti` itself cannot be used as superclass or implemented interface.)

* One can use type paramter `Ti` in the return type, variable type, parameter types, and `throws` clauses of non-static methods and their local inner classes, as well as in the type and initializer of non-static fields and non-static constructors. In these contexts, `Ti` can be used in type instances `C1<...,Ti,...>` of generic types. `C1`.

* One can use type parameter `Ti` for the same purposes in non-static member classes, but not in static member classes nor in member interface.

* One can use `(Ti)e` for type casts, but such casts are sometimes reported by the compiler to be unchecked. This is due to java's implementation of generic types; see section 21.11 and examples 123 and 131.

* One cannot use `new Ti[10]` to create a new array whose element type is `Ti` (see example 132); one cannot use `(o instanceof Ti)` to test whether `o` is an instance of `Ti`; one cannot use `Ti.class` to obtain the canonical object representing tye type `Ti`; one cannont use `new Ti()` to create an instance of `Ti`; and one cannot call static methods on a type parameter `Ti`, as in `Ti.m()`, or otherwise refer to the static members of a type parameter. Again, this is due to Java's implementation of generic types; see sections 21.11.

## 21.7 Generic Interfaces

A declaration of a _generic interface_ `I<T1, ... ,Tn>` has this form:

    interface-modifiers interface I<T1,...,Tn> extends-clause
        interface-body

A type instance of the generic interface has form `I<t1,...tn>` where the `t1...tn` are types.
The types `t1...tn` must satisfy the parameter constraints,
if any, on the generic interface `I<T1,...Tn>` as described in section 21.5.

A generic interface is a subinterface of the interface mentioned in its _extends-clause_.
Like a generic class, a generic interface is not covariant in its parameters. That is, `I<String>` is not a subtype of `I<Object>`,
although String is a subtype of Object.

## 21.8 Generic Methods

A generic method is a method that takes one or more type parameters.
A generic method may be declared inside a generic or non-generic class of interface.
A declaration of a generic method `m<T1,...Tn>` has this form:

    method-modifiers `m<T1,...Tn>` returntype m(formal-list)
        method-body

The main syntactic difference is that a generic method has a list of type parameters `T1,...Tn` before its _returntype_.

The type parameters `T1,...,Tn` may be used as types in the _returntype_, _formal-list_, and _method-body_, as may the type parameters of any enclosing generic class if the method is non-static.

Generic methods of the same name `m` are not distinguished by their number of generic parameters, and a generic method is not distinguished from a non-generic method of the same name.
For example, these three methods

    void m() { ... }    
    <T> void m() { ... }
    <T,U> void m() { .... }

are considered distinct, and at most one of them can be declared in a given scope.

## 21.9 Wildcard Type Arguments

A _wildcard type is a type expression that denotes some unknown type. A wildcard type can be used only as a type argumentin a generic type instance,
as in `Shop<?>` where `Shop<T>` is a generic type from example 130; a wildcard cannot be used as a type on its own. A wildcard type is useful when one must
give a type argument in a generic type or method but does want to specify the exact type. There are three forms of wildcard types:

    <?>
    <? extends tb>
    <? super tb>

The first form of wildcard represents some unknown type; the second form represents some unknown type that is `tb` or a subtype of `tb`;
and the third form represents some unknown type that is `tb` or a supertype of `tb`.

examples...

In general, wildcard type `<? extends tb>` is useful as type argument when a value of a generic type must be usable as a _producer_ of objects of type `tb`.
Conversely, the wildcard type `<? super tb>` is useful as a type argument when a value of a generic type must be usable as a consumer of object of type `tb`.

## 21.10 The Raw Type

For every generic type there is an underlying _raw type_.

For a generic `C<T1,...,Tn>` the raw type is a non-generic class `C` that is a supertype of all type
instances `C<t1,...,tn>` of the generic class `C<T1,...,Tn>`.

For a generic interface `I<T1,...Tn>` the raw type is an interface `I` is a superinterface of all type instances `I<t1,...,tn>` of the generic interface `I<T1,...Tn>`.

The raw type `C` is derived from the generic class declaration by _erasure_ as follows:

* If `Ti` is a type parameter of `C<T1,...Tn>` without a constraint, then any use of `Ti` in the body of class `C` is replaced by Object.

* If `Ti` is a type parameter of `C<T1,...,Tn>` with constraints `c1 & c2 & ... & cn`, then any use of `Ti` in the boyd of class `C` is replaced by `c1`.\
For this reason one sometimes sees constraints of the form `Ti extends Object & c2 & ... & cn` that begin with an apprently superfluous occurence of Object.

## 21.11 The Implementation of Generic Types and Methods

Generic types and method in Java resemble C++ type templates and function templates, as well as generic
Types and methods in the C# programming language. However, generic types and method in Java have been
designed to allow programs that use genericss to run on the same non-generic Java Virtual Machine as
older Java programs. This design has several implications:

* Only reference types, not primititve types, can be used as generic type arguments. Thus a type parameter `T` must be instantiated with type `Integer`, not type `int`, and `int` values must be wrapped as `Integer` objects. This so-called boxed representation carries a certain overhead in execution time and space because `Integer` object must be allocated on the heap to wrap `int` values, extra memory accesses are needed, and the `int` values must be unboxed before performing arithmetic or comparison.

* There is a single type in the run-time system common to all the type instances `C<t1,...tn>` of a genric type `C<T1,...Tn>`, namely the raw type C. In particular, all object instance of all type instances have the same field layout and contain the same bytecode instructions.\
\
Thus at rum-time, the type instances `Pair<String,Integer>` and `Pair<Date,String>` in example 118 are actually represented by the same raw type Pair with fields of type Object. This loses some optimization opportunities that exist for C++ templates and for C# generics type and methods.\
\
On the other hand, the existence of the raw type makes it easy for new Java generic types to interoperate with legacy non-generic types; this is more difficult in C# programs.

* Overloading resolution of a method `m` or constructor does not take type arguments in `m`'s parameter types into account and does not distinguish generic and raw types in `m`'s parameter types.
For example, these three methods are not considered distinct, and at most one of them can be declared in a given scope:

    void m(List xs) { ... }
    void m(List<Integer> xs) { ... }
    void m(List<String> xs) { ... }

* At rum-time there is no information about the actual type arguments of a genric type or method. So type parameter can be used only to limited extent in reflection and not at all in `instanceof` test.

# 22. Generic Collections and Maps

The Java class library package `java.util` provides collection classes and map (or dictionary) classes:

* A _collection_, decribed by generic interface `Collection<T>` (section 22.1), is used to group and handle may distict _elements_ of type T as a whole.

* A _list_, described by generic interface `List<T>` (section 22.2), is a collection whose elements can be traversed in insertion order.
Implemented by the generic classes `LinkedList<T>` (for linked lists, double-ended queues, and stacks) and `ArrayList<T>` (for dynamicaly extensible arrays and stacks).

* A _set_, described by generic interface `Set<T>` (section 22.3), is a collection that cannot contain duplicate elements. Implemented by the generic classes `HashSet<T>` and `LinkedHashSet<T>`.\
\
A _sorted set_, described by generic interface `SortedSet<T>` (section 22.4), is a set whose elements are orderd: either the elements implements method `compareTo` specified by interface `Comparable<T>`,
or the set's ordering is given explicitly by an object of type `Comparator<T>` (section 22.9). Implemented by generic class `TreeSet<T>`.

* A _map_, described by generic interface `Map<K,V>` (section 22.5), represents a mapping from a key of type `K` to at moset one value of type `V` for each key. Impelemented by the generic classes `HashMap<K,V>`,
`IdnetityHashMap<K,V>`, and `LinkedHashMap<K,V>`.\
\
A _sorted map_, described by generic interface `SortedMap<K,V>` (section 22.6), is a map whose key are ordered, as for `SortedSet<K>`. Implemented by class `TreeMap<K,V>`.

# 23. Functional Interfaces (Java 8.0)

# 24. Streams for Bulk Data (Java 8.0)

# 25. Class Optional<T> (Java 8.0)

# 26. Input and Output

# 27. Reflection

# 28. Metadata Annotations

# 29. What Is New in Java 8.0
