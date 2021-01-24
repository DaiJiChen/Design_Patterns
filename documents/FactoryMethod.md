## Intent
- Defines an interface for creating object, but let subclasses to decide which class to instanciate
- Refers to the newly created object through a common interface

## Diagram
1. Factory: declares the method FactoryMethod();
2. ConcreteFactory: override the FactoryMethod();


### Implementation
```java
public abstract class Factory {
    abstract public Product factoryMethod();
    public void doSomething() {
        Product product = factoryMethod();
        // do something with the product
    }
}
```

```java
public class ConcreteFactory extends Factory {
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
```

```java
public class ConcreteFactory1 extends Factory {
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
```

```java
public class ConcreteFactory2 extends Factory {
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}
```

```java
 public class Client 
{
	public static void main( String arg[] ) 
	{
		Factory factory = new ConcreteFactory1();
		Product product = factory.factoryMethos();
	}
}
```
