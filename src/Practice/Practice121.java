// 백준 1916번 최소비용 구하기
// https://www.acmicpc.net/problem/1916

/*
1. 아이디어
다익스트라 기본문제

2. 시간복잡도
O(ElogV)

3. 변수
1 <= 정점개수(n) <= 1,000
1 <= 버스개수(m) <= 100,000
0 <= 버스비용 <= 100,000

최대값 -> 10^5 * 10^5 = 10^10 => 10억 => int 가능
 */

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Practice121 {
    static ArrayList<ArrayList<Bus>> graph;
    static class Bus {
        int to;
        int weight;

        public Bus(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(int n, int m, int start, int end) {

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[start] = 0;

        PriorityQueue<Bus> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Bus(start, 0));

        while(!pq.isEmpty()) {
            Bus cur = pq.poll();
            if(dp[cur.to] < cur.weight) {
                continue;
            }
            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Bus adj = graph.get(cur.to).get(i);
                if(dp[adj.to] > cur.weight + adj.weight) {
                    dp[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Bus(adj.to, dp[adj.to]));
                }
            }
        }
        System.out.println(dp[end]);
    }

    public static void main(String[] args) throws IOException {
        graph = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Bus(to, weight));
            // graph.get(to).add(new Bus(from, weight));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st2.nextToken());
        int end = Integer.parseInt(st2.nextToken());

        dijkstra(n, m, start, end);
    }
}
