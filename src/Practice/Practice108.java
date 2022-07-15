// 백준 2579 계단 오르기
// https://www.acmicpc.net/problem/2579

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice108 {
    static int[] step;
    static long[] dp;
    public static long solution(int n) {
        if(n == 0) {
            return 0;
        }
        dp[1] = step[1];
        if(n >= 2) {
            dp[2] = dp[1] + step[2];
        }
        if(n < 3) {
            return dp[n];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + step[i - 1]) + step[i];
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        step = new int[n+1];
        dp = new long[n+1];
        for (int i = 1; i <= n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(n));
    }
}
