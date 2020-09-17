package algorithm.aTest;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: ThreadCollection
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 11:16 2020/8/28
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class ThreadCollection<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 8;
    private int count = 0;

    public synchronized void put(T t){
        while(list.size() == MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        count++;
        this.notifyAll();
    }

    public synchronized T get(){
        T t = null;
        while (list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadCollection<String> threadCollection = new ThreadCollection<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(threadCollection.get());
                }
            }, "消费者" + i).start();
        }

        TimeUnit.SECONDS.sleep(1);

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    threadCollection.put(Thread.currentThread().getName() + " " + j);
                }
            }, "生产者" + i).start();
        }
    }
}
