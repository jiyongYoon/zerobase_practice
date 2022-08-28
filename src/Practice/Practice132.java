// 프로그래머스 Lv.1 소수 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12977

package Practice;

import java.util.ArrayList;
import java.util.HashMap;

public class Practice132 {
    public static HashMap<Integer, Integer> hm;
    public static int answer;
    public static int sum;
    public static boolean[] visited;
    public static ArrayList<Integer> list;
    public static int maxNum;

    public static int solution(int[] nums) {
        visited = new boolean[nums.length];
        list = new ArrayList<>();

        combi(0, 0, nums);

        int[] arr = new int [maxNum + 1]; // 인덱스 = 숫자, 해당 숫자가 소수면 1, 소수가 아니면 0 => 마지막에 1을 다 더해주면 소수개수 확인

        for(int i = 2; i <= maxNum; i++) { // 1로 전체 초기화
            arr[i] = 1;
        }

        for(int i = 2; i<= (int)Math.sqrt(maxNum + 1); i++) { // Square Root까지만 for문 돌림
            if(arr[i] == 0) { // 이미 배수면 아무것도 안함
                continue;
            }

            int num = i*2; // 맨 처음수 제외
            while (num < maxNum + 1) { // 그 다음 수부터 n까지
                arr[num] = 0; // 소수가 아니라고 표시함
                num += i; // i 만큼 늘려가며(X2, X3,,,)
            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(i + ": " + arr[i] + ", ");
//        }

        hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                hm.put(i, hm.getOrDefault(i, 0) + 1);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i);
            if(hm.containsKey(a) && hm.get(a) == 1) {
                answer++;
            }
        }

        return answer;
    }

    public static void combi(int depth, int start, int[] nums) {
        if(depth == 3) {
            list.add(sum);
            System.out.println(sum);
            maxNum = Math.max(maxNum, sum);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sum += nums[i];
                combi(depth + 1, i, nums);
                sum -= nums[i];
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        System.out.println(solution(nums));

    }
}
