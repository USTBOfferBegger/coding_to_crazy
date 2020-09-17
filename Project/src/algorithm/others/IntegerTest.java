package algorithm.others;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class IntegerTest {
    public static void main(String[] args) {
//        Queue queue = new PriorityQueue();
//        queue.offer(12);
//        queue.offer(12);
//        queue.offer(11);
//        queue.offer(10);
//
//        for(int i = 0; i < 4; i++){
//            //System.out.println(queue.peek());
//            System.out.println(queue.poll());
//        }
//String
        int[] input = new int[]{2,3,4,5,6,1,3,45,6,8,9,65,231,0,32};
        ArrayList<Integer> result = GetLeastNumbers_Solution(input, 5);
    }



    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if (k > length || k == 0) {
            return result;
        }
        //PriorityQueue<Integer> masHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> masHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("比较" + o1 + "--" + o2);
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < length; i++){
            if(masHeap.size() != k){
                masHeap.offer(input[i]);
            }else if(masHeap.peek() > input[i]){
                Integer temp = masHeap.poll();
                temp = null;
                masHeap.offer(input[i]);
            }

            System.out.println(masHeap.peek());
        }
        System.out.println("======================");
        for (Integer integer : masHeap){
            System.out.println(integer);
            result.add(integer);
        }

        System.out.println("======================");
        for(int i = 0; i < 5; i++){
            System.out.println(masHeap.poll());
        }

        return result;
    }
}
