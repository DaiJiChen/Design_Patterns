## Iterator Pattern

### Intent

Provide a way to access the elements of an aggregate object sequentially without exposing its internal structure.

The abstraction provided by the iterator pattern allows you to modify the collection implementation without making any changes outside of collection. 

### Components

1. Iterator: The iterator will maintain the state of the iteration, keeping track of the current item and identifying next element.
2. Container: contains all data and the iterator.

```java
public interface Iterator {
   public boolean hasNext();
   public Object next();
}
```

```java
public interface Container {
   public Iterator getIterator();
}
```

```java
public class NameRepository implements Container {
   String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

   @Override
   public Iterator getIterator() {
      return new NameIterator(names);
   }
}
```

```java
private class NameIterator implements Iterator {

      int index;
      String names[];
      
      public NameIterator(String names[]) {this.names = names;}

      @Override
      public boolean hasNext() {
         if(index < names.length)
            return true;
         else 
            return false;
      }

      @Override
      public Object next() {
         if(this.hasNext())
            return names[index++];
         else
            return null;
      }		
   }
```

```java
public class IteratorPatternDemo {
	
   public static void main(String[] args) {
      NameRepository namesRepository = new NameRepository();

      for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
         String name = (String)iter.next();
         System.out.println("Name : " + name);
      } 	
   }
}
```
