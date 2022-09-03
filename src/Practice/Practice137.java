// 프로그래머스 Lv.1 정수 제곱근 판별
// https://school.programmers.co.kr/learn/courses/30/lessons/12934

package Practice;

public class Practice137 {
    public static long solution(long n) {
        double tmp = Math.sqrt((double) n);
        if(Math.ceil(tmp) == Math.floor(tmp)) {
            tmp = tmp + 1;
            return (long)(tmp * tmp);
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(10));
        System.out.println(solution(121));

    }
}
