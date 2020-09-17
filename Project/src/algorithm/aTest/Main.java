package algorithm.aTest;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: Main
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 11:37 2020/8/21
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        List<Integer>[] nums = new List[C];
        for(int i = 0; i < C; i++){
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            list.add(num);
            for(int j = 1; j <= num; j++){
                list.add(sc.nextInt());
            }
            nums[i] = list;
        }
        /****************************************/

        for(int i = 0; i < C; i++){
            List<Integer> list = nums[i];
            int num = list.get(0);
            if(num < 3) System.out.println(0);
            int re = 0;
            for(int k = 1; k < num - 1; k++){
                re = Math.max(re, getMin(list, k));
                //System.out.println(re + "--");
            }
            System.out.println(re);
        }
    }

    public static int getMin(List<Integer> list, int left){
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < 3; j++){
            min = Math.min(min, list.get(left + j));
        }
        return min;
    }
}
