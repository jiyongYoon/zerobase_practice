// 백준 1012번 유기농 배추
// https://www.acmicpc.net/problem/1012

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice068 {
    public static int m, n, k, cnt;
    public static int[][] grid;
    public static void dfs(int a, int b) {
        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        // 동서남북 돌면서
        for (int[] d: dir) {
            int x = a + d[0];
            int y = b + d[1];
            // 1이면 0으로 바꾸고 dfs 재귀호출
            if(x>=0 && y>=0 && x<m && y<n && grid[x][y] == 1) {
                grid[x][y] = 0;
                dfs(x, y);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++) {
            cnt = 0;
            String[] str = (br.readLine()).split(" ");
            m = Integer.parseInt(str[0]); // 가로길이
            n = Integer.parseInt(str[1]); // 세로길이
            k = Integer.parseInt(str[2]); // 배추 수

            grid = new int[m][n]; // 배추밭
            // for문 돌면서 배추 심기
            for (int j = 0; j < k; j++) {
                String[] s = (br.readLine()).split(" ");
                int xIdx = Integer.parseInt(s[0]);
                int yIdx = Integer.parseInt(s[1]);
                grid[xIdx][yIdx] = 1;
            }
            // for문 돌면서 배추심겨져 있으면 dfs 순회
            // 나오면 배추벌래 1마리 추가
            for (int k = 0; k < m; k++) {
                for (int j = 0; j < n; j++) {
                    if (grid[k][j] == 1) {
                        dfs(k, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
