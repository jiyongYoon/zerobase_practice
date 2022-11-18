// 프로그래머스 Lv.1 콜라 문제
// https://school.programmers.co.kr/learn/courses/30/lessons/132267#

package Practice;

public class Practice161 {
    public static int solution(int a, int b, int n) {
        int answer = 0;

        while(n >= a) {
            int bring = n / a;
            int get = bring * b;
            answer += get;
            n = (n % a) + get;
        }

        return answer;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        int n = 20;
        System.out.println(solution(a, b, n));
    }
}
