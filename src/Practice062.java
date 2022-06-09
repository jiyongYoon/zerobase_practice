//프로그래머스 Lv.1
// 2019 KAKAO BLIND RECRUITMENT
// 실패율
import java.util.Arrays;
import java.util.TreeMap;

public class Practice062 {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int curUserNum = stages.length; // 해당 스테이지까지 통과한 유저
        int[] stageCnt = new int[N+1]; // 각 스테이별 유저 수(마지막까지 깬 것도 포함)
        double[] stageFail = new double[N+1]; // 각 스테이지별 실패율(마지막까지 깬 것도 포함))
        // 각 스테이지별로 유저수 넣기
        for (int i = 0; i < stages.length; i++) {
            stageCnt[stages[i]-1] += 1;
        }
        // 각 스테이지 별 실패율 구하기
        for (int i = 0; i < stageCnt.length; i++) {
            if(curUserNum>0) {
                stageFail[i] = (double) stageCnt[i] / (double) curUserNum;
                curUserNum = curUserNum - stageCnt[i];
            } else { // 남은 사람 없으면 루프 탈출
                break;
            }
        }
        // 실패율과 스테이지 넘버를 트리맵에 넣기 (정렬을 위해)
        TreeMap<Double, Integer> tm = new TreeMap<>();
        double times = -0.00000000001;
        for (int i = 0; i < stageFail.length; i++) {
            if(tm.containsKey(stageFail[i])) { // 실패율이 같으면
                tm.put(stageFail[i]+times, i+1); // 조금 큰 값으로 넣기...
                stageFail[i] = stageFail[i]+times;
                times = times + times;
            } else {
                tm.put(stageFail[i], i+1);
            }
        }

        Arrays.sort(stageFail); // 실패율을 키값으로 쓰기 위해 정렬
        // 역순으로 트리맵의 값 리턴
        int idx = 0;
        while(answer[answer.length-1]==0) { // 정답 마지막이 찰때까지 반복
            if (tm.get(stageFail[N]) <= answer.length) { // 마지막까지 다 깬 사람은 출력하지 않기 위해 조건 설정
                answer[idx] = tm.get(stageFail[N]);
                idx++;
            }
            N--;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4,4,4,4,4})));
    }
}
/*
[학습내용]
TreeMap은 put 할 때 key 값을 오름차순 정렬하여 넣어준다!!
 */