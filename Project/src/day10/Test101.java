package day10;

/**
 * 抛出异常
 * throws
 * 子类重写父类，子类不能抛出比父类更大的抛出方法
 */
public class Test101 {
    public static void main(String[] args) {//可以在main方法继续抛出异常，
        //main抛出到虚拟机上
        B b = new B();
        try{//调用方法捕获异常
            b.test();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            b.test2(-100);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}

class B{
    int i;
    public void test() throws Exception{//抛出异常
        B b = null;
        System.out.println(b.i);
    }

    int age;
    public void test1(int age) throws Exception {
        if(age >= 0 && age <=10 ){
            this.age = age;
            System.out.print("年龄" + age);
        }else {
            throw new Exception("年龄不符合");
        }
    }

    public void test2(int age) throws MyException {
        if(age >= 0 && age <=10 ){
            this.age = age;
            System.out.print("年龄" + age);
        }else {
            throw new MyException("年龄不符合");
        }
    }
}


//自定义异常类,很少见
class MyException extends Exception{
    public MyException(String msg){
        super(msg);
    }
}



