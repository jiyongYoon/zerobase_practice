// 백준 2839번 설탕 배달
// https://www.acmicpc.net/problem/2839

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice112 {
    public static void solution(int n) {
        int maxCnt5kg = n / 5;
        int answer = 0;
        for (int i = maxCnt5kg; i >= 0; i--) {
            answer = 0;
            int tmpN = n;
            int maxCnt3kg = 0;
            answer = i;
            tmpN = tmpN - (i * 5);
            while(tmpN > 0) {
                tmpN = tmpN - 3;
                answer++;
            }

            if(tmpN == 0) {
                System.out.println(answer);
                return;
            }
        }
        System.out.println("-1");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }

}
