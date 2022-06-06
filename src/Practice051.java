// 프로그래머스 Lv.1
// 없는 숫자 더하기
public class Practice051 {
    public static int solution(int[] numbers) {
        int answer = 0;

        boolean[] existFlag = new boolean[10];

        for (int i = 0; i < numbers.length; i++) {
            existFlag[numbers[i]] = true;
        }

        for (int i = 0; i < existFlag.length; i++) {
            if(existFlag[i]==false) {
                answer += i;
            }
        }
        return answer;
        /* 다른풀이 -> 전체에서 있는 숫자 빼기...
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
         */
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
        System.out.println(solution(new int[]{5,8,4,0,6,7,9}));
    }
}
/*
[학습내용]
반대로 생각하면 작업이 간단해지는 경우가 있음!!
 */