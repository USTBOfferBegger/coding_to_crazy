package day15;

/**
 * wait() 与 notify() 和 notifyAll()
 * wait()：令当前线程挂起并放弃CPU、同步资源，
 * 使别的线程可访问并修改共享资源，而当前线程排队等候再次对资源的访问
 * notify()：唤醒正在排队等待同步资源的线程中优先级最高者结束等待
 * notifyAll ()：唤醒正在排队等待资源的所有线程结束等待.
 * Java.lang.Object提供的这三个方法只有在synchronized方法
 * 或synchronized代码块中才能使用，
 * 否则会报java.lang.IllegalMonitorStateException异常
 */
public class Test154 {
    public static void main(String[] args) {
        //定义账户对象
        Account account = new Account();
        Account account1 = new Account();
        //多线程对象
        User user_W = new User(account, 2000); //微信
        User user_Z = new User(account, 2000); //支付宝
        Thread weChat = new Thread(user_W, "微信");
        Thread zhi = new Thread(user_Z, "支付宝");
        weChat.start();
        zhi.start();
    }
}

class Account{
    public static int money = 3000;

    /**
     * 当多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了一部分，
     * 还没有执行完，另一个线程参与进来执行。导致共享数据的错误。
     * 解决办法:
     * 对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中，其他线程不可以参与执行。
     * Synchronized 同步锁
     * 直接在方法上加关键字
     * 在普通方法上加同步锁，锁的是当前方法对应的对象，当前对象公用一个同步锁，不是某个方法；
     * 不同的对象就是不同的锁（Account a1 a2）,还是有共享资源的问题
     * @param m
     */
    public synchronized void drawing(int m){
        if(money < m){
            System.out.println("账户金额不足");
        }else {
            String name = Thread.currentThread().getName();
            System.out.println(name + "操作， 账户原有金额" + money);
            System.out.println(name + "操作， 取款金额" + m);
            money -= m;
            System.out.println(name + "操作， 取款后的金额" + money);
        }

    }

    public synchronized void drawing1(int m){
        if(money < m){
            System.out.println("账户金额不足");
        }else {
            String name = Thread.currentThread().getName();
            System.out.println(name + "操作， 账户原有金额" + money);
            System.out.println(name + "操作， 取款金额" + m);
            money -= m;
            System.out.println(name + "操作， 取款后的金额" + money);
        }

    }

    /**
     * 静态对象加同步锁，所有对象都是使用同一个锁
     * @param m
     */
    public static synchronized void drawing2(int m){
        if(money < m){
            System.out.println("账户金额不足");
        }else {
            String name = Thread.currentThread().getName();
            System.out.println(name + "操作， 账户原有金额" + money);
            System.out.println(name + "操作， 取款金额" + m);
            money -= m;
            System.out.println(name + "操作， 取款后的金额" + money);
        }

    }

    /**
     * 对代码块加入同步锁
     * synchronized (this)所有对象的代码块使用同一个对象
     * @param m
     */
    public void drawing3(int m){
        synchronized (this){
            //用this表示当前的对象，如果在其他的方法也有synchronized的代码块，使用的都是同一个同步锁
            if(money < m){
                System.out.println("账户金额不足");
            }else {
                String name = Thread.currentThread().getName();
                System.out.println(name + "操作， 账户原有金额" + money);
                System.out.println(name + "操作， 取款金额" + m);
                money -= m;
                System.out.println(name + "操作， 取款后的金额" + money);
            }
        }
    }

    public void drawing4(int m){
        synchronized (this){
            //用this表示当前的对象，如果在其他的方法也有synchronized的代码块，使用的都是同一个同步锁
            if(money < m){
                System.out.println("账户金额不足");
            }else {
                String name = Thread.currentThread().getName();
                System.out.println(name + "操作， 账户原有金额" + money);
                System.out.println(name + "操作， 取款金额" + m);
                money -= m;
                System.out.println(name + "操作， 取款后的金额" + money);
            }
        }
    }

    /**
     * synchronized代码块根据不同的对象有不同的锁
     * @param m
     */
    public void drawing5(int m, Account account){
        synchronized (account){ //通过参数传递的对象
            String name = Thread.currentThread().getName();
            //如果是微信，先不执行，等支付宝操作，支付宝操作完再执行微信
            if(name.equals("微信")){
                try {
                    account.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(money < m){
                System.out.println("账户金额不足");
            }else {
                System.out.println(name + "操作， 账户原有金额" + money);
                System.out.println(name + "操作， 取款金额" + m);
                money -= m;
                System.out.println(name + "操作， 取款后的金额" + money);
            }

            if(name.equals("支付宝")){
                account.notify();
            }
        }
    }
}

class User implements Runnable{
    Account account;
    int money;
    public User(Account account, int money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        //account.drawing(money);
//        if(Thread.currentThread().getName().equals("微信")){
//            account.drawing3(money);
//        }else {
//            account.drawing4(money);
//        }
        //account.drawing3(money);

        account.drawing5(money, account);
    }
}
