package algorithm.others;

public class StaticTest extends A {
    public StaticTest(){
        System.out.println("B");

    }

    public static void main(String[] args) {
        StaticTest staticTest = new StaticTest();
    }
}

class A{
    private static  A a = new A();
    static {
        System.out.println("static");
    }
    public A(){
        System.out.println("A");
    }
}
