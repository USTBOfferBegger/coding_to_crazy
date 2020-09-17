package algorithm.others;


public class Tte {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(Tte.searchInsert(nums, 5));
    }


    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int left = 0;
        int rigth = n;
        while(left < rigth){
            if(target < nums[left]){
                return left;
            }
            if(target > nums[rigth-1]){
                return rigth;
            }

            int mid = (left + rigth) >> 1;
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                rigth = mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }
        }

        return 0;
    }
}
