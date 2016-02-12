package generic.instantiategenclass;

/*
 * 
 * http://stackoverflow.com/questions/1090458/instantiating-a-generic-class-in-java
 * 
 * I have a generic class Foo<T>, and I really need to instantiate a T in Foo using a parameter-less constructor. 
 * How can one work around Java's limitation?
 * 
 * --
 * One option is to pass in Bar.class (or whatever type you're interested in - any way of specifying the appropriate Class<T> reference) 
 * and keep that value as a field (see beow)
 * 
 * Another option is to have a "factory" interface, and you pass a factory to the constructor of the generic class. 
 * That's more flexible, and you don't need to worry about the reflection exceptions.
 * 
 */

public class InstantiateGenericClass
{   
    public static void main(String [] args)
        throws Exception // Just for simplicity!
    {
        Generic<Bar> x = new Generic<Bar>(Bar.class);
        Bar y = x.buildOne();
    }

    //output Constructing
}
