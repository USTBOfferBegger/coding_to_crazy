package algorithm.xianxingbiao;


/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: Test
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 17:11 2020/7/23
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class Test {
    public static void main(String[] args) {

        //LinkTest();
        StackTest();
        //ArrayList
        //QueueTest();
        //SymbolTest();
    }

    public static void SequenceTest(){
        //创建顺序表对象
        SequenceList<String> sequenceList = new SequenceList<>(10);

        //ArrayList

        //测试插入
        sequenceList.insert("李学翰");
        sequenceList.insert("你好");
        sequenceList.insert(1,"签全");
        sequenceList.insert("钱钱钱");
        for(String s : sequenceList){
            System.out.println(s);
        }
        //测试获取
        System.out.println(sequenceList.get(1));
        //测试删除
        String remove = sequenceList.remove(3);
        System.out.println(remove);

        //测试清空
        sequenceList.clear();
        System.out.println(sequenceList.length());

        System.out.println("==================================");
    }

    public static void LinkTest(){
        LinkList<String> linkList = new LinkList<String>();
        linkList.insert("李学翰");
        linkList.insert("你好");
        linkList.insert(1,"签全");
        linkList.insert("钱钱钱");
        for(String s : linkList){
            System.out.println(s);
        }
        linkList.reverse();
        for(String s : linkList){
            System.out.println(s);
        }
    }

    public static void StackTest(){
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for (String s : stack){
            System.out.println(s);
        }

        System.out.println(stack.pop());
        System.out.println(stack.size());
    }

    public static void QueueTest(){
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        for(String s : queue){
            System.out.println(s);
        }

        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        for(String s : queue){
            System.out.println(s);
        }
    }

    public static void SymbolTest(){
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();
        symbolTable.put(1,"a");
        symbolTable.put(2,"b");
        symbolTable.put(3,"c");

        System.out.println(symbolTable.size());
        System.out.println(symbolTable.get(1));
        symbolTable.put(1, "sdas");
        System.out.println(symbolTable.get(1));
        symbolTable.delete(2);
        System.out.println(symbolTable.size());
    }
}
