## Singleton

### Intent
Make sure that only one instance of a class is created and provide a global accesss point to the object.
	
### class diagram:
1. A private constructor()
2. A private static variable
3. A public  static getInstance()

### Implementation

#### Lazy instanciation: adding the synchronized keywork to getInstances()
Shortcoming: Only one thread can use this instance at a time.
```java
public class Singleton {
	private static Singleton instance;
	
	private Singleton() {}
	
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
```


#### Early Instanciation
Shortcoming: This instance may not been used, but it is created. This will waste space.
```java
public class Singleton {
	private static Singleton instance = new Singleton();
	
	private Singleton();
	
	public static Singleton getInstance() {
		return instances;
	}
}
```


#### double-checked locking

```java
public class Singleton {
	private static volatile Singleton instance;
	
	private Singleton();
	
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				if(instance == null) {
					instance = n ew Singleton();0
				}
			}
		}
		return instances;
	}
}
```

Why use `volatile` keyword: Because `instance = new Singleton();` is seperated into three step:
1. allocate space,
2. instanciate instance;
3. let this instance point to allocated space.

Because of the Java compiler reordering, the order of execution might become 1>3>2. In a multithreading environment, if threadA executed 1 and 3, then a new threadB call getInstance() and find instance != null, ThreadB will return instance, but until now instance hasn't been fully instanciated yet.

### static inner class

```java
public class Singleton {
	private static class InstanceHolder {
		private static final Singleton instance = new Singleton();
	}
	
	private Singleton();
	
	public static Singleton getInstance() {
		return InstanceHolder.instance;
	}
}
```
