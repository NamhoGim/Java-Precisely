// Example 96 from page 69 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.lang.annotation.*;                         // Annotation

import static java.lang.annotation.ElementType.*;      // @Target arguments
import static java.lang.annotation.RetentionPolicy.*;  // @Retention arguments

import java.lang.reflect.*;                            // Method

// Annotation arguments are evaluated at compiletime; they must be
// constant expressions of a limited repertoire of types.

// Annotation objects are constructed at compile-time, and may either
// be discarded after that, or retained in the class file, or retained
// at run-time.

@Target({TYPE, METHOD})     // Attribute can be used on types and methods only
@Retention(RUNTIME)         // Attribute values are kept until run-time
@Repeatable(Authors.class)
        // Attribute may be repeated, as a shorthand for @Authors(...)
@interface Author {
    int oneHour = 60 * 60 * 1000;

    String name();

    Month month();

    String[] diet() default {"Coffee", "Cola", "Mars bars"};

    int weeklyWork() default 56 * oneHour;
}

@Target({TYPE, METHOD})     // Attribute can be used on types and methods only
@Retention(RUNTIME)
        // Attribute values are kept until run-time
@interface Authors {
    Author[] value();
}

class Example96 {
    @Author(name = "Peter", month = Month.NOV, diet = {"Dr. Pepper"})
    public void myMethod1() {
    }

    @Author(name = "Jens", month = Month.JUL)
    public void myMethod2() {
    }

    @Author(name = "Ulrik", month = Month.JUL)
    @Author(name = "Andrzej", month = Month.AUG, diet = {"Tea"})
    // Alternative, with the same meaning:
    // @Authors({@Author(name="Ulrik", month=Month.JUL),
    //           @Author(name="Andrzej", month=Month.AUG, diet = { "Tea" })})
    public void myMethod3() {
    }

    public static void main(String[] args) {
        Class ty = Example96.class;
        for (Method mif : ty.getMethods()) {
            if (mif.getName().startsWith("myMethod")) {
                System.out.println("\nGetting the annotations of " + mif.getName());
                // This finds only annotations with RUNTIME retention
                Annotation[] annos = mif.getDeclaredAnnotations();
                System.out.println("The annotations are:");
                for (Annotation anno : annos)
                    System.out.println(anno);
            }
        }
    }
}

