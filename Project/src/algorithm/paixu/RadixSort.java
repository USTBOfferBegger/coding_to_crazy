package algorithm.paixu;

import java.util.Arrays;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: RadixSort
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 15:29 2020/7/22
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {421, 240, 115, 532, 305, 430, 124};
        sort(arr);
    }

    public static void sort(int[] arr){
        int[] result = new int[arr.length];
        int[] count = new int[10];

        //3最大位数3位
        for(int i = 0; i < 3; ++i){
            int position = (int) Math.pow(10, i);
            for (int value : arr) {
                value = value / position % 10;
                count[value]++;
            }
            for(int j = 1; j < count.length; ++j){
                count[j] = count[j] + count[j - 1];
            }
            for (int j = arr.length - 1; j >= 0; --j){
                System.out.println(arr[j]);
                int num = arr[j] / position % 10;
                result[--count[num]] = arr[j];
            }
            Arrays.fill(count, 0);
            print(result);
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
