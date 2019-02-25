package java_syntax;

//lazy load and double check
public class Singleton {

    private volatile static Singleton instance;
    private Singleton() { }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

//反序列化
//public enum Singleton {
//    INSTANCE;
//}

//饿汉式
//public class Singleton {
//    private static final instance = new Singleton();
//    private Singleton() {}
//    public static Singleton getInstance() {
//        return instance;
//    }
//}

//静态内部类
//public class Singleton {
//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    private Singleton() {}
//
//    public static final Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//}