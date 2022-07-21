// 프로그래머스 Lv.3 섬 연결하기
// https://school.programmers.co.kr/learn/courses/30/lessons/42861#

/*
1. 아이디어
최소 비용으로 모두 연결 -> 최소 신장 트리
프림기법: visited 배열 필요, Priority Queue 필요

2. 시간복잡도
프림기법 사용: O(ElogV)
E: 간선 수 = cost.length
V: 노드 수 = 1 <= n <= 100 (섬 수)

3. 자료구조
1 <= cost.length <= ((n-1) * n) / 2 = 5,000
0 <= n <= 100
int 사용 가능
 */

package Practice;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Practice114 {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int prim(int n, int[][] costs) {
        if(n == 1) {
            return 0;
        }

        int weightSum = 0;

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < costs.length; i++) {
            graph.get(costs[i][0]).add(new Node(costs[i][1], costs[i][2]));
            graph.get(costs[i][1]).add(new Node(costs[i][0], costs[i][2]));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(costs[0][1], 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            if(visited[curNode.to]) {
               continue;
            }
            cnt++;
            visited[curNode.to] = true;
            weightSum += curNode.weight;

            if(cnt == n) {
                return weightSum;
            }

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);
                if(visited[adjNode.to]) {
                    continue;
                }
                pq.offer(adjNode);
            }
        }
        return weightSum;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
        System.out.println(prim(n, costs));

    }
}
