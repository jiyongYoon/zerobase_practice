package Practice;// 코딩테스트 이진탐색 문제
// 치킨 튀기는데 걸리는 시간 배열 fry[i]
// 튀기고 나면 세척하는데 걸리는 시간 배열 clean[i]
// N대의 튀김기, M마리 필요할 때 최소 몇시간 튀김기를 가동해야 하는지 구하기

import java.util.stream.IntStream;

public class Practice077 {
    public static int solution(int N, int M, int[] fry, int[] clean) {
        int answer = 0;
        int fryCnt = 0; // 튀긴 치킨 마리수
        int[] totalTime = new int[fry.length]; // clean + fry 시간
        int left = 0; // 제일 짧게 걸리는 시간
        int right = M * IntStream.range(0, fry.length)
                .map(x -> fry[x] + clean[x])
                .max().getAsInt(); // 제일 길게 걸리는 시간
        // totalTime 구하기
        for (int i = 0; i < fry.length; i++) {
            totalTime[i] = fry[i] + clean[i];
        }
        // 이분탐색
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            for (int i = 0; i < fry.length; i++) {
                fryCnt += (mid - fry[i]) / totalTime[i] ;
            }
            // 치킨이 더 많이 나오면 시간 줄여보기
            if(fryCnt >= M) {
                right = mid - 1;
                answer = mid;
            } else { // 치킨이 부족하면 더 오래 튀기기
                left = mid + 1;
            }
            fryCnt = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 2;
        int M = 20;
        int[] fry = {3, 6};
        int[] clean = {2, 1};
        System.out.println(solution(N, M, fry, clean));

        N = 4;
        M = 2;
        fry = new int[]{2,2,1,3};
        clean = new int[]{2, 4, 3, 2};
        System.out.println(solution(N, M, fry, clean));

    }
}
