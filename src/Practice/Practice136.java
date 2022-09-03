// 프로그래머스 Lv.1 하샤드 수
// https://school.programmers.co.kr/learn/courses/30/lessons/12947

package Practice;

public class Practice136 {
    public static boolean solution(int x) {
        double xCopy = x;
        double sum = 0;
        while(x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        double a = Math.ceil(xCopy / sum);
        double b = Math.floor(xCopy / sum);
        if(a == b) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(solution(13));
    }
}
