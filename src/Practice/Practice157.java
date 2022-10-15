// 프로그래머스 Lv.2 멀리 뛰기
// https://school.programmers.co.kr/learn/courses/30/lessons/12914

package Practice;

public class Practice157 {
    public static long solution(int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i-2] + arr[i-1];
            if(arr[i] > 1234567) {
                arr[i] = arr[i] % 1234567;
            }
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }
}
