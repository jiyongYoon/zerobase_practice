// 백준 13905번 세부
// https://www.acmicpc.net/problem/13905

/*
1. 아이디어
브루트포스? 모든 갈 수 있는 경로에 대해 min값 보관해놓기?
다익스트라? 대신 가중치 DP배열이 아니라 min값에 대한 DP배열?

-> 최소 스패닝 트리의 프림 알고리즘 + 가중치를 큰 순서대로 뽑기
(최소스패닝의 weightSum처럼 기존 최대값을 가지고 갈 변수 필요)
--> 연결되면 그게 최대임 / 연결이 끝까지 안되면 0 출력

2. 시간복잡도
O(ElogV)

3. 자료구조
2 <= N <= 100,000
1 <= M <= 300,000
1 <= k <= 1,000,000
int 사용 가능

 */

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Practice117 {
    static ArrayList<ArrayList<Node>> graph;
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void prim(int n, int m, int start, int end) {
        int answer = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> y.weight - x.weight);
        boolean[] visited = new boolean[n + 1];
        int[] minDP = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            minDP[i] = Integer.MAX_VALUE;
            if(i == end) {
                minDP[i] = 0;
            }
        }
        pq.add(new Node(start, Integer.MAX_VALUE));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;
            answer = Math.min(answer, cur.weight);
            minDP[cur.to] = Math.min(minDP[cur.to], answer);
            if(cur.to == end) {
                minDP[cur.to] = answer;
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
        System.out.println(minDP[end]);
    }

    public static void solution(int n, int m, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> y.weight - x.weight);
        int[] minValDP = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            minValDP[i] = Integer.MIN_VALUE; // Integer.MAX_VALUE;
            if(i == end) {
                minValDP[i] = 0;
            }
        }
        // pq.offer(new Node(start, 0));
        for (int i = 0; i < graph.get(start).size(); i++) {
            Node tmp = graph.get(start).get(i);
            pq.offer(new Node(tmp.to, tmp.weight));
            minValDP[tmp.to] = tmp.weight;
        }

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(adj.to == end) {
                    if(minValDP[adj.to] == 0) {
                        minValDP[adj.to] = Math.min(minValDP[cur.to], adj.weight);
                    } else {
                        minValDP[adj.to] = Math.max(minValDP[adj.to], Math.min(minValDP[cur.to], adj.weight));
                    }
                    continue;
                }

                if(minValDP[adj.to] < Math.min(minValDP[cur.to], cur.weight)) {
                    minValDP[adj.to] = Math.min(minValDP[cur.to], cur.weight);
                    pq.offer(new Node(adj.to, adj.weight));
                }
            }
        }
        System.out.println(minValDP[end]);
    }

    public static void main(String[] args) throws IOException {
        graph = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        prim(n, m, start, end);
    }

}
