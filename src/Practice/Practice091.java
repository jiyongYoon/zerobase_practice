package Practice;// 백준 1541
// https://www.acmicpc.net/problem/1541
/*
1. 아이디어
부호가 + / - 밖에 없음. 가장 작은 숫자를 만들려면 - 이후에는 계속 빼면 됨
2. 시간복잡도
부호 사이의 각 숫자는 5자리가 최대
입력으로 주어지는 식의 길이는 50이하
for문에서 포인터를 이동해가며 연산을 함
=> 시간복잡도는 O(N)
3. 자료구조
입력받는 String: 1<= String <= 50
계산하는 숫자는 5자리 * 10번 더한다고 가정하면 최대 99,999 * 10 = 999,990 => int 가능
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice091 {
    public static void solution(String s) {
        if(s.length() == 0) {
            System.out.println("0");
            return;
        }

        int left = 0; // 숫자 범위를 지정할 인덱스
        int right = 0; // 숫자 범위를 지정할 인덱스
        boolean isMinus = false; // 부호 저장
        int answer = 0;

        while (right < s.length()) {
            if (Character.isDigit(s.charAt(right))) {
                right++;
                continue;
            }
            int tmp = Integer.parseInt(s.substring(left, right));
            if(isMinus == true) {
                answer -= tmp;
            } else {
                answer += tmp;
            }

            if(s.charAt(right)=='-') {
                isMinus = true;
            }
            left = right + 1;
            right = right + 1;
        }

        int tmp = Integer.parseInt(s.substring(left, right));
        if(isMinus == true) {
            answer -= tmp;
        } else {
            answer += tmp;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        solution(s);
    }
}
