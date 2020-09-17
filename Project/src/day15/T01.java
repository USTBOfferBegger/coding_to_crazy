package day15;

import java.util.concurrent.locks.LockSupport;

public class T01 {
    static Thread t1 = null, t2 = null;
    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        t1 = new Thread(()->{
            for (char c : aI){
                System.out.println(c);
                LockSupport.unpark(t2); //叫醒t2
                LockSupport.park(); //t1阻塞,当前线程堵塞
            }
        });

        t2 = new Thread(()->{
            for (char c : aC){
                LockSupport.park(); //t2阻塞
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }
}
