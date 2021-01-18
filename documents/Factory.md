## Simple Factory

### Intent
- Creates objects without exposing the instantiation logic to the client
- refers to the newly create dobject through a common interface

### Class Diagram
Factory Pattern puts the instanciation of concreate objects into a class, let this class to determine which concrete class should be instanciated.

The advantage of Factory Pattern is that it reduced coupling between client class and concrete subclass. The client class don't need to know all the types of concrete class or which concreted should be instanciated. In a project, there are usually many client classes, by using Factory Pattern, we now have only one place to make modifacations when the implementation changes.
<div align="center"> <img src="https://github.com/DaiJiChen/Design_Patterns/blob/master/documents/simpleFactoryDiagram.jpg?raw=true"/> </div><br>

### Implementation

class and subclass 
```java
public interface foo {
    ...
}

public class ConcreteFoo implements foo {
    ...
}

public class ConcreteFoo1 implements foo {
    ...
}

public class ConcreteFoo2 implements foo {
    ...
}
```


Simpla Factory: This SimpleFactory class is used by client class
```java
public class SimpleFactory {

    public Product createFoo(int type) {
        if (type == 1) {
            return new ConcreteFoo1();
        } else if (type == 2) {
            return new ConcreteFoo2();
        }
        return new ConcreteFoo();
    }
}
```


Client class
```java
public class Client {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Foo foo = simpleFactory.createFoo(1);
        ...
    }
}
```



