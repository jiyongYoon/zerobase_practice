// 프로그래머스 Lv.1 신규 아이디 추천
// https://school.programmers.co.kr/learn/courses/30/lessons/72410

package Practice;

public class Practice127 {
    public static String solution(String new_id) {
        String tmp = new_id.toLowerCase();
        StringBuffer sb = new StringBuffer(tmp);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(!Character.isDigit(c) && !Character.isAlphabetic(c) && c != '-' && c != '_' && c != '.') {
                sb.deleteCharAt(i);
                i--;
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(i + 1 < sb.length() && c == '.' && sb.charAt(i + 1) == '.') {
                sb.deleteCharAt(i);
                i--;
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if((i == 0 && c == '.') || (i == sb.length() - 1 && c == '.')) {
                sb.deleteCharAt(i);
                i--;
            }
        }

        if(sb.length() == 0) {
            sb.append('a');
        }

        String answer = "";
        if(sb.length() >= 16) {
            if(sb.charAt(14) == '.') {
                answer = sb.substring(0, 14);
            } else {
                answer = sb.substring(0, 15);
            }
        } else {
            answer = sb.toString();
        }

        if(answer.length() == 2) {
            answer = answer + answer.substring(1, 2);
        } else if(answer.length() == 1) {
            answer = answer + answer + answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmn.p";
        System.out.println(solution(s));
    }
}

/*
[학습내용]
1. sb.length는 계속 변하기 때문에 for문 돌때 유의하여 사용.
2. sb에서 문자열을 1개 지우면 인덱스도 1개 뒤로 가야 함.
 */
