package factory.design.pattern;

/*
 * Autoboxing (int->Integer) is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. 
 * 
 * For example, converting an int to an Integer, a double to a Double, and so on. 
 * 
 * If the conversion goes the other way, this is called unboxing.
 * 
 * Primitives versus classes
__Primitive variables in Java contain values (an integer, a double-precision floating point binary number, etc). 
Because these values may have __different lengths, the variables containing them may also have different lengths (consider float versus double).

On the other hand, __class variables contain __references to instances. 
References are typically implemented as pointers (or something very similar to pointers) in many languages. 
These things typically have the __same size, regardless of the sizes of the instances they refer to (Object, String, Integer, etc).

This property of class variables makes the references they contain __interchangeable (to an extent). 
This allows us to do what we call _substitution: broadly speaking, 
to use an instance of a particular type as an instance of another, related type (use a __String as an Object, for example).

Primitive variables __aren't interchangeable in the same way, neither with each other, nor with Object. 
The most obvious reason for this (but not the only reason) is their __size difference. 
This makes primitive types inconvenient in this respect, but we still need them in the language (for reasons that mainly boil down to performance).

***Generics and type erasure
Generic types are types with one or more __type parameters (the exact number is called generic arity). 
For example, the generic type definition List<T> has a type parameter T, 
which can be Object (producing a concrete type List<Object>), String (List<String>), Integer (List<Integer>) and so on.

Generic types are a lot more complicated than non-generic ones. 
When they were introduced to Java (after its initial release), in order to avoid making radical changes to the JVM 
and possibly breaking compatibility with older binaries, the creators of Java decided to implement generic types 
in the least invasive way: 
all concrete types of List<T> are, in fact, compiled to (the binary equivalent of) List<Object> 
(for other types, the bound may be something other than Object, but you get the point). 
Generic arity and type parameter information are lost in this process, which is why we call it __type erasure.

Putting the two together
Now the problem is the combination of the above realities: 
if List<T> becomes List<Object> in all cases, then T must always be a type that can be directly assigned to Object. 
Anything else can't be allowed. Since, as we said before, int, float and double aren't interchangeable with Object, 
there can't be a List<int>, List<float> or List<double> (unless a significantly more complicated implementation of generics existed in the JVM).

But Java offers types like Integer, Float and Double which wrap these primitives in class instances, 
making them effectively substitutable as Object, 
thus allowing generic types to indirectly work with the primitives as well (because you can have List<Integer>, List<Float>, List<Double> and so on).

The process of creating an Integer from an int, a Float from a float and so on, is called __boxing. 
The reverse is called unboxing. Because having to box primitives every time you want to use them as Object is inconvenient, 
there are cases where the language does this automatically - that's called autoboxing.

 * 
 */
public class AutoBoxingUnBoxing {

}
