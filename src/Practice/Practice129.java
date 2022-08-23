// 프로그래머스 Lv.1 예산
// https://school.programmers.co.kr/learn/courses/30/lessons/12982

package Practice;

import java.util.Arrays;

public class Practice129 {
    static int result = 0;

    public static int solution2(int[] d, int budget) {
        Arrays.sort(d);
        int totalPay = 0;
        for (int i = 0; i < d.length; i++) {
            totalPay += d[i];
            if(budget == totalPay) {
                return i;
            } else if(budget < totalPay) {
                return i - 1;
            }
        }
        return d.length;
    }

    public static int solution(int[] d, int budget) {
        boolean visited[] = new boolean[d.length];

        int tmp = 0;
//        for (int i = 0; i < d.length; i++) {
//            tmp += d[i];
//        }
//        if(tmp <= budget) {
//            return d.length;
//        }

        recur(0, 0, d, budget, visited, 0);

        return result;
    }

    public static void recur(int cnt, int totalPay, int[] d, int budget, boolean[] visited, int start) {
        if(totalPay >= budget) {
            if(totalPay == budget) {
                result = cnt;
                return;
            }

            if(cnt - 1 > result) {
                result = cnt - 1;
                return;
            }
        }

        for (int i = start; i < d.length; i++) {
            if(d.length - i < result) {
                break;
            }
            if(!visited[i]) {
                visited[i] = true;
                totalPay = totalPay + d[i];
                recur(cnt + 1, totalPay, d, budget, visited, start + 1);
                visited[i] = false;
                totalPay = totalPay - d[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;

        System.out.println(solution(d, budget));
    }
}

/*
[학습내용]
정렬이 가능한 범위면 정렬을 해서 풀어내는게 훨씬 깔끔할 수 있다.
 */
