package generic.getinstance;

/*
 * http://stackoverflow.com/questions/3437897/how-to-get-a-class-instance-of-generics-type-t?rq=1
 * 
 * 

I have a generics class, Foo<T>. In a method of Foo, I want to get the class instance of type T, but I just can't call T.class.

What is the preferred way to get around it using T.class?

---------

 * The short answer is, that there is no way to find out the runtime type of generic type parameters in Java. I suggest reading the chapter about type erasure in the Java Tutorial for more details.

A popular solution to this is to pass the Class of the type parameter into the constructor of the generic type, e.g.

 */
class Foo<T> {
    final Class<T> typeParameterClass;

    public Foo(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public void bar() {
        // you can access the typeParameterClass here and do whatever you like
    }
}
