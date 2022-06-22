// 프로그래머스 Lv.2
// 기능개발
import java.util.ArrayList;

public class Practice076 {
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

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(solution(progresses, speeds));
    }
}
