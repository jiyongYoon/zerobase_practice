// 프로그래머스 Lv.1 명예의 전당(1)
// https://school.programmers.co.kr/learn/courses/30/lessons/138477

package Practice;

import java.util.PriorityQueue;

public class Practice165 {

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> honor = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            honor.add(score[i]);

            if(honor.size() > k) {
                honor.poll();
            }

            answer[i] = honor.peek();
        }

        return answer;
    }

}
