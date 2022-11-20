// 프로그래머스 Lv.1 숫자 짝궁
// https://school.programmers.co.kr/learn/courses/30/lessons/131128

package Practice;

public class Practice162 {
    public static String solution(String X, String Y) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for (int i = 0; i < X.length(); i++) {
            xArr[Integer.parseInt(String.valueOf(X.charAt(i)))]++;
        }

        for (int i = 0; i < Y.length(); i++) {
            yArr[Integer.parseInt(String.valueOf(Y.charAt(i)))]++;
        }

        int idx = 9;
        while(idx >= 0) {
            if(xArr[idx] > 0 && yArr[idx] > 0) {
                int times = Math.min(xArr[idx], yArr[idx]);
                for (int i = 0; i < times; i++) {
                    sb.append(idx);
                }
            }
            idx--;
        }

        answer = sb.toString();

        if(answer.equals("")) {
            return "-1";
        }

        if(answer.startsWith("0")) {
            return "0";
        }

        return answer;
    }


    public static void main(String[] args) {

    }

}
