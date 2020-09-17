package Test01;

/**
 * 类A想通同时获取B和C的方法并重写
 * 使用内部类变相使用类的多重继承
 */
public class Test4 {
    public static void main(String[] args) {
        A a = new A();
        a.TestB();
        a.TestC();
    }
}

class A{

    public void TestB(){
        new InnerB().TestB();
    }
    public void TestC(){
        new InnerC().TestC();
    }

    private class InnerB extends B{
        @Override
        public void TestB() {
            System.out.println("B的继承");
        }
    }

    private class InnerC extends C{
        @Override
        public void TestC() {
            System.out.println("C的继承");
        }
    }
}

class B{
    public void TestB(){

    }
}

class C{
    public void TestC(){

    }
}
