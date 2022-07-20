// 백준 1922번 네트워크 연결
// https://www.acmicpc.net/problem/1922

/*
1. 아이디어
모든 컴퓨터를 연결해야 하며, 비용을 최소로 한다 -> 최소 스패닝 트리

2. 시간복잡도
O(ElogV)

3. 자료구조
1 <= N(V) <= 1,000
1 <= M(E) <= 100,000
1 <= c(weight) <= 10,000
 */

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Practice116 {
    static ArrayList<ArrayList<Node>> graph;
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int prim(int v, int e, int start) {
        int weightSum = 0;

        boolean[] visited = new boolean[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));

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
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        System.out.println(prim(v, e, 1));
    }
}
