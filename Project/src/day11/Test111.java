package day11;

/**
 * 泛型类
 */
public class Test111 {
    public static void main(String[] args) {
        A<String> a1 = new A<String>(); //指定泛型为String
        a1.setKey("xxxx");
        String s = a1.getKey();
        System.out.println(s);
        //同样的类，但是在new对象时泛型指定不同的数据类型，这些对象不能互相赋值
        A a2 = new A();
        a2.setKey(new Object());
    }
}

/**
 * 泛型T可任意取A,B,V,一般使用T（Type）
 * @param <T>
 */
class A<T>{
    private T key;
    public void setKey(T key){
        this.key = key;
    }

    public T getKey(){
        return this.key;
    }
}


