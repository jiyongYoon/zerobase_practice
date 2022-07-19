package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MST {
    static int parents[];
    public static int kruskal(int[][] data, int v, int e) {
        int weightSum = 0;
        // 가중치로 정렬
        Arrays.sort(data, (x, y) -> x[2] - y[2]);

        // 부모노드 초기화 (노드가 1~ 라서 v + 1로 인덱스 관리)
        parents = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parents[i] = i;
        }
        // 반복문 돌면서 부모노드가 같지 않으면 연결작업하기
        for (int i = 0; i < e; i++) {
            if(find(data[i][0]) != find(data[i][1])) {
                union(data[i][0], data[i][1]);
                weightSum += data[i][2];
            }
        }
        return weightSum;
    }

    // 연결하는 메서드
    public static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        // 부모노드가 같지 않으면 연결(부도노드 같게 만들기)
        if(aP != bP) {
            parents[aP] = bP;
        }
    }

    // 부모노드 업데이트하는 메서드
    public static int find(int a) {
        if(a == parents[a]) {
            return a;
        }
        // 재귀호출하여 부모노드 끝을 따라감
        return parents[a] = find(parents[a]);
    }


    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int prim(int[][] data, int v, int e) {
        int weightSum = 0;
        // 노드를 담을 ArrayList 를 담을 ArrayList
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        // 노드 수 만큼 ArrayList 객체 생성
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        // 간선 수만큼 graph정보 업데이트
        for (int i = 0; i < e; i++) {
            // 양방향이기 때문에 data[i][0] -> data[i][1]로 가는것과, 반대로 가는 것 모두 추가
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
            graph.get(data[i][1]).add(new Node(data[i][0], data[i][2]));
        }
        // 방문배열
        boolean[] visited = new boolean[v + 1];
        // 노드 넣어서 연결작업 할 우선순위큐
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(1, 0)); // 연결작업 시작을 위해 임의의 노드 추가

        int cnt = 0; // 연결작업 수 체크
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            // 방문했었으면 넘어가고
            if(visited[cur.to]) {
                continue;
            } // 안했으면 방문체크하고 가중치 합산
            cnt++;
            visited[cur.to] = true;
            weightSum += cur.weight;
            // 간선수가 노드수 - 1개가 되면 다 연결된거니 리턴
            if(cnt == v) {
                return weightSum;
            }
            // 다 연결이 안됐으니 인접한 노드 개수만큼 순회하면서
            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adjNode = graph.get(cur.to).get(i); // 노드하나 가져와서
                if(visited[adjNode.to]) { // 방문했으면 넘어가고
                    continue;
                } // 방문안했으면 큐에 넣기 (연결작업 후보)
                pq.add(adjNode);
            }
        }
        return weightSum;
    }

    public static void main(String[] args) {
        int v = 7; // 노드
        int e = 10; // 간선
        int[][] graph = {{1, 3, 1}, {1, 2, 9}, {1, 6, 8}, {2, 4, 13}, {2, 5, 2}, {2, 6, 7}, {3, 4, 12}, {4, 7, 17}, {5, 6, 5}, {5, 7, 20}};
        System.out.println(prim(graph, v, e) );
        System.out.println(kruskal(graph, v, e));
    }
}