/*
1. 아이디어
시작점에서 끝점 최장거리 구하는 문제.
음의가중치 없어 다익스트라 사용가능.
단, 최소거리가 아니라 가장 오래걸리는 것을 구해야 하므로
값 업데이트를 반대로 max값을 해야 함
X 에서 올때까지만 나타나있기 때문에 X2를 해줘야 함

2. 시간복잡도
O(ElogV)
M:간선수E: 1 <= E <= 10,000
N: 노드수V: 1 <= N <= 1,000

3. 자료구조
시간: 1<= T[i] <= 100
100 * 1,000 = 100,000 -> int 사용가능
 */

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Practice113 {
    static int[][] data;
    static ArrayList<ArrayList<Node>> graph;

    static class Node {
        static int from;
        static int to;
        static int time;

        public Node(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
    public static int dijkstra(int m, int n, int start) {
        int[] disDP = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            disDP[i] = Integer.MIN_VALUE;
        }
        disDP[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.time - y.time);


        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph.get(i).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
        }
        System.out.println(dijkstra(m, n, x));
    }

}
