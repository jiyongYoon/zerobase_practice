// 백준 1197번 최소 스패닝 트리
// https://www.acmicpc.net/problem/1197

/*
1. 아이디어
가중치 합이 최소가 되도록 연결하라 -> 최소 신장 트리(최소 스패닝 트리)

2. 시간 복잡도
O(ElogV)
1 <= E <= 100,000
1 <= V <= 10,000
100,000 * 5 = 500,000 (1억 미만) -> 가능

3. 자료구조
v, e int 가능
가중치: -2,147,483,648 <= 가중치 <= 2,147,483,647 (int범위임)
 */

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Practice115 {
    static ArrayList<ArrayList<Node>> graph;

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int mst(int v, int e) {
        int weightSum = 0;

        boolean[] visited = new boolean[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(1, 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.to]) {
                continue;
            }

            visited[cur.to] = true;
            weightSum += cur.weight;
            cnt++;

            if(cnt == v) {
                return weightSum;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(visited[adj.to]) {
                    continue;
                }
                pq.offer(adj);
            }
        }

        return weightSum;
    }


    public static void main(String[] args) throws IOException {
        graph = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        System.out.println(mst(v, e));
    }
}
