// 백준 2468번 안전 영역
// https://www.acmicpc.net/problem/2468

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice130 {
    static int[][] grid;
    static int result = 1;
    static int n;
    static final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void solution(int min, int max) {
        for (int i = min + 1; i <= max; i++) {
            result = Math.max(check(i), result);
        }
        System.out.println(result);
    }

    public static int check(int checkHeight) {
        boolean[][] sink = new boolean[n][n];
        int areaCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] < checkHeight) {
                    sink[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!sink[i][j]) {
                    dfs(i, j, sink);
                    areaCnt++;
                }
            }
        }
        return areaCnt;
    }

    public static void dfs(int a, int b, boolean[][] sink) {
        for (int[] d : dir) {
            int x = a + d[0];
            int y = b + d[1];
            if(x >= 0 && x < n && y >= 0 && y < n && !sink[x][y]) {
                sink[x][y] = true;
                dfs(x, y, sink);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int min = 101;
        int max = 0;
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, grid[i][j]);
                max = Math.max(max, grid[i][j]);
            }
        }
        solution(min, max);
    }
}
