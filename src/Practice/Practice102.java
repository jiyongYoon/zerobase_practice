package Practice;
// 백준 1057 토너먼트
// https://www.acmicpc.net/problem/1057

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int answer = 0;

        while(n > 0) {
            n = n / 2;
            k = (int)Math.round((double)k / 2);
            l = (int)Math.round((double)l / 2);
            answer++;
            if(k == l) {
                System.out.println(answer);
                return;
            }
        }
        System.out.println("-1");
    }
}
