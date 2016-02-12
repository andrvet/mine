package factory.design.pattern;

/*
 * Before seeing differences between Vector and ArrayList, let's see some similarities 
 * between these two and why we can use ArrayList in place of Vector on certain scenario.

ArrayList vs Vector in Java
1) Vector and ArrayList are __index based and backed up by an array internally.
2) Both ArrayList and Vector __maintains the insertion order of element. 
Means you can assume that you will get the object in the order you have inserted if you iterate over ArrayList or Vector.
3) Both Iterator and ListIterator returned by ArrayList and Vector are fail-fast.
4) ArrayList and Vector also allows null and duplicates

***Differences are based upon properties like 
*synchronization, thread safety, speed, performance , navigation and Iteration over List etc.

1) Synchronization and thread-safety

___Vector is synchronized and ArrayList is not,
 what it means is that all the method which structurally modifies Vector e.g. add () or remove () are synchronized 
 which makes it thread-safe and allows it to be used safely in a multi-threaded and concurrent environment. 
 On the other hand ArrayList methods are not synchronized thus not suitable for use in multi-threaded environment. 
 This is also a popular interview question on thread, where people ask why ArrayList can not be shared between multiple threads.

2) Speed and Performance

ArrayList is way faster than Vector. Since Vector is synchronized and thread-safe it pays price of synchronization 
which makes it little slow. On the other hand ArrayList is not synchronized and fast which makes it obvious choice in a single-threaded access environment. 
You can also use ArrayList in a multi-threaded environment if multiple threads are only reading values from ArrayList 
or you can create read only ArrayList as well.

3) Capacity

Whenever Vector crossed the threshold specified it increases itself by value specified in __capacityIncrement field 
while you can increase size of ArrayList by calling __ensureCapacity () method.

4) Enumeration and Iterator

Vector can return enumeration of items it hold by calling __elements () method which is not fail-fast 
as opposed to Iterator and ListIterator returned by ArrayList. 
See  What is difference between Iterator and Enumeration, you can also look there.

5) Legacy

Another point worth to remember is Vector is one of those classes which comes with JDK 1.0 and initially not part of Collection framework 
but in later version it's been re-factored to  implement List interface so that it could become part of collection framework

After considering these points about both Vector and ArrayList , 
my conclusion is use ArrayList wherever possible and avoids use of Vector until you have no choice. 
Think for CopyOnWriteArrayList  over Vector, if you have multiple readers and few writers 
because it can provide thread-safety without impacting performance too much.


 */
public class ArrayListVsVector {

}
