package Practice;// 프로그래머스 Lv.2
// 기능개발
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Practice076 {
    /*
    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        int serveIdx = 0; // 배포된 서비스 인덱스
        int serveCnt = 0; // 한번 배포될 때 배포된 기능 카운트
        // 배포를 다 할때까지
        while(serveIdx < progresses.length) {
            // 각 기능 개발 (for문이 하루)
            for (int i = 0; i < progresses.length; i++) {
                if(progresses[i] < 100) {
                    progresses[i] += speeds[i];
                }
            }
            // 기능이 완성된것이 있으면 인덱스 옮기고
            if(progresses[serveIdx] >= 100) {
                while(progresses[serveIdx]>=100) {
                    serveIdx++;
                    serveCnt++;
                    // 만약 인덱스 옮겼을 때 마지막 기능이라면
                    if(serveIdx == progresses.length) {
                        answer.add(serveCnt); // 정답배열에 더하고
                        return answer; // 바로 종료
                    }
                }
                // 배포된 기능개수 정답배열에 더하기
                answer.add(serveCnt);
                serveCnt = 0;
            }
        }
        return answer;
    }
    */

    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>(); // 정답 리스트
        // 각 기능이 완성되는데 걸리는 날짜 배열
        int[] days = new int[progresses.length];
        // days 배열 채우기
        for (int i = 0; i < progresses.length; i++) {
            int cnt = 0; // 완성에 필요한 일수계산
            while(progresses[i] < 100) {
                progresses[i] += speeds[i];
                cnt++;
            }
            days[i] = cnt;
        }
        // 큐에 다 넣기
        for (int i = 0; i < days.length; i++) {
            queue.add(days[i]);
        }

        int cnt = 0; // 한번에 배포하는 기능 카운트 변수
        // 큐가 빌때까지
        while(!queue.isEmpty()) {
            int cur = queue.poll(); // 큐에서 하나 꺼내고
            cnt++; // 배포 카운트
            // 큐에 아직 있고 먼저 꺼낸게 다음 꺼낼거보다 숫자가 크거나 같으면
            while(!queue.isEmpty() && cur >= queue.peek()) {
                queue.poll(); // 그것도 꺼냄(cur 업데이트)
                cnt++; // 기능 카운트
            }
            answer.add(cnt); // 정답배열에 넣고
            cnt = 0; // 초기화
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(solution(progresses, speeds));
    }
}
