package day15;

/**
 * void start():  启动线程，并执行对象的run()方法
 * run():  线程在被调度时执行的操作
 * String getName():  返回线程的名称
 * void setName(String name):设置该线程名称
 * static currentThread(): 返回当前线程
 *
 * 线程的优先级控制
 * MAX_PRIORITY（10）;
 * MIN _PRIORITY （1）;
 * NORM_PRIORITY （5）;
 * 涉及的方法：
 * getPriority() ：返回线程优先值
 * setPriority(int newPriority) ：改变线程的优先级
 * 线程创建时继承父线程的优先级
 *
 *
 * static  void  yield()：线程让步
 * 暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程
 * 若队列中没有同优先级的线程，忽略此方法
 * join() ：当某个程序执行流中调用其他线程的 join() 方法时，调用线程将被阻塞，直到 join() 方法加入的 join 线程执行完为止
 * 低优先级的线程也可以获得执行
 * static  void  sleep(long millis)：(指定时间:毫秒)
 * 令当前活动线程在指定时间段内放弃对CPU控制,使其他线程有机会被执行,时间到后重排队。
 * 抛出InterruptedException异常
 * stop(): 强制线程生命期结束
 * boolean isAlive()：返回boolean，判断线程是否还活着
 */
public class Test152 {
    public static void main(String[] args) {
        TestRun testRun0 = new TestRun();
        TestRun testRun1 = new TestRun();
        Thread t0 = new Thread(testRun0);
        Thread t1 = new Thread(testRun1);

        //t0.setPriority(1); //优先级
        //t1.setPriority(10);  //概率问题

        t0.start();
        t1.start();

        //t0.setName("t1");
        System.out.println(t0.getName()); //没有指定名称，系统默认Thread-0
        System.out.println(t1.getName());

        /**
         * 线程优先级
         * 1-10越大优先级越高，没有设置默认5
         */
        System.out.println("t0的优先级" + t0.getPriority());
        System.out.println("-------------------");

        System.out.println(t1.isAlive());
        t1.stop();  //强制结束线程生命周期


        try {
            t0.join();  //把RUN方法插入这个位置
            /**
             * 阻塞当前的main方法，先不执行下面的方法
             * 先执行join的方法，执行完毕，自行接下来的main方法
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------");
        System.out.println(t1.isAlive());
        System.out.println("-------------------");
    }
}

class TestRun implements Runnable{
    int count = 0;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Runnable");
        for(int i = 0; i < 5; i++){
            if(i % 2 == 0){
                Thread.yield(); //线程让步
            }
            count ++;
            System.out.println(Thread.currentThread().getName() + "多线程运行" + i + "--" + count);
        }
    }
}
