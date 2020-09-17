package algorithm.xianxingbiao;

import java.util.Iterator;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: Stack
 * @Author 李学翰
 * @Description: 栈的实现
 * @Data: Create in 17:08 2020/7/24
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class Stack<T> implements Iterable<T> {
    private Node head;
    private int N;

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
    public Stack(){
        this.head = new Node(null, null);
        this.N = 0;
    }
    //判断栈空
    public boolean isEmpty(){
        return this.N == 0;
    }
    //获取元素个数
    public int size(){
        return this.N;
    }
    //弹出栈顶元素
    public T pop(){
        //找到首结点的第一个结点
        Node firstNode = this.head.next;
        //判断是否为空
        if(firstNode == null){
           return null;
        }
        //首结点指向原来第一个结点之后的结点
        this.head.next = firstNode.next;
        this.N--;

        return firstNode.item;
    }
    //向栈压入元素
    public void push(T t){
        //找到首结点指向的第一个结点
        Node firstNode = this.head.next;
        //创建新结点
        Node newNode = new Node(t, null);
        //首结点指向新结点
        this.head.next = newNode;
        //新结点指向后一个结点
        newNode.next = firstNode;

        this.N++;
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private Node node;
        public SIterator(){
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
