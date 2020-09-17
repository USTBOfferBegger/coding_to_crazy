package algorithm.paixu;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: QuickSort
 * @Author 李学翰
 * @Description: 快速排序，双轴快排
 * @Data: Create in 14:22 2020/7/21
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 8, 1, 7, 9, 4, 6, 10, 6, 0, 12};
        sort(arr, 0, arr.length - 1);

        print(arr);
    }

    public static void sort(int[] arr, int leftBound, int rightBound){
        if(leftBound >= rightBound) return;
        int mid = partition(arr, leftBound, rightBound);
        sort(arr, leftBound, mid - 1);
        sort(arr, mid + 1, rightBound);
    }

    public static int partition(int[] arr, int leftBound, int rightBound){
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right){
            if(arr[left] <= pivot) left++;
            if(left <= right && arr[right] > pivot) right--;

            if(left < right && arr[left] > pivot && arr[right] <= pivot) swap(arr, left, right);
        }
        swap(arr, left, rightBound);
        return left;
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
