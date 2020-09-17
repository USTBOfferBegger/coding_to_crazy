package algorithm.xianxingbiao;

import java.util.Iterator;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: Queue
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 15:31 2020/7/27
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class Queue<T> implements Iterable<T>{
    //记录首结点
    private Node head;
    //记录当前队列的元素个数
    private int N;
    //记录最后一个结点
    private Node last;

    //结点类
    private class Node{
        //存储数据
        T item;
        //下一个结点
        Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    public Queue(){
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return this.N == 0;
    }
    //获取队列中元素的个数
    public int size(){
        return this.N;
    }
    //从队列中拿出一个元素
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        Node oldNode = head.next;
        head.next = oldNode.next;
        this.N--;
        //因为出队列其实是在删除元素，如果队列中的元素被删除了，需要重置last=null
        if(isEmpty()){
            last = null;
        }

        return oldNode.item;
    }
    //往队列中插入一个元素
    public void enqueue(T t){

        if(last == null){
            //当前尾结点last为null
            last = new Node(t, null);
            this.head.next = last;
        }else {
            //当前尾结点last不为null
            Node lastNode = last;
            last = new Node(t, null);
            lastNode.next = last;
        }

        this.N++;

    }

    @Override
    public Iterator<T> iterator() {
        return new StIterator();
    }

    private class StIterator implements Iterator{
        private Node node;
        public StIterator(){
            this.node = head;
        }
        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }

}
