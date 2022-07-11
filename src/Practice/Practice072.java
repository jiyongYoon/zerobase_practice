package Practice;// 백준 1520번
// https://www.acmicpc.net/problem/1520
// 메모리 초과가 나옴
// DP 알고리즘이 추가로 필요한 상황

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice072 {
    public static int[][] grid;
    public static int m, n, answer;
    public static void bfs(int a, int b) {
        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int[] d : dir) {
            int x = a + d[0];
            int y = b + d[1];
            // 범위 안에 있고, 숫자가 작은 경우
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[a][b] > grid[x][y]) {
                if(x==grid.length-1 && y==grid[0].length-1) {
                    answer++;
                    return;
                } else {
                    bfs(x, y);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        m = Integer.parseInt(str[0]);
        n = Integer.parseInt(str[1]);
        grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(s[j]);
            }
        }
        // 0,0부터 시작
        bfs(0,0);
        System.out.println(answer);
    }
}
