package algorithm.xianxingbiao;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: JosephTest
 * @Author 李学翰
 * @Description: 约瑟夫问题
 * @Data: Create in 16:41 2020/7/24
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class JosephTest {
    public static void main(String[] args) {
        //构建循环链表1-41
        //首结点
        Node<Integer> head = null;
        //记录前一个结点
        Node<Integer> pre = null;

        //for
        for(int i = 1; i <= 41; i++){
            //第一个结点
            if(i == 1){
                head = new Node<>(i, null);
                pre = head;
                continue;
            }
            //不是第一个结点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = pre.next;
            //最后一个结点
            if(i == 41){
                pre.next = head;
            }
        }

        //计数器
        int count = 0;
        //遍历 条件 只剩一个Node n=n.next
        //从首结点开始
        Node<Integer> node = head;
        //后一个结点
        Node<Integer> before = null;
        while (node != node.next){
            count++;
            //是否被3整除
            if(count%3 == 0){
                before.next = node.next;
                System.out.print(node.item + ", ");
                node = node.next;
            }else {
                before = node;
                node = node.next;
            }
        }

        System.out.println(node.item);


    }

    //结点类
    private static class Node<T>{
        //存储数据
        T item;
        //下一个结点
        Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
