package algorithm.paixu;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: XuanZePaiXu
 * @Author 李学翰
 * @Description: 选择排序，不稳定
 * @Data: Create in 17:27 2020/7/20
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class Selector {
    public static void main(String[] args) {
        int arr[] = {8, 5, 7, 9, 1, 3, 2, 4};
        for (int i = 0; i < arr.length - 1; ++i){
            int minPos = i;
            for (int j = i + 1; j < arr.length; ++j){
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
            System.out.println("交换" + i + "次后的结果为：");
            print(arr);
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
