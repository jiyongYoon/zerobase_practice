// 프로그래머스 Lv.2 최댓값과 최솟값
// https://school.programmers.co.kr/learn/courses/30/lessons/12939

package Practice;

import java.util.Arrays;

public class Practice148 {
    public static String solution(String s) {

        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);

        return "" + arr[0] + " " + arr[arr.length - 1];
    }

    public static void main(String[] args) {
        String s = "-1 -1";
        System.out.println(solution(s));
    }
}
