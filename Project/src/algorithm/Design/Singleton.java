package algorithm.Design;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: Singleton
 * @Author 李学翰
 * @Description: 单例模式
 * @Data: Create in 14:44 2020/7/22
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */


/**
 * 懒加载 懒汉式，线程不安全
 */
public class Singleton {
    private Singleton(){}
    private static Singleton instance = null;
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

/**
 * 先加载 饿汉式，线程安全
 */
class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return instance;
    }
}

/**
 * 懒加载 加锁，线程安全，双检锁
 * volatile 阻止指令重排
 */
class Singleton2 {
    private Singleton2(){}
    private volatile static Singleton2 instance = null;//volatile 防止指令重排
    public static Singleton2 getInstance(){
        if(instance == null){
            synchronized (Singleton2.class){
                if(instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
/**
 * 枚举类
 */
class Singleton4{
    private Singleton4(){}
    private enum Singleton{
        INSTANCE;
        private final Singleton4 instance;

        Singleton(){
            instance = new Singleton4();
        }

        private Singleton4 getInstance(){
            return instance;
        }
    }
    public static final Singleton4 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
}

/**
 * 静态内部类，只有第一次调用加载
 */
class Singleton3{
    private Singleton3(){}
    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }
    public static Singleton3 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

class S{
    private S(){}

    public enum Sen{
        INSTANCE;
        private final S instance;
        Sen(){
           instance = new S();
        }
        private S getInstance(){
            return instance;
        }
    }
    public static S getInstance(){
        return Sen.INSTANCE.getInstance();
    }
}

class SS{
    private SS() {
    }
    private static volatile SS instance;
    public static SS getInstance(){
        if(instance == null){
            synchronized (SS.class){
                if(instance == null){
                    instance = new SS();
                }
            }
        }
        return instance;
    }
}

class SSS{
    private SSS() {
    }
    private static SSS instance = new SSS();
    public SSS getInstance(){
        return instance;
      }
}

class eHan{
    private eHan(){}
    public static eHan instance = new eHan();
    public eHan getInstance(){return instance;}
}

class Suo{
    public static volatile Suo instance = null;
    private Suo(){}
    public Suo getInstance(){
        if(instance == null){
            synchronized (Suo.this){
                if(instance == null){
                    instance = new Suo();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类
 */
class Jingtai{
    private Jingtai(){}
    private static class classHolder{
        public static final Jingtai j = new Jingtai();
    }
    public Jingtai getInstance(){
        return classHolder.j;
    }
}


