package algorithm.aTest;

import java.util.*;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: InTest
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 17:01 2020/8/14
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class InTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        String[] strs = new String[M];
        for(int i = 0; i < M; i++){
            strs[i] = sc.next();
        }
        Solution(M, strs);
    }

    static void Solution(int M, String[] strs){
        for(String str : strs){
            int len = str.length();
            int max = 0;
            int i = 0, j = 1;
            while (j < len){
                if(str.charAt(i) != str.charAt(j)){
                    max = Math.max(max, j - i);
                    i = j;
                }
                j++;
            }
            max = Math.max(max, j - i); //修改前最大长度
            //修改值为左右两侧的值
            //先判断左右边
            //第一位改为第二位，找个最大值
            int afterMax = 0;
            if(str.charAt(0) != str.charAt(1)){
                afterMax = 2;
                int left = 1;
                while(str.charAt(left) == str.charAt(left + 1)){
                    afterMax++;
                    left++;
                }
            }
            max = Math.max(max, afterMax);
            //最后一位改为最后二位
            if(str.charAt(len - 1) != str.charAt(len - 2)){
                afterMax = 2;
                int right = len - 2;
                while(str.charAt(right) == str.charAt(right - 1)){
                    afterMax++;
                    right--;
                }
            }
            max = Math.max(max, afterMax);
            //中间位有两种改变方法
            for(int m = 1; m < len - 1; m++){
                if(str.charAt(m - 1) != str.charAt(m)){
                    afterMax = maxLength(str, m, str.charAt(m - 1));
                    max = Math.max(max, afterMax);
                }
                if(str.charAt(m + 1) != str.charAt(m) && str.charAt(m + 1) != str.charAt(m - 1)){
                    afterMax = maxLength(str, m, str.charAt(m + 1));
                    max = Math.max(max, afterMax);
                }
            }
            System.out.println(max);
        }
    }
    //index拓展后的最大长度，以index为中心
    public static int maxLength(String str, int index, char value){
        int max = 1;
        int left = index, right = index;
        while(left > 0 && value == str.charAt(left - 1)){
            max++;
            left--;
        }
        while(right < str.length() - 1 && value == str.charAt(right + 1)){
            max++;
            right++;
        }
        return  max;
    }

}
