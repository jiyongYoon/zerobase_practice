// 백준 15650번 N과 M
// https://www.acmicpc.net/problem/15650
// 백트래킹

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice125 {
    static int[] out;
    static boolean[] visited;
    static int[] arr;
    public static void solution(int n, int m) {
        arr = new int[n];
        out = new int[m];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        permu(n, m, 0, 0);
    }

    public static void permu(int n, int m, int start, int depth) {
        if(depth == m) {
            for (int i = 0; i < out.length; i++) {
                System.out.print(out[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permu(n, m, i, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        solution(n, m);
    }
}
