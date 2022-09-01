// 프로그래머스 Lv.2 두 큐 합 같게 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/118667

package Practice;

import java.util.Deque;
import java.util.LinkedList;

public class Practice135 {
     public static class Node {
        long data;
        boolean dq1;

        public Node(long data, boolean dq1) {
            this.data = data;
            this.dq1 = dq1;
        }
    }
    public static long solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long q1Sum = 0;
        long q2Sum = 0;
        long checkSize = queue1.length;

        Deque<Node> dq1 = new LinkedList<>();
        Deque<Node> dq2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            long a = (long)queue1[i];
            long b = (long)queue2[i];
            q1Sum += a;
            q2Sum += b;
            dq1.offer(new Node(a, true));
            dq2.offer(new Node(b, false));
        }

        long target = (q1Sum + q2Sum) / 2;

        while(q1Sum != target) {
            if(q1Sum > q2Sum) {
                Node tmp = dq1.poll();
                if(tmp.dq1) {
                    checkSize--;
                }
                q1Sum -= tmp.data;
                q2Sum += tmp.data;
                dq2.offer(tmp);
            } else {
                Node tmp = dq2.poll();
                q2Sum -= tmp.data;
                q1Sum += tmp.data;
                dq1.offer(tmp);
            }
            answer++;
            if(checkSize == 0 && dq2.size() == queue1.length) {
                return -1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        System.out.println(solution(queue1, queue2));
    }
}
