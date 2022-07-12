// 백준 1463번 1로 만들기
// https://www.acmicpc.net/problem/1463
package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice103 {
    public static int solution(int n) {
        int[] arr = new int[n > 3 ? n + 1 : 4];
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        if(arr[n] != 0) {
            return arr[n];
        }

        for (int i = 4; i <= n; i++) {
            arr[i] = arr[i - 1] + 1;
            if(i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }
            if(i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }
        }
        return arr[n];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }
}
