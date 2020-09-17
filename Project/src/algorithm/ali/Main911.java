package algorithm.ali;

import java.util.Scanner;

public class Main911 {

    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        //

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(nums[i][j] == -1){
                    dfs(nums, i, j, new int[] {0, 0}, new boolean[n][m]);
                }
                System.out.print(nums[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void dfs(int[][] nums, int x, int y, int[] count, boolean[][] check){

        for(int i = 0; i < 4; i++){
            int hx = x + dx[i], hy = y + dy[i];
            if(hx < 0 || hx >= nums.length || hy < 0 || hy >= nums[0].length) continue;
            if(nums[hx][hy] != -1){
                count[0] += nums[hx][hy];
                count[1]++;
            }
        }

        for(int i = 0; i < 4; i++){
            int hx = x + dx[i], hy = y + dy[i];
            if(hx < 0 || hx >= nums.length || hy < 0 || hy >= nums[0].length || check[hx][hy]) continue;
            if(nums[hx][hy] == -1){
                check[hx][hy] = true;
                dfs(nums, hx, hy, count, check);
            }
        }

        nums[x][y] = count[0] / count[1];


    }
}
