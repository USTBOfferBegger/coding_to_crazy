package day15;

/**
 * 2.  实现Runnable接口
 * 1）定义子类，实现Runnable接口。
 * 2）子类中重写Runnable接口中的run方法。
 * 3）通过Thread类含参构造器创建线程对象。
 * 4）将Runnable接口的子类对象作为实际参数传递给
 *       Thread类的构造方法中。
 * 5）调用Thread类的start方法：开启线程，调用
 *       Runnable子类接口的run方法。
 */
public class TestRunnable implements Runnable {
    int count = 0;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Runnable");
        for(int i = 0; i < 5; i++){
            count ++;
            System.out.println(Thread.currentThread().getName() + "多线程运行" + i + "--" + count);
        }
    }
}
