package algorithm.aTest;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: TtM
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 21:14 2020/8/24
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class TtM {
    public static void Solution(int A, int B, int a, int b){
        int k = 1; //公约数
        int smaller = Math.min(a, b);
        for (int i = 1; i <= smaller; i++) {
            if (a % i == 0 && b % i == 0) {
                k = i;
            }
        }
        a = a / k;
        b = b / k;
        int step = A * b > B * a ? B / b : A / a;
        if(step == 0) {
            System.out.println(0 + "-" + 0);
            return;
        }
        int x = a * step;
        int y = b * step;
        System.out.println(x + "*" + y + "=" + x * y);
    }
    public static void main(String[] args) {
        Solution(8, 7, 99, 66);
        Solution(1, 1, 2, 1);
        Solution(1000, 500, 98, 33);
        Solution(108989, 222342, 2231, 332);
    }
}
