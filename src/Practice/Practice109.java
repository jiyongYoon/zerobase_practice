// 백준 9095번 1,2,3 더하기
// https://www.acmicpc.net/problem/9095

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice109 {

    public static int solution(int k) {
        int[] dp = new int[k > 3 ? k + 1 : 4];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        if(k < 4) {
            return dp[k];
        }
        for (int i = 4; i <= k; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[k];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(solution(Integer.parseInt(br.readLine())));
        }
    }
}
