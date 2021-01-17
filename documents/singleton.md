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

uniqueInstance 采用 volatile 关键字修饰也是很有必要的， `uniqueInstance = new Singleton();` 这段代码其实是分为三步执行：

1. 为 uniqueInstance 分配内存空间
2. 初始化 uniqueInstance
3. 将 uniqueInstance 指向分配的内存地址

但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1>3>2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T<sub>1</sub> 执行了 1 和 3，此时 T<sub>2</sub> 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。

使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。

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