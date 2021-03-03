## Visitor Pattern

### Intent

- Represents an operation to be performed on the elements of an object structure
- Visitor lets you define a new operation without changing the classes of the elements on which it operates.

### Class Diagram

`Visitor interface`: defined several abstract visit method
`Concrete Visitor`: defines concrete visit operations
`element`: ususlly involved in a poly relation, represent elements to be operated

```java
public interface Element {
    void accept(Visitor visitor);
}
```

```java
public class user implements Element {

    private String name;

    User(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
```

```java
public interface Visitor {
    void visit(User user);
}
```

```java
public class GeneralReport implements Visitor {

    public void visit(User user) {
        System.out.println(user.getName());
    }
}
```
