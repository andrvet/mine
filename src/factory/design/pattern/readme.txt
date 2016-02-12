Factory method is used to create different object 
from factory often refereed as Item and it encapsulate the creation code. 

So instead of having object creation code on client side 
we encapsulate inside Factory method in Java. 

One of the best examples of factory pattern in Java is BorderFactory Class of Swing API.

---

Factory design pattern is used to create objects or Class in Java 
and it provides loose coupling and high cohesion. 

Factory pattern encapsulate object creation logic which makes it easy to change it later 
when you change how object gets created 
or you can even introduce new object with just change in one class. 

In GOF pattern list Factory pattern is listed as _Creation design pattern. 

Factory should be an __interface and clients first either creates factory 
or get factory which later used to create objects.

==

Examples of factory method design pattern from JDK is :

valueOf() method which returns object created by factory equivalent to value of parameter passed.

getInstance() method which creates instance of Singleton class.

newInstance() method which is used to create and return new instance from factory method every time called.

getType() and newType() equivalent of getInstance() and newInstance() factory method but used when factory method resides in separate class

--

Some time our application or framework will not know that 
what kind of object it has to create at __run-time 
it knows only the interface or abstract class 
and as we know we can NOT create object of interface or abstract class 
so main problem is frame work knows __when it has to create but don’t know __what kind of object.


***When to use Factory design pattern in Java

Static Factory methods are common in frameworks where library code needs to create objects of types which may be sub classed by applications using the framework.        
Some or all concrete products can be created in multiple ways, or we want to leave open the option that in the future there may be new ways to create the concrete product.
Factory method is used when Products don't need to know how they are created.
We  can use factory pattern where we have to create an object of any one of sub-classes depending on the data provided

