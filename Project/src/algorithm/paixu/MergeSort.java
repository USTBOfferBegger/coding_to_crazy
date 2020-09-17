package algorithm.paixu;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: MergeSort
 * @Author 李学翰
 * @Description: 归并排序
 * @Data: Create in 9:43 2020/7/21
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};
        //int[] arr = {1, 4, 7, 8, 3, 6, 9};
        sort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void sort(int[] arr, int left, int right){
        if(left == right) return;
        //分成两块
        int mid = left + (right - left)/2;
        //左边排序
        sort(arr, left, mid);
        //右边排序
        sort(arr, mid + 1, right);
        merge(arr, left, mid + 1, right);
    }

    public static void merge(int[] arr, int leftPtr, int rightPtr, int rightRound){
        int[] temp = new int[rightRound - leftPtr + 1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i < rightPtr && j <= rightRound){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i < rightPtr) temp[k++] = arr[i++];
        while (j <= rightRound) temp[k++] = arr[j++];

        for (int m = 0; m < temp.length; ++m) arr[leftPtr + m] = temp[m];

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
