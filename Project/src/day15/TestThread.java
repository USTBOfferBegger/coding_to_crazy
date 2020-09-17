package day15;

/**
 * 继承Thread类
 */
public class TestThread extends Thread {



    @Override
    public void run() {
        System.out.println("多线程运行的代码逻辑");
        for(int i = 0; i < 5; i++){

            System.out.println("多线程运行" + i);
        }
    }
}
