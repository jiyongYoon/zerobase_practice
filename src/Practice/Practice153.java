// 프로그래머스 Lv.2 다음 큰 숫자
// https://school.programmers.co.kr/learn/courses/30/lessons/12911

package Practice;

public class Practice153 {
    public static int solution(int n) {
        int answer = 0;

        String nStr = Integer.toString(n, 2);
        int oneCnt = 0;
        for (int i = 0; i < nStr.length(); i++) {
            if(nStr.charAt(i) == '1') {
                oneCnt++;
            }
        }

        boolean Flag = false;
        int i = 1;
        int compareCnt = 0;
        while(true) {
            String tmpStr = Integer.toString(n + i, 2);
            for (int j = 0; j < tmpStr.length(); j++) {
                if(tmpStr.charAt(j) == '1') {
                    compareCnt++;
                }
            }

            if(compareCnt == oneCnt) {
                Flag = true;
                answer = n + i;
                break;
            } else {
                compareCnt = 0;
                i++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));
    }
}
