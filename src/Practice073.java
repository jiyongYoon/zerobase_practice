import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// 백준 1966번
// https://www.acmicpc.net/problem/1966
public class Practice073 {
    public static int solution(int n, int m, int[] arr) {
        int answer = 1;
        Queue<Integer> queue = new LinkedList<>();
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        Arrays.sort(arr);
        int arrIdx = arr.length - 1;
        int targetIdx = m;

        while(!queue.isEmpty()) {
            int cur = queue.peek(); // 큐에서 하나 픽함
            if(cur==arr[arrIdx]) { // 만약 최대값이랑 같으면
                if(targetIdx!=0) { // 타겟공이 아니면
                    queue.poll();
                    targetIdx--; // 타겟인덱스 하나 줄이고
                    answer++;
                    arrIdx--; // 최대값 인덱스도 하나 줄임
                } else {
                    return answer; // 맞으면 정답 출력
                }
            } else { // 최대값이 아니면
                queue.poll(); // 꺼내서
                queue.add(cur); // 다시 큐에 넣기
                if(targetIdx==0) { // 그리고 그게 타겟공이었으면
                    targetIdx = queue.size() - 1; // 인덱스 재조정
                } else { // 타겟공 아니었으면
                    targetIdx--; // 인덱스 하나 줄이기
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int[] arr = new int[n];
            String[] str2 = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(str2[j]);
            }
            System.out.println(solution(n, m, arr));
        }
    }
}
