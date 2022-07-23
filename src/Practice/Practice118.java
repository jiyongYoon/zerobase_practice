// 백준 16398번 행성 연결
// https://www.acmicpc.net/problem/16398

/*
1. 아이디어
모든 행성을 연결하며 유지비용을 최소화하기 -> 최소 스패닝 트리

2. 시간복잡도
O(ElogV)

3. 자료구조
1 <= V <= 1,000
1 <= E <= 1,000 * 999 / 2
1 <= 비용 c <= 100,000,000 (1억) -> 더하면 long이 될 수도
 */

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Practice118 {
    static ArrayList<ArrayList<Node>> graph;
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void prim(int n) {
        long weightSum = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(1, 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;
            weightSum += cur.weight;
            cnt++;

            if(cnt == n) {
                break;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(visited[adj.to]) {
                    continue;
                }
                pq.offer(new Node(adj.to, adj.weight));
            }
        }
        System.out.println(weightSum);
    }

    public static void main(String[] args) throws IOException {
        graph = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = i + 1; j <= n; j++) {
                int from = i;
                int to = j;
                int weight = Integer.parseInt(tmp[j - 1]);
                graph.get(from).add(new Node(to, weight));
                graph.get(to).add(new Node(from, weight));
            }
        }
        prim(n);
    }
}
