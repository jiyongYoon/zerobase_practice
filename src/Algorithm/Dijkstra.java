package Algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    // 기본 구현
    public static void dijkstra1(int v, int[][] data, int start) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        int[] distanceDP = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            distanceDP[i] = Integer.MAX_VALUE;
        }
        distanceDP[start] = 0;

        boolean[] visited = new boolean[v + 1];

        for (int i = 0; i < v; i++) {
            int minDist = Integer.MAX_VALUE;
            int curIdx = 0;
            for (int j = 1; j < v + 1; j++) {
                if(!visited[j] && distanceDP[j] < minDist) {
                    minDist = distanceDP[j];
                    curIdx = j;
                }

            }
            visited[curIdx] = true;

            for (int j = 0; j < graph.get(curIdx).size(); j++) {
                Node adjNode = graph.get(curIdx).get(j);
                if(distanceDP[adjNode.to] > distanceDP[curIdx] + adjNode.weight) {
                    distanceDP[adjNode.to] = distanceDP[curIdx] + adjNode.weight;
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            if(distanceDP[i] == Integer.MAX_VALUE) {
                System.out.print("NO WAY ");
            } else {
                System.out.print(distanceDP[i] + " ");
            }
        }
        System.out.println();
    }

    // 우선순위 큐
    public static void dijkstra2(int v, int[][] data, int start) {
        // 각 노드를 담을 리스트 + 간선정보를 담을 리스트
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        // 노드 수만큼 List 만들기 (노드가 1부터 시작해서 인덱스는 v + 1로 관리)
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        // 출발노드(data[i][0]) 리스트 위치에 노드(to, weight) 추가 -> 그래프 리스트 완성
        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        // DP배열 (최소거리 업데이트용)
        int[] distanceDP = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            distanceDP[i] = Integer.MAX_VALUE; // 최대값으로 초기화
        }
        distanceDP[start] = 0; // 시작점은 거리를 0으로

        // 가중치 정렬 우선순위큐
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0)); // 큐에 임의의 노드 넣어 시작
        // 큐가 빌때까지
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            // 연결하려는 노드의 기존 가중치가(DP) 현재 연결하려는 가중치(curNode.weight)보다 작으면 그냥 둠
            if(distanceDP[curNode.to] < curNode.weight) {
                continue;
            }
            // 크거나 같으면 인접노드 체크하면서 업데이트
            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i); //인접노드 픽
                // 그게 기존 가중치(DP)보다 현재 연결해서 만들어지는 가중치가 작으면 업데이트
                if(distanceDP[adjNode.to] > curNode.weight + adjNode.weight) {
                    distanceDP[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, distanceDP[adjNode.to])); // 그리고 나머지 간선정보 큐에 추가
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            if(distanceDP[i] == Integer.MAX_VALUE) {
                System.out.print("NO WAY ");
            } else {
                System.out.print(distanceDP[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] data = {{1, 2, 2}, {1, 3, 3}, {2, 3, 4}, {2, 4, 5}, {3, 4, 6}};
        dijkstra1(5, data, 1);
        dijkstra2(5, data, 1);
    }
}
