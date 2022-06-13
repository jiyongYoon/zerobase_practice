package Practice;// 연습문제
// 원에 N개의 풍선을 터트리는 순서 출력 프로그램
// 풍선안에는 다음 터트릴 풍선 위치가 있음

import java.util.Arrays;

public class Practice054 {
    public static void solution(int[] arr) {
        boolean[] boom = new boolean[arr.length]; // 터졌다는 플레그
        int[] result = new int[arr.length]; // 결과배열
        int idx = 1; // 돌아다닐 인덱스

        for (int i = 0; i < result.length; i++) {
            result[i] = idx; // 값 추가
            boom[idx-1] = true; // 터졌다는 플레그
            if(result[result.length-1]>0) { // 결과 배열 마지막까지 다 차면 탈출
                break;
            }
            int arridx = arr[idx-1]; // while문 안에서 돌 변수 (idx를 왔다갔다 하다보니 고정된 변수가 필요)
            int cnt = 0; // 실제로 움직인 개수 카운트
            while (cnt != Math.abs(arridx)) {
                if(arridx>=0) {
                    idx = (idx == arr.length) ? 1 : idx + 1; // 원이기 때문에 5 다음에는 1로 넘어가도록
                } else {
                    idx = (idx == 1) ? arr.length : idx-1 ; // 원이기 때문에 1 다음에는 5로 넘어가도록
                }
                if(!boom[idx-1]) { // 안터진 풍선이면 실제로 움직인 개수 카운트
                    cnt++;
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
//        solution(new int[]{3,2,1,-3,-1});
        solution(new int[]{3,2,-1,-2});
    }
}

/*
[학습내용]
1. while 조건문에 while 안에서 변하는 변수를 사용하면 꼬임.
2. 일정 범위 내에서 결과를 돌리는 방법
    1) 나머지 연산
    2) 강제 할당 (이번 문제풀이처럼)
    3) LinkedList 구현 등
 */
