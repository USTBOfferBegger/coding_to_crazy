package algorithm.anewProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //
        int[] dp = new int[n];
        int[] count = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        count[0] = 1;
        count[1] = 1;
        int max = dp[1];
        for (int i = 2; i < n; i++) {
            //dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            if(dp[i - 1] >= dp[i - 2] + nums[i]){
                count[i] = count[i - 1];
                dp[i] = dp[i - 1];
            }else{
                count[i] = count[i - 2] + 1;
                dp[i] = dp[i - 2] + nums[i];
            }
        }
        System.out.print(dp[n - 1] + " ");
        System.out.println(count[n - 1]);
    }
}
