package algorithm.paixu;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: BubbleSort
 * @Author 李学翰
 * @Description: 冒泡法
 * @Data: Create in 17:57 2020/7/20
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {8, 5, 7, 9, 1, 3, 2, 4};
        for(int i = arr.length - 1; i > 0; --i){
            for(int j = 0; j < i; ++j){
                if(arr[j] > arr[j+1])
                    swap(arr, j, j + 1);
            }
        }
        print(arr);
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
