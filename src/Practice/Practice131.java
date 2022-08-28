// 백준 1105번 팔
// https://www.acmicpc.net/problem/1105

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice131 {
    public static void solution(int L, int R) {
        int answer = 0;
        String lStr = Integer.toString(L);
        String rStr = Integer.toString(R);
        int lLength = lStr.length();
        int rLength = rStr.length();

        int length = rLength - lLength;

        if(length != 0) {
            System.out.println(0);
            return;
        }

        if(L == R) {
            for (int i = 0; i < rLength; i++) {
                if(rStr.charAt(i) == '8') {
                    answer++;
                }
            }
            System.out.println(answer);
            return;
        }

        int idx = 0;
        while(idx < rLength) {
            if(lStr.charAt(idx) == rStr.charAt(idx)) {
                if(lStr.charAt(idx) == '8') {
                    answer++;
                }
                idx++;
            } else {
                break;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        solution(L, R);
    }
}
