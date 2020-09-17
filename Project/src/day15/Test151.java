package day15;

/**
 * 程序(program)是为完成特定任务、用某种语言编写的一组指令的集合。即指一段静态的代码，静态对象。
 * 进程(process)是程序的一次执行过程，或是正在运行的一个程序。
 * 动态过程：有它自身的产生、存在和消亡的过程。
 * 如：运行中的QQ，运行中的MP3播放器
 * 程序是静态的，进程是动态的
 * 线程(thread)，进程可进一步细化为线程，是一个程序内部的一条执行路径。
 * 若一个程序可同一时间执行多个线程，就是支持多线程的
 *
 *
 * 程序需要同时执行两个或多个任务。
 * 程序需要实现一些需要等待的任务时，如用户输入、文件读写操作、网络操作、搜索等。
 * 需要一些后台运行的程序时
 *
 * Java语言的JVM允许程序运行多个线程，它通过java.lang.Thread类来实现。
 *
 * Thread类的特性
 * 每个线程都是通过某个特定Thread对象的run()方法来完成操作的，
 * 经常把run()方法的主体称为线程体 (开启的多线程中运行的代码逻辑)
 * 通过该Thread对象的start()方法来调用这个线程
 *
 * 构造方法
 * Thread()：创建新的Thread对象
 * Thread(String threadname)：创建线程并指定线程实例名
 * Thread(Runnable target)：指定创建线程的目标对象，它实现了Runnable接口中的run方法
 * Thread(Runnable target, String name)：创建新的Thread对象
 *
 * 继承Thread类
 *  1)  定义子类继承Thread类。
 *  2)  子类中重写Thread类中的run方法。
 *  3)  创建Thread子类对象，即创建了线程对象。
 *  4)  调用线程对象start方法：启动线程，调用run方法。
 *
 * 继承Thread类: 线程代码存放Thread子类run方法中。重写run方法
 * 实现Runnable接口：线程代码存在接口的子类的run方法。实现run方法
 *
 * 一般使用实现接口大方式
 * 1）避免了单继承的局限性
 * 2）多个线程可以共享同一个接口实现类的对象，非常适合多个相同线程来处理同一份资源。
 */
public class Test151 {
    public static void main(String[] args) {
        Thread t0 = new TestThread();
        t0.start();
        System.out.println("===========");
        System.out.println("===========");
        System.out.println("===========");

        Thread t1 = new Thread(new TestRunnable());
        t1.start();
        Thread t2 = new Thread(new TestRunnable(), "t-2");
        t2.start();

        System.out.println("===========");
        System.out.println("==共享接口==");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Runnable runnable0 = new TestRunnable();
        Thread t3 = new Thread(runnable0, "t-3");
        t3.start();
        Thread t4 = new Thread(runnable0, "t-4");
        t4.start();



    }
}
