// 프로그래머스 Lv.1
// 숫자 문자열과 영단어
import java.util.HashMap;

public class Practice050 {
    public static int solution(String s) {
        String answer = "";
        String tmp = "";

        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                answer += s.charAt(i);
            } else {
                tmp += s.charAt(i);
            }
            if (map.containsKey(tmp)) {
                answer += map.get(tmp);
                tmp = "";
            }
        }
        return Integer.parseInt(answer);
    }

/* 다른풀이
        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] alphabets = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(alphabets[i], digits[i]);
        }
        return Integer.parseInt(s);
    }
*/

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"	));
        System.out.println(solution("2three45sixseven"	));
    }
}
/*
[학습내용]
한번에 바꾸는 것은 replace로 대체 가능.
 */