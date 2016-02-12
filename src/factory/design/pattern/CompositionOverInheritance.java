package factory.design.pattern;

/*
 *
 * 
 * http://stackoverflow.com/questions/49002/prefer-composition-over-inheritance
 * 
 * 
 * Prefer composition over inheritance as it is more malleable / easy to modify later, 
 * but do not use a compose-always approach. 
 * 
 * With composition, it's easy to change behavior on the fly with Dependency Injection / Setters. 
 * Inheritance is more rigid as most languages do not allow you to derive from more than one type.. 
 * So the goose is more or less cooked once you derive from Class A.
 * 
My acid test for the above is:

a)Inheritance: Does TypeB want to expose the complete interface (all public methods no less) of TypeA such that TypeB can be used where TypeA is expected? 
e.g. A Cessna biplane will expose the complete interface of an airplane, if not more. So that makes it fit to derive from Airplane.

b)Composition: Does TypeB only want only some/part of the behavior exposed by TypeA? Indicates need for Composition.
e.g. A Bird may need only the fly behavior of an Airplane. 
In this case, it makes sense to extract it out as an interface / class / both and make it a member of both classes.

Update: Just came back to my answer and it seems now that it is incomplete without a specific mention of 
Barbara Liskov's Liskov Substitution Principle as a test for 'Should I be inheriting from this type?'

================


Think of containment as a has a relationship. A car "has an" engine, a person "has a" name, etc.

Think of inheritance as an is a relationship. A car "is a" vehicle, a person "is a" mammal, etc.


=======


Procedural Code
An example of this is PHP without the use of classes (particularly before PHP5). All logic is encoded in a set of functions. You may include other files containing helper functions and so on and conduct your business logic by passing data around in functions. This can be very hard to manage as the application grows. PHP5 tries to remedy this by offering more object oriented design.

Inheritance
This encourages the use of classes. Inheritance is one of the three tenets of OO design (inheritance, polymorphism, encapsulation).

class Person {
   String Title;
   String Name;
   Int Age
}

class Employee : Person {
   Int Salary;
   String Title;
}
This is inheritance at work. The Employee "is a" Person or inherits from Person. All inheritance relationships are "is-a" relationships. Employee also shadows the Title property from Person, meaning Employee.Title will return the Title for the Employee not the Person.

Composition
Composition is favoured over inheritance. To put it very simply you would have:

class Person {
   String Title;
   String Name;
   Int Age;

   public Person(String title, String name, String age) {
      this.Title = title;
      this.Name = name;
      this.Age = age;
   }

}

class Employee {
   Int Salary;
   private Person person;

   public Employee(Person p, Int salary) {
       this.person = p;
       this.Salary = salary;
   }
}

Person johnny = new Person ("Mr.", "John", 25);
Employee john = new Employee (johnny, 50000);
Composition is typically "has a" or "uses a" relationship. Here the Employee class has a Person. It does not inherit from Person but instead gets the Person object passed to it, which is why it "has a" Person.

Composition over Inheritance
Now say you want to create a Manager type so you end up with:

class Manager : Person, Employee {
   ...
}
This example will work fine, however, what if Person and Employee both declared Title? Should Manager.Title return "Manager of Operations" or "Mr."? Under composition this ambiguity is better handled:

Class Manager {
   public Title;
   public Manager(Person p, Employee e)
   {
      this.Title = e.Title;
   }
}
The Manager object is composed as an Employee and a Person. The Title behaviour is taken from employee. This explicit composition removes ambiguity among other things and you'll encounter fewer bugs.



 */


public class CompositionOverInheritance {

}
