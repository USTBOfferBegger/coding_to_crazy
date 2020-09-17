package day11;

import java.util.List;

/**
 * 泛型类接口
 */
public class Test112 {
    public static void main(String[] args) {
        B1<Object> b1 = new B1<Object>();
        B2 b2 = new B2();

        Cc<Object> cc = new Cc<Object>();
        cc.test("xxx");
        //泛型方法调用前没有固定的数据类型
        //传什么就变成什么
        cc.test1(2);
        cc.test1(true);
    }
}

interface IB<T>{
    T test(T t);
}

/**
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * @param <T>
 */
class B1<T> implements IB<T>{
    @Override
    public T test(T t) {
        return null;
    }
}

/**
 * 在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
 */
class B2 implements IB<String>{

    @Override
    public String test(String s) {
        return null;
    }
}

/**
 * 泛型方法
 */
class Cc<E>{
    private E e;

    public static <T> void test3(T t){
        System.out.println(t);
    }
    public <T> void test(T s){
        System.out.println(this.e); //静态方法中不能使用
        T t = s;
    }

    public <T> T test1(T a){
        return a;
    }

//    public void test2(String... strings){
//        for(String s : strings){
//            System.out.println(s);
//        }
//    }

    public <T> void test2(T... strings){
        for(T s : strings){
            System.out.println(s);
        }
    }
}


/**
 * 通配符
 */
class Dd{
    public void test(List<?> list){

    }
}

class Q1{ }
class W1 extends Q1{ }