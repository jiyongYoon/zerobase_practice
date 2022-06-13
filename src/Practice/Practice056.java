package Practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 연습문제
// 프린트 규칙에 따라 출력되는 순서 확인하기
public class Practice056 {
    public static int solution(int docNum, int idx, int[] arr) {
        Queue<Integer> mail = new LinkedList<>();
        int answer = 0; // 출력 순서
        int target = arr[idx]; // 목표 우선순위

        for (int i = 0; i < arr.length; i++) { // 메일 큐에 우선순위 할당
            mail.add(arr[i]);
        }
        Arrays.sort(arr); // 우선순위 정렬

        int i = 1; // 배열 한칸씩 당길 용도로 사용할 변수
        while(mail.size()!=0) { // 메일 다 보낼떄까지 루프
            while(mail.peek() != arr[arr.length-i]) { // 우선순위 가장 높은게 아닐때까지
                mail.add(mail.poll()); // 메일 꺼내서 맨 뒤로
                idx = (idx>0) ? idx - 1 : docNum - 1; // 출력 대상번호 꼬리표
            }
            i++;
            if(mail.peek() == target && idx == 0) { // 만약 목표 우선순위와 출력 대상번호 꼬리표가 맨 앞에 왔을때
                return answer + 1; // 출력순서 반환
            } else { // 아니면
                mail.poll(); // 메일 출력
                answer++; // 출력 카운트 +1
                idx--; // 꼬리표도 하나 줄어듬
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(1,0,new int[]{5}));
        System.out.println(solution(4,2,new int[]{1,2,3,4}));
        System.out.println(solution(6,0,new int[]{1,1,9,1,1,1}));
    }
}
