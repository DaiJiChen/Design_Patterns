//饿汉式
class Singleton1 {
    int val;
    private static volatile Singleton1 instance = new Singleton1(1);

    private Singleton1(int x) {val = x;}

    public static Singleton1 getInstance() {
        return instance;
    }
}

//懒汉式
class Singleton2 {
    int val;
    private static volatile Singleton2 instance = null;

    private Singleton2(int x) {val = x;}

    public static Singleton2 getInstance() {
        if(instance == null) {
            synchronized (Singleton2.class) {
                if(instance == null) {
                    instance = new Singleton2(2);
                }
            }
        }

        return instance;
    }
}

//静态内部类
class Singleton3 {
    int val;
    private static class instanceHolder {
        private static volatile Singleton3 instance = new Singleton3(3);
    }

    private Singleton3(int x) {val = x;}

    public static Singleton3 getInstance() {
        return instanceHolder.instance;
    }

}


public class SingletonDemo {
    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.getInstance();
        System.out.println(s1.val);

        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s2.val);

        Singleton3 s3 = Singleton3.getInstance();
        System.out.println(s3.val);
    }
}
