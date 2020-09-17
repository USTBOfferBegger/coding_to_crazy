package algorithm.aTest;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
public class ThreadReen<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 8;
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();
    public void put(T t){
        try{
            lock.lock();
            while(list.size() == MAX){
                producer.await();
            }
            list.add(t);
            count++;
            consumer.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        try{
            lock.lock();
            while(list.size() == 0){
                consumer.await();
            }
            t = list.removeFirst();
            count--;
            producer.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadReen<String> threadCollection = new ThreadReen<>();
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
