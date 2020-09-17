package algorithm.paixu;


import java.nio.channels.Selector;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: InsertionSort
 * @Author 李学翰
 * @Description: 插入排序，对基本有序的数组最好用
 * @Data: Create in 22:37 2020/7/20
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr  = {8, 5, 7, 9, 1, 3, 2, 4};
        sort(arr);
        print(arr);

    }

    public static void sort(int[] arr){
        for(int i = 1; i < arr.length; ++i){
            int j = i;
            int temp = arr[i];
            for(; j > 0 && temp < arr[j-1]; --j){
                arr[j] = arr[j-1];
                //swap(arr, j, j-1);
            }
            System.out.println(j);
            arr[j] = temp;
            print(arr);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arrs){
        for(int arr : arrs){
            System.out.print(arr + "  ");
        }
        System.out.println("");
    }
}
