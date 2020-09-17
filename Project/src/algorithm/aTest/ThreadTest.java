package algorithm.aTest;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: ThreadTest
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 13:51 2020/8/17
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class ThreadTest {
    static Thread t1 = null, t2 = null;

    public static void te01(){
        char[] aI = "123456".toCharArray();
        char[] aC = "ABCDEF".toCharArray();

        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.println(c);
                LockSupport.unpark(t2); //t2叫醒
                LockSupport.park(); //t1堵塞
            }
        }, "t1");
        t2 = new Thread(() -> {
            for (char c : aC) {
                LockSupport.park(); //t2堵塞
                System.out.println(c);
                LockSupport.unpark(t1); //t1叫醒
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    /**
     * 问题：启动3个线程A、B、C，使A打印0，然后B打印1，然后C打印2，A打印3，B打印4，C打印5，依次类推。
     */
    public static void te02(){
        char[] ch = "abcdefghijklmn".toCharArray();
        int threadCount = 3;
        for (int i = 0; i < threadCount; i++) {
            new Thread(new TestSequential4(i, threadCount, ch)).start();
        }
    }

    /**
     * 8皇后
     */
    public static void te03(){
        System.out.println(num1(8));
    }

    public static int num1(int n){
        if(n < 1) return 0;
        //record[i] 表示第i行的所在的列
        int[] record = new int[n];
        return process(0, record, n);

    }
    public static int process(int i, int[] record, int n){
        if(i == n) return 1;
        int res = 0;
        for(int j = 0; j < n; j++){
            if(check(record, i, j)){
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }
    public static boolean check(int[] record, int i, int j){
        for(int k = 0; k < i; k++){
            if(record[k] == j || Math.abs(i - k) == Math.abs(record[k] - j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //te01();
        //te02();
        te03();
        Set<Integer> set = new HashSet<>();

    }
}

class TestSequential4 implements Runnable{
    private static int count = 0;
    private static final Object obj = new Object();

    private char[] print = null;
    /**
     * 线程数量
     */
    private int threadCount;
    /**
     * 当前线程编号，从0开始
     */
    private int threadNo;

    private int max;


    public TestSequential4(int threadNo, int threadCount, char[] print) {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
        this.print = print;
        this.max = print.length;
    }

    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                while (count % threadCount != threadNo) {
                    //System.out.println(count + "c-线程" + threadNo);
                    if(count >= max) break;
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(count >= max) break;
                System.out.println(print[count] + "--线程--" + threadNo);
                count++;
                obj.notifyAll();
            }
        }
    }

}
