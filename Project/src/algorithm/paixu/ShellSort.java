package algorithm.paixu;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: ShellSort
 * @Author 李学翰
 * @Description: 希尔排序，设置递减的间隔排序；
 *               间隔大，移动少；间隔小，移动快
 * @Data: Create in 23:21 2020/7/20
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        sort(arr);
        print(arr);
    }

    public static void sort(int[] arr){
        int h = 1;
        while (h <= arr.length /3){
            h = h*3 + 1;
        }
        for(int gap = h; gap > 0; gap = (gap-1)/3){
            for(int i = gap; i < arr.length; ++i){
                int j = i;
                int temp = arr[i];
                for(; j > gap-1 && temp < arr[j-gap]; j -= gap){
                    arr[j] = arr[j-gap];
                    //swap(arr, j, j-1);
                }
                arr[j] = temp;
            }
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
