package algorithm.aTest;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: SelfQueue
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 15:33 2020/8/20
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 自己实现阻塞队列
 */
public class SelfQueue<T> {

    //默认阻塞队列容量
    private static int DEFAULT_CAPACITY = 3;
    private List<T> list;

    /**
     * 默认初始化
     */
    public SelfQueue() {
        list = new ArrayList<>(DEFAULT_CAPACITY);
    }

    public SelfQueue(int capacity) throws Exception{
        DEFAULT_CAPACITY = capacity;
        list = new ArrayList<>(DEFAULT_CAPACITY);
    }
    /**
     * 堵塞放入
     */
    public void put(T t) throws InterruptedException {
        synchronized (SelfQueue.class){
            while(list.size() == DEFAULT_CAPACITY){
                //等待
                SelfQueue.class.wait();
            }
            if(list.size() < DEFAULT_CAPACITY){
                //唤醒
                SelfQueue.class.notify();
            }
            list.add(t);
        }
    }

    /**
     * 堵塞取
     */
    public T poll() throws InterruptedException{
        synchronized (SelfQueue.class){
            while (list.size() == 0){
                SelfQueue.class.wait();
            }
            if(list.size() > 0){
                SelfQueue.class.notify();
            }
            return list.remove(0);
        }
    }
}
