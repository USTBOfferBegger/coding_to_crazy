package Test01;

/**
 * 内部类
 * 有什么用：解决Java不能多重继承的问题
 */
public class Test3 {
    int i;
    public int z;
    private int k;
    class A{
        int i;
        public void setTest3Filed(){
            Test3.this.i = 1;
            Test3.this.z = 2;
            Test3.this.k = 3;

        }
        public void set(){
            this.i = 10;
        }
    }
    //内部类static 不能使用外部类非static
    static class B{

    }

    public void setInfo(){
        new A().setTest3Filed();//外部类要用内部类方法，先new对象
    }
    public void showInfo(){
        System.out.println(this.i);
        System.out.println(this.z);
        System.out.println(this.k);
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.setInfo();
        test3.showInfo();
    }
}
