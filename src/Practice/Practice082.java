package Practice;// 백준 15903번 카드 합체 놀이
// https://www.acmicpc.net/problem/15903

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice082 {
    // 풀이 1 - 0, 1번 원소를 그때마다 삽입정렬
    // 메모리 14632 KB, 시간 168ms
    public static void solution(int n, int m, long[] arr) {
        long answer = 0;
        // n이 2면 걔들 둘만 계속 돌리면 됨
        if(n == 2) {
            for (int i = 0; i < m; i++) {
                long tmp = arr[0] + arr[1];
                arr[0] = tmp;
                arr[1] = tmp;
            }
            System.out.println(arr[0] + arr[1]);
            return;
        }

        // m이 0이면 배열 더하고 끝
        if(m == 0) {
            for (long item : arr) {
                answer += item;
            }
            System.out.println(answer);
            return;
        }
        // 배열 정렬
        Arrays.sort(arr);
        // m번 수행
        for (int i = 0; i < m; i++) {
            // 0, 1번 원소를 tmp로 업데이트한 후 매번 정렬을 하기 때문에
            // 계속 0번, 1번을 더하면 됨
            long tmp = arr[0] + arr[1];
            arr[0] = tmp;
            arr[1] = tmp;
            sort(arr, 1); // 1번 인덱스에 있는것 정렬
            sort(arr, 0); // 0번 인덱스에 있는것 정렬
        }
        // 배열 모두 더해서 출력
        for (long item : arr) {
            answer += item;
        }
        System.out.println(answer);
    }
    // 정렬 메서드
    public static void sort(long[] arr, int startIdx) {
        // 인덱스가 배열길이 - 1까지 (그 뒤에거랑 비교를 하니 -1까지)
        while(startIdx < arr.length - 1) {
            if(arr[startIdx] > arr[startIdx + 1]) {
                // 스왑
                long tmp = arr[startIdx];
                arr[startIdx] = arr[startIdx + 1];
                arr[startIdx + 1] = tmp;
            } else { // 뒤에 원소가 더 크면 정렬 종료. (오름차순 정렬되어있기 때문)
                break;
            }
            startIdx++;
        }
    }

    // 풀이 2 - 우선순위큐를 이용
    // 메모리 15596 KB, 시간 164ms
    // 예외처리 하니 메모리 15468 KB, 시간 176ms ...?
    public static void solution2(int n, int m, long[] arr) {
        long answer = 0;
        // n이 2면 걔들 둘만 계속 돌리면 됨
        if(n == 2) {
            for (int i = 0; i < m; i++) {
                long tmp = arr[0] + arr[1];
                arr[0] = tmp;
                arr[1] = tmp;
            }
            System.out.println(arr[0] + arr[1]);
            return;
        }

        // m이 0이면 배열 더하고 끝
        if(m == 0) {
            for (long item : arr) {
                answer += item;
            }
            System.out.println(answer);
            return;
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        Arrays.sort(arr);
        // 큐에 넣기
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        // m번 수행
        for (int i = 0; i < m; i++) {
            // 큐에서 2개 빼서 더한 후 더한 값을 큐에 넣기
            long a = pq.poll();
            long b = pq.poll();
            long tmp = a + b;
            pq.add(tmp);
            pq.add(tmp);
        }
        // 큐에 있는것 더해서 출력
        for (long item : pq) {
            answer += item;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] s2 = br.readLine().split(" ");
        long[] arr = new long[s2.length];
        for (int i = 0; i < s2.length; i++) {
            arr[i] = Long.parseLong(s2[i]);
        }
        solution2(n, m, arr);
    }
}
