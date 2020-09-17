package algorithm.others;

import java.util.Arrays;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: Solution
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 16:04 2020/7/17
 * @Version: *
 * 你只管开车办法由老爹来想
 *
 */
public class Solution {
    public static void main(String[] args) {
        //changeCharacter();
        //int[] nums = new int[]{3,1,5,8};
        //System.out.println(MaxCoins.maxCoins(nums));
        //System.out.println(Arrays.toString(makeNo(7)));
    }

    public static int[] makeNo(int size){
        if(size == 1){
            return new int[] {1};
        }
        int halfSize = (size + 1)/2;
        int[] base = makeNo(halfSize);
        //base 递归到size=1
        int[] ans = new int[size];
        int index = 0;
        for(; index < halfSize; ++index){
            ans[index] = base[index]*2 + 1;
        }
        for (int i = 0; index < size; ++index, ++i){
            ans[index] = base[index - halfSize]*2;
        }

        return ans;
    }


    /**
    已知字符串abcdefghij,定义左侧字符串长度，左侧与右侧交换，如左侧长度为6，
     交换后为ghijabcdef
     */
    public static void changeCharacter(){
        String str = "abcdefghijk";
        int leftSize = 7;
        //System.out.println(rotate1(str, leftSize));
        System.out.println(rotate2(str, leftSize));
    }
    /**
     * 左侧逆序，右侧逆序，总体逆序
     * @param str
     * @param leftSize
     * @return
     */
    public static String rotate1(String str, int leftSize){
        if(leftSize <= 0 && leftSize >= str.length()){
            return str;
        }
        char[] s = str.toCharArray();
        return process1(s, 0, leftSize - 1, str.length() - 1);
    }
    public static String process1(char[] str, int L, int M, int R){
        //左侧逆序
        reverse(str, L, M);
        //右侧逆序
        reverse(str, M+1, R);
        //总体逆序
        reverse(str, L, R);
        return String.valueOf(str);
    }
    //逆序代码
    public static void reverse(char[] str, int L, int R){
        while (L < R){
            char temp = str[L];
            str[L++] = str[R];
            str[R--] = temp;
        }
    }

    /**
     * 采用递归
     * 左右两侧短的一部分与长的一部分相同长的的交换
     * 直到剩余两侧长度的相同，交换位置则停止
     */
    public static String rotate2(String str, int leftSize){
        if(leftSize <= 0 && leftSize >= str.length()){
            return str;
        }
        char[] s = str.toCharArray();
        process2(s, 0, str.length() - 1, leftSize, str.length() - leftSize);
        return String.valueOf(s);
        //return process1(s, 0, leftSize - 1, str.length() - 1);
    }

    public static void process2(char[] str, int L, int R, int leftSize, int rightSize){
        int size = Math.min(leftSize, rightSize);
        System.out.println(leftSize + "--" + rightSize);
        if(leftSize == rightSize){
            exchange(str, L, R, size);
            return;
        }
        exchange(str, L, R, size);
        if(leftSize > rightSize){
            L += size;
            process2(str, L, R, leftSize - size, size);
        }else {
            R -= size;
            process2(str, L, R, size, rightSize - size);
        }

    }

    public static void exchange(char[] str, int L, int R, int size){
        int moveR = R - size + 1;
        char temp = 0;
        while (size-- != 0){
            temp = str[L];
            str[L++] = str[moveR];
            str[moveR++] = temp;
        }
    }
}

class MaxCoins{
    public static int[][] rec;
    public static int[] val;

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        rec = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        return solve(0, n + 1);
    }

    public static int solve(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }

}


