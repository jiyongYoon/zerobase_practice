// 프로그래머스 Lv.2 할인행사
// https://school.programmers.co.kr/learn/courses/30/lessons/131127

package Practice;

import java.util.HashMap;

public class Practice152 {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int loop = 0;
        for (int i = 0; i < number.length; i++) {
            loop += number[i];
        }

        HashMap<String, Integer> wantIdxMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantIdxMap.put(want[i], i);
        }

        int[] discountNumber = new int[number.length];
        for (int i = 0; i <= discount.length - loop; i++) {
            boolean answerFlag = true;
            for (int j = 0; j < number.length; j++) {
                discountNumber[j] = number[j];
            }

            int loopIdx = i;
            for (int j = 0; j < loop; j++) {
                if(!wantIdxMap.containsKey(discount[loopIdx])) {
                    answerFlag = false;
                    break;
                }
                int idx = wantIdxMap.get(discount[loopIdx]);
                discountNumber[idx]--;
                if(discountNumber[idx] < 0) {
                    answerFlag = false;
                    break;
                }
                loopIdx++;
            }
            if(answerFlag) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want, number, discount));
    }

}
