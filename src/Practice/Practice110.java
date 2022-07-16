// 백준 11048 이동하기
// https://www.acmicpc.net/problem/11048

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice110 {
    static int[][] grid;
    public static long solution(int n, int m) {
        long[][] dp = new long[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(n, m));
    }
}

/*
[학습내용]
간혹 테스트케이스가 악랄할 때가 있다..
첫째줄도 dp를 진행해주어야 한다.
 */