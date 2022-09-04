// 프로그래머스 Lv.2 올바른 괄호
// https://school.programmers.co.kr/learn/courses/30/lessons/12909

package Practice;

public class Practice138 {
    boolean solution(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                result++;
            } else {
                result--;
            }
            if(result < 0) {
                return false;
            }
        }

        if(result == 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
