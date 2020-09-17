package algorithm.tree;

import algorithm.xianxingbiao.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: TreeTest
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 13:29 2020/7/28
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class TreeTest {

    public static void BinaryTreeTest(){
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
        binaryTree.put(1,"a");
        binaryTree.put(2,"b");
        binaryTree.put(3,"c");

        System.out.println(binaryTree.size());

        System.out.println(binaryTree.get(1));

        binaryTree.delete(2);
        System.out.println(binaryTree.size());
    }

    public static void TreeErgodic(){
        BinaryTree<String, String>tree=new BinaryTree<>();

        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");

        Queue<String> queue = tree.layerErgodic();
        for(String q : queue){
            System.out.println(q + "---" + tree.get(q));
        }

        System.out.println(tree.maxDepth());

    }

    public static void PagerFoldingTest(){
        //根节点为下折痕
        //左子结点为下折痕
        //右子结点为上折痕
        //模拟折纸过程
        Node<String> root = createTree(2);
        printTree(root);

        //遍历，打印每个结点
    }
    //模拟产生树
    public static Node<String> createTree(int N){
        //定义根结点
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            //1.当前是第一次对折
            if(i == 0){
                root = new Node<String>("down", null, null);
                continue;
            }
            //2.当前不是第一次对折
            //定义一个辅助队列，福过层序益历的思想，找到叶子结点，叶子结点添加子节点
            Queue<Node<String>> queue = new Queue<>();
            queue.enqueue(root);
            //遍历队列
            while (!queue.isEmpty()){
                //从队列中弹出一个结点
                Node<String> n = queue.dequeue();
                //如果有左子结点，则把左子结点放人到队列中
                if(n.left != null) queue.enqueue(n.left);
                //如果有右子结点，则把右子结点放人到以列中
                if(n.right != null) queue.enqueue(n.right);
                //如果同时没有左子结点和右 Object 证明该节点是叶子结点，只需要给该范点添加左子结点和右子结点即可
                if(n.left == null && n.right == null){
                    n.left = new Node<String>("down", null, null);
                    n.right = new Node<String>("up", null, null);
                }
            }
        }

        return root;
    }
    //打印树
    public static void printTree(Node<String> root){
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.item + " ");
        printTree(root.right);
    }
    public static class Node<T>{
        public T item;
        public Node<T> left;
        public Node<T> right;

        public Node(T item, Node<T> left, Node<T> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    public static void HeapTest(){
        Heap<String> heap = new Heap<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");
        String result = null;
        while ((result = heap.delMax()) != null){
            System.out.print(result + "  ");
        }
    }

    public static void HeapSort(){
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }



    public static void MaxPriorityQueue(){
        MaxPriorityQueue<String> heap = new MaxPriorityQueue<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");
        String result = null;
        while ((result = heap.delMax()) != null){
            System.out.print(result + "  ");
        }
    }

    public static void IndexQueue(){
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);
        queue.insert(0,"A");
        queue.insert(1,"B");
        queue.insert(2,"C");
        queue.insert(3,"D");
        queue.insert(4,"E");

        queue.changeItem(1,"M");

        while (!queue.isEmpty()){
            int index = queue.delMin();
            System.out.print(index + "  ");
        }

    }

    public static void RedBlack(){
        RedBlackTree<String, String> redBlackTree = new RedBlackTree<>();

        redBlackTree.put("1","aa");
        redBlackTree.put("2","bb");
        redBlackTree.put("3","cc");
        redBlackTree.put("4","dd");

        System.out.println(redBlackTree.get("1"));
        System.out.println(redBlackTree.get("2"));
        System.out.println(redBlackTree.get("3"));
        System.out.println(redBlackTree.get("4"));
    }

    public static void UFTest(){
        UF_Tree_Weighted uf = new UF_Tree_Weighted(05);
        System.out.println("默认" + uf.count());
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("第一个要合并的元素");
            int p = scanner.nextInt();
            System.out.println("第二个要合并的元素");
            int q = scanner.nextInt();

            if(uf.connected(p, q)){
                System.out.println("已存在");
                continue;
            }
            uf.union(p, q);
            System.out.println("现有分组" + uf.count());
        }
    }

    public static void Traffic() throws Exception{
        //构建一个缓冲数据的BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(
                TreeTest.class.getClassLoader().getResourceAsStream("traffic.txt")));
        //读取第一行数据
        int totalNum = Integer.parseInt(br.readLine());
        //构建一个并查集对象
        UF_Tree_Weighted uf = new UF_Tree_Weighted(totalNum);
        //读取第二行数据
        int roadNum = Integer.parseInt(br.readLine());
        //循环读取数据
        for (int i = 0; i < roadNum; i++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);

            //调用并查集对象的union方法让两两相同
            uf.union(p, q);
        }
        //获取剩余的数量
        int roads = uf.count() - 1;
        System.out.println(roads);
    }

    public static void main(String[] args) throws Exception{
        //BinaryTreeTest();
        //TreeErgodic();
        //PagerFoldingTest();
        //HeapTest();
        //HeapSort();
        //MaxPriorityQueue();
        //IndexQueue();
        //RedBlack();
        //UFTest();
        Traffic();
    }


}
