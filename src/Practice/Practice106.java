// 백준 11053번 가장 긴 증가하는 부분 수열
// https://www.acmicpc.net/problem/11053

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice106 {
    static int[] arr;
    public static int solution(int n) {
        int[] dp = new int[n];
        int answer = 1;
        dp[0] = 1;
        int beforeMaxDp = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) {
                beforeMaxDp = 0;
            }

            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    beforeMaxDp = Math.max(beforeMaxDp, dp[j]);
                }
            }
            if(arr[i] == arr[i - 1]) {
                dp[i] = beforeMaxDp;
            } else {
                dp[i] = ++beforeMaxDp;
            }
            answer = Math.max(answer, beforeMaxDp);
        }
        return answer;
    }

    public static int solution2(int n) {
        int[] dpp = new int[n + 1];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            dpp[i] = 1;
            for (int j = 1; j < i; j++) {
                if(arr[j - 1] < arr[i - 1]) {
                    dpp[i] = Math.max(dpp[i], dpp[j] + 1);
                }
            }
            result = Math.max(result, dpp[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n));
    }

}
