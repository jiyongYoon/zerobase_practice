// 백준 6603 로또
// https://www.acmicpc.net/problem/6603

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice098 {
    public static boolean[] visited;
    public static int[] lot_num;
    public static int[] out;
    public static int n;

    public static void solution(int n) {
        out = new int[6];
        visited = new boolean[n];
        permu(0, 0, out);
    }

    public static void permu(int start, int depth, int[] out) {
        if (depth == 6) {
            for (int i = 0; i < out.length; i++) {
                System.out.print(out[i] + " ");
            }
            System.out.println();
            return;
        }
        // 조합은 이 부분을 start로, 순열은 이 부분을 0으로
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = lot_num[i];
                permu(i, depth + 1, out);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            lot_num = new int[n];
            for (int i = 0; i < n; i++) {
                lot_num[i] = Integer.parseInt(st.nextToken());
            }
            solution(n);
            System.out.println();
        }
    }
}
