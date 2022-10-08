// 프로그래머스 Lv.2 2개 이하로 다른 비트
// https://school.programmers.co.kr/learn/courses/30/lessons/77885

/*
아이디어
1. 해당 숫자의 2진수에서 일의자리부터 0이 하나라도 있으면 그걸 1로 바꾸면 나오는 수가 정답
2. 해당 숫자의 2진수의 일의자리부터 모두 1일 경우, 가장 끝자리 하나를 1로 올리고, 그 다음은 0, 그리고 나머지는 1로
   바꾸면 나오는 수가 정답
 */

package Practice;

public class Practice150 {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }

            String binaryLong = getBinaryLong(numbers[i]);
            int zeroIdx = -1;
            for (int j = binaryLong.length() - 1; j >= 0; j--) {
                if(binaryLong.charAt(j) == '0') {
                    zeroIdx = binaryLong.length() - 1 - j;
                    break;
                }
            }
            if(zeroIdx != -1) {
                long plusTmp = (long)Math.pow(2, zeroIdx);
                long minusTmp = (long)Math.pow(2, zeroIdx - 1);
                answer[i] = numbers[i] + plusTmp - minusTmp;
                continue;
            }

            long tmp = 0;
            for (int j = 0; j < binaryLong.length() + 1; j++) {
                tmp += Math.pow(2, j);
            }
            long minusTmp = (long) Math.pow(2, binaryLong.length() - 1);
            answer[i] = tmp - minusTmp;
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        return answer;
    }

    public static String getBinaryLong(long a) {
        String result = "";
        while(a >= 1) {
            result = (a % 2) + result;
            a = a / 2;
        }
        return result;
    }

    public static long[] solution2(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String numberString = Long.toString(numbers[i], 2);
                int lastZeroIndex = numberString.lastIndexOf("0");
                if (lastZeroIndex != -1) {
                    numberString =
                        numberString.substring(0, lastZeroIndex) + "10" + numberString.substring(
                            lastZeroIndex + 2, numberString.length());
                } else {
                    numberString = "10" + numberString.substring(1, numberString.length());
                }
                answer[i] = Long.parseLong(numberString, 2);
            }
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        return answer;
    }

    public static void main(String[] args) {
        long[] a = {11};
        System.out.println(solution(a));
        System.out.println(solution2(a));
    }
}
