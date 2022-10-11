// 프로그래머스 Lv.2 최솟값 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12941

package Practice;

import java.util.Arrays;

public class Practice155 {
    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
