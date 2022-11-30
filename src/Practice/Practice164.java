// 프로그래머스 Lv.1 과일 장수
// https://school.programmers.co.kr/learn/courses/30/lessons/135808

package Practice;

/*
한 상자에 m개를 담아 포장
상자에 담긴 상자 중 가장 낮은 점수가 p점인 경우, 사과 한 상자의 가격은 p * m
 */

public class Practice164 {

    static int minVal;
    static int appleCnt;
    static int[] appleVal;
    static int idx;

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        int totalCnt = score.length;
        int times = totalCnt / m;
        appleVal = new int[k + 1];
        for (int i = 0; i < totalCnt; i++) {
            appleVal[score[i]]++;
        }
        idx = appleVal.length - 1;
        for (int i = 0; i < times; i++) {
            appleCnt = 0;
            put(m);
            answer += minVal * m;
        }

        return answer;
    }

    public static void put(int m) {
        if(appleCnt == m) {
            minVal = idx;
            return;
        }

//        for (int i = 1; i < appleVal.length; i++) {
//            System.out.print(appleVal[i] + " ");
//        }
//        System.out.println();

        if(appleVal[idx] + appleCnt == m) {
            appleCnt = m;
            appleVal[idx] = 0;
            put(m);
        } else if (appleVal[idx] + appleCnt > m) {
            appleVal[idx] -= m - appleCnt;
            appleCnt = m;
            put(m);
        } else {
            appleCnt += appleVal[idx];
            appleVal[idx] = 0;
            idx--;
            put(m);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int m = 4;
//        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(k, m, score));
    }
}
