package Practice;// 코딩테스트 연습문제
// 두 배열을 덧셈 세로식처럼 사용하기

import java.util.Arrays;

public class Practice045 {
    public static int[] solution(int[] a, int[] b) {
        int maxLength = Math.max(a.length, b.length); // 두 배열중 최대 길이
        int minLength = Math.min(a.length, b.length); // 두 배열중 최소 길이
        int[] answer = new int[maxLength]; // 정답배열은 두 배열의 최대길이만큼 생성
        int tmp = 0; // 자리수 올릴 때 사용할 변수
        for (int i = 0; i < minLength; i++) { // 두 배열에 자리수가 있을때까지(ex, 5자리 + 3자리 이면 3번 루프)
            if (a[a.length - 1 - i] + b[b.length - 1 - i] + tmp < 10) { // 각 숫자 + 올라온 자리수가 10보다 작으면
                answer[answer.length - 1 - i] = a[a.length - 1 - i] + b[b.length - 1 - i] + tmp; // 정답배열 맨 마지막부터 채우기
                tmp = 0; // 자리수 초기화
            } else { // 각 숫자 + 올라온 자리수
                answer[answer.length - 1 - i] = a[a.length - 1 - i] + b[b.length - 1 - i] + tmp - 10; // 합한 수의 1의자리 정답배열에 채우기
                tmp = 1; // 자리수 1 올리기
            }
        }
        for (int i = minLength; i < maxLength; i++) { // 자리수가 겹치지 않는 부분(ex, 5자리 + 3자리 이면 나머지 2자리 루프)
            if (a.length > b.length) { // a배열이 긴 경우
                if (tmp == 1) { // 올라온 자리수가 있는 경우
                    if (a[a.length - 1 - i] + tmp < 10) { // a배열 숫자와 자리수 합이 10이 안넘으면 정답배열에 채우기
                        answer[answer.length - 1 - i] = a[a.length - 1 - i] + tmp;
                        tmp = 0;
                    } else { // a배열 숫자와 자리수 합이 10이 넘으면
                        answer[answer.length - 1 - i] = a[a.length - 1 - i] + tmp - 10; // 정답배열에 1의 자리만 채우기
                        tmp = 1; // 자리수 또 넘기기
                    }
                } else { // 올라온 자리수가 없으면
                    answer[answer.length - 1 - i] = a[a.length - 1 - i] + tmp; // 정답배열에 그냥 a 배열 숫자와 자리수 합 채우기
                    tmp = 0;
                }
            } else { // b배열이 긴 경우 a와 마찬가지로
                if (tmp == 1) {
                    if (b[b.length - 1 - i] + tmp < 10) {
                        answer[answer.length - 1 - i] = b[b.length - 1 - i] + tmp;
                        tmp = 0;
                    } else {
                        answer[answer.length - 1 - i] = b[b.length - 1 - i] + tmp - 10;
                        tmp = 1;
                    }
                } else {
                    answer[answer.length - 1 - i] = b[b.length - 1 - i] + tmp;
                    tmp = 0;
                }
            }
        }

        if (tmp == 1) { // 만약 자리수가 아직 남았다. 즉, 맨 앞에 한자리가 더 올라가야되는 경우
            int[] newAnswer = new int[answer.length + 1]; // 기존 배열보다 1개 더 긴 새로운 배열 생성
            for (int i = 0; i < answer.length; i++) { // 새로운 배열에 기존배열 숫자를 넣고
                newAnswer[i + 1] = answer[i];
            }
            newAnswer[0] = tmp; // 새로운 배열 맨 앞자리에 올라온 자리수 넣어줌
            System.out.println(Arrays.toString(newAnswer));
            return newAnswer;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 1, 4, 6};
        int[] b = {6, 1, 0, 4, 4};
        solution(a, b);
        int[] c = {9, 9, 9};
        int[] d = {1};
        solution(c, d);
    }
}
/*
[학습내용]
배열끼리 덧셈처럼 활용하는 경우, 그냥 자리수만 변수로 따로 뺴고 각 배열끼리 계산해주자.
정수로 변환해서 계산하고 다시 배열에 넣으면 엄청 비효율적임.

 [이 전에 제출했던 코드]
 숫자가 작을때는 문제 없지만, 커지면 자리수 계산이 엄청 오래걸림...

 class Solution {
    public int[] solution(int[] a, int[] b) {
        long x = 0;
        long y = 0;
        long ten = 10;
        //x만들기
        for (int i = 0; i < a.length; i++) {
            if(i==0) {
                x += a[a.length-1];
            } else {
                x += a[a.length-1-i]*ten;
                ten = ten * 10;
            }
        }
        ten = 10;
        //y만들기
        for (int i = 0; i < b.length; i++) {
            if(i==0) {
                y += b[b.length-1];
            } else {
                y += b[b.length-1-i]*ten;
                ten = ten * 10;
            }
        }
        //결과와 자리수 구하기
        long result = x + y;
        long resultTmp = result;
        int resultLength = 0;
        while(resultTmp>0) {
            resultTmp = resultTmp/10;
            resultLength++;
        }

        int[] answer = new int[resultLength];

        String resultStr = Long.toString(result);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(resultStr.substring(i,i+1));
        }
        for (int item :
                answer) {
            System.out.print(item);
        }
        return answer;
    }
}

 */