package day14;

import java.lang.reflect.Field;

/**
 * 反射
 * 反射相关的主要API：
 *   java.lang.Class:代表一个类
 *   java.lang.reflect.Method:代表类的方法
 *   java.lang.reflect.Field:代表类的成员变量
 *  java.lang.reflect.Constructor:代表类的构造方法
 *
 * 在Object类中定义了以下的方法，此方法将被所有子类继承：
 *  public final Class getClass()
 *
 *  以上的方法返回值的类型是一个Class类，此类是Java反射的源头，
 *  实际上所谓反射从程序的运行结果来看也很好理解，
 *  即：可以通过对象反射求出类的名称
 *
 *   反射可以得到的信息：某个类的属性、方法和构造器、某个类到底实现了哪些接口。
 *   对于每个类而言，JRE 都为其保留一个不变的 Class 类型的对象。
 *   一个 Class 对象包含了特定某个类的有关信息。
 *   Class本身也是一个类
 *   Class 对象只能由系统建立对象
 *   一个类在 JVM 中只会有一个Class实例
 *   一个Class对象对应的是一个加载到JVM中的一个.class文件
 *   每个类的实例都会记得自己是由哪个 Class 实例所生成
 *   通过Class可以完整地得到一个类中的完整结构
 */
public class Test141 {
    public static void main(String[] args) {
        Person p = new Person();
        Class clazz = p.getClass(); //clazz包含p所属person类所有信息

        //通过类名创建
        Class c0 = Person.class;

        //通过类的实例对象的getClass()方法获取
        Class c1 = p.getClass();

        //已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()获取
        //forName 方法全路径
        //常用方式
        try {
            Class c2 = Class.forName("day14.Person");

            ClassLoader loader = ClassLoader.getSystemClassLoader();
            Class<?> loadUser = loader.loadClass("day14.Person");
            Field[] objects = loadUser.getFields();
            System.out.println(loadUser.getClassLoader());
            for(Field field : objects){
                System.out.println(field.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

