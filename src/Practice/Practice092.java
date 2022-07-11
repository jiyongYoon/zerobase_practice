package Practice;

// 프로그래머스 Lv.1 시저 암호
// https://programmers.co.kr/learn/courses/30/lessons/12926
public class Practice092 {
    public static String solution(String s, int n) {
        String answer = "";

        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if(Character.isAlphabetic(c[i])) {
                if(c[i] <= (int)'z' && c[i] >= (int)'a' && c[i] + n > (int)'z') {
                    c[i] = (char)('a' + (c[i] + n - (int)'z') - 1);
                } else if(c[i] <= (int)'Z' && c[i] >= (int)'A' && c[i] + n > (int)'Z') {
                    c[i] = (char)('A' + (c[i] + n - (int)'Z') - 1);
                } else {
                    c[i] = (char) (c[i] + n);
                }
            }
        }
        answer = new String(c);
        return answer;
    }

    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        System.out.println(solution(s, n));

        System.out.println('a' + ": "+(int)'a');
        System.out.println('z' + ": "+(int)'z');
        System.out.println('A' + ": " + (int)'A');
        System.out.println('Z' + ": " + (int)'Z');
    }
}

/*
[학습내용]
- 아스키코드는 int'a' 이런식으로 표현 가능.
- 소문자와 대문자 사이에 특수기호 틈이 있다.
 */