package Practice;// 백준 10819번 차이를 최대로
// https://www.acmicpc.net/problem/10819

/*
1. 아이디어
브루트포스. N자리를 배열로 만드는 모든 경우의 수를 구한 후
최대값 출력하기 (메서드 따로 만들기)

2. 시간복잡도
3 <= N <= 8. 최대 8자리 배열
연산횟수 8!
O(N^2)이라도 1억번 안되기 때문에 넘지 않음.

3. 자료구조
3 <= N <= 8
-100 <= 배열 숫자 <= 100
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice101 {
    static int[] arr, out;
    static int answer;
    static boolean[] visited;
    public static void solution(int N) {
        out = new int[N];
        permu(N, 0, out);
        System.out.println(answer);
    }
    public static void permu(int N, int depth, int[] out) {
        if(depth == N) {
            answer = Math.max(answer, getMaxVal(out));
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permu(N, depth + 1, out);
                visited[i] = false;
            }
        }
    }

    public static int getMaxVal(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            result += Math.abs(arr[i] - arr[i+1]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution(N);
    }
}
