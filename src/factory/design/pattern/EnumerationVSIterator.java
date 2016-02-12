package factory.design.pattern;

/*
 * both Iterator and Enumeration allows you to traverse over elements of Collections in Java, 
 * there is some significant difference between them e.g. 
 * 
 * Iterator also allows you to ___remove elements from collection during traversal 
 * but Enumeration doesn't allow that, it doesn't got the remove() method. 
 * 
 * Enumeration is also a legacy class and not all Collection supports it e.g. 
 * Vector supports Enumeration but ArrayList doesn't. On the other hand Iterator is the standard class for iteration and traversal


Also Iterator is more secure and safe as compared to Enumeration because it  does not allow other thread to modify the collection object while some thread is iterating over it and throws ConcurrentModificationException. This is by far most important fact for me for deciding between Iterator vs Enumeration in Java.

Enumeration
hasMoreElement()
nextElement()
N/A


Iterator
hasNext()
next()
remove()

So Enumeration is used when ever we want to make Collection objects as Read-only


 */
public class EnumerationVSIterator {

}
