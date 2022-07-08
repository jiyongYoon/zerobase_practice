import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 순열과 조합
public class Practice099 {
    public static boolean[] visited;
    public static int[] out;
    public static int depth;

    public static void solution(int m, int n) {
        visited = new boolean[m];
        out = new int[n];
//        permu(m, n, 0, out, visited);
        System.out.println();
        combi(m, n, 0, out, visited, 0);
    }

    public static void combi(int m, int n, int depth, int[] out, boolean[] visited, int start) {
        if(depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(out[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < m; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = i + 1;
                combi(m, n, depth + 1, out, visited, i);
                visited[i] = false;
            }
        }
    }
    public static void permu(int m, int n, int depth, int[] out, boolean[] visited) {
        if(depth == n) {
            for (int i = 0; i < out.length; i++) {
                System.out.print(out[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < m; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = i + 1;
                permu(m, n, depth + 1, out, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        solution(m, n);
    }
}
