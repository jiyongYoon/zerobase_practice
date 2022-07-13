// 백준 2193번 이친수
// https://www.acmicpc.net/problem/2193

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice104 {
    public static long solution(int n) {
        long[] pArr = new long[n > 2 ? n + 1 : 3];
        pArr[0] = 0;
        pArr[1] = 1;
        pArr[2] = 1;

        for (int i = 3; i <= n; i++) {
            pArr[i] = pArr[i-1] + pArr[i-2];
        }
        return pArr[n];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }
}
