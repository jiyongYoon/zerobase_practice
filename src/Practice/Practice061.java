package Practice;// 프로그래머스 Lv.1
// 모의고사
// 테스트케이스 11/14...

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Practice061 {
    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};

        int[] cnt = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == s1[i%5]) { cnt[0]++; }
            if(answers[i] == s2[i%8]) { cnt[1]++; }
            if(answers[i] == s3[i%10]) { cnt[2]++; }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= cnt.length; i++) {
            int a = cnt[((i+2) % cnt.length)];
            int b = cnt[(i % cnt.length)];
            int c = cnt[((i+1) % cnt.length)];
            // 하나가 나머지 둘 보다 큰 경우
            if (a > b && a > c) {
                result.add(i);
                break;
            }
            // 둘이 같고 하나가 작은 경우
            else if (a == b && a > c){
                result.add(i);
                result.add((i+1) % cnt.length);
                break;
            }
            // 다 틀린경우
            else if (a == b && a == c && a == 0) {
                return answer;
            }
            // 셋이 같은 경우
            else if (a == b && a == c) {
                result.add(1);
                result.add(2);
                result.add(3);
                break;
            }
        }
        // 결과 오름차순 정렬
        result.sort(Comparator.naturalOrder());
        // 정답 출력
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(solution(new int[]{1,3,2,4,2})));
    }
}
