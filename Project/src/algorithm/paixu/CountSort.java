package algorithm.paixu;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: CountSort
 * @Author 李学翰
 * @Description:  计数排序，最大值<10
 * @Data: Create in 17:35 2020/7/21
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class CountSort {
    public static void main(String[] args) {
        int[] arr = {5,1,2,3,2,1,2,3,4,5,6,7,8,9,3,3,2,1,1,1,7,6,5,4,3,4,5,6,7,8,0,1};
        sort(arr);
    }

    public static void sort(int[] arr){
        int[] result = new int[arr.length];
        int[] count = new int[10];
        for (int value : arr) {
            count[value]++;
        }
//        for (int i = 0, j = 0; i < count.length; ++i){
//            while (count[i]-- > 0) result[j++] = i;
//        }
        for(int i = 1; i < count.length; ++i){
            count[i] = count[i] + count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; --i){
            result[--count[arr[i]]] = arr[i];
        }
        print(result);

    }

    public static void print(int[] arrs){
        for(int arr : arrs){
            System.out.print(arr + "  ");
        }
        System.out.println("");
    }
}
