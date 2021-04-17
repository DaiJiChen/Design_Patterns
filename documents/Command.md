## Command Pattern

### Intent

encapsulate commands in class:

- Using command to parameterization other objects
- Saving operations to a queue
- Recording operations in log
- Supporting revoking operations

### Class Diagram

Command: an interface

ConcreteCommand: Represent a certain kind of operation. Such as `read book` or `close book`

Receiver: An object that represent the things to be operated. Such as a `book`

Invoker: The object who calls operations. such as a `reader' or 'student'

Client: set command and receive feedbacks. 


### Implementation

Implement operations of book.

```java
public interface Command {
    void execute();
}
```

```java
public class ReadBook implements Command {
  Book book;
  
  public ReadBook(Book book) {this.book = book;}
  
  @Override
  public void execute() {
      book.read();
  }
}
```

```java
public class CloseBook implements Command {
  Book book;
  
  public CloseBook(Book book) {this.book = book;}
  
  @Override
  public void execute() {
      book.Close();
  }
}
```

```java
public class Book {
    public void read() {
        ...
    }
    
    public void open() {
        ...
    }
    
    public void close() {
        ...
    }
}
```

```java
public class Reader {
    private Queue<Command> commands;
    
    public Reader() {
        commands = new LinkedList<>();
    }
    
    public void do(Command command) {
        commands.add(command);
        command.execute(commands.poll());
    } 
}
```

```java
public class client {
    Reader reader = new Reader();
    Book book = new Book();
    
    Command read = new ReadBook(book);
    Command close = new CloseBook(book);
    
    reader.do(read);
    reader.do(close);
}
```


