package generic;

/*
 * 
http://stackoverflow.com/questions/3403909/get-generic-type-of-class-at-runtime

How can I achieve this?

public class GenericClass<T>
{
    public Type getMyType()
    {
        //How do I return the type of T?
    }
}

Everything I have tried so far always returns type Object rather than the specific type used.
=========

As others mentioned, it's only possible via reflection in certain circumstances.

If you really need the type, this is the usual (type-safe) workaround pattern:


 */
public class GenericClass<T> {

    private final Class<T> type;

    public GenericClass(Class<T> type) {
         this.type = type;
    }

    public Class<T> getMyType() {
        return this.type;
    }
}
