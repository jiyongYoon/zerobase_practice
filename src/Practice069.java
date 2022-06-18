import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
// 인접행렬 정보를 이용한 dfs, bfs 구현하기 실습
public class Practice069 {
    public static void dfs(char[] vertices, int[][] adjMat, int start, int size) {
    boolean[] visited = new boolean[size];
    Stack<Integer> stack = new Stack<>();

    stack.push(start);
    visited[start] = true;

    while(!stack.isEmpty()) {
        int curId = stack.pop();
        System.out.print(vertices[curId] + " ");
        for (int i = 0; i < size; i++) {
            if(adjMat[curId][i] == 1 && visited[i] == false) {
                stack.push(i);
                visited[i] = true;
            }
        }
    }
}

    public static void bfs(char[] vertices, int[][] adjMat, int start, int size) {
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int curId = queue.poll();
            System.out.print(vertices[curId] + " ");
            for (int i = 0; i < size; i++) {
                if(adjMat[curId][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int size = 7;
        char[] vertices = new char[size];
        int[][] adjMat = new int[size][size];

        int[][] adj = {{0,1}, {0,2}, {0,3}, {1,4}, {2,5}, {3,4}, {3,5}, {4,6}, {5,6}};
        // 노드 작업
        for (int i = 0; i < size; i++) {
            vertices[i] = (char)('A' + i);
        }
        // 간선 작업
        for (int i = 0; i < adj.length; i++) {
            adjMat[adj[i][0]][adj[i][1]] = 1;
            adjMat[adj[i][1]][adj[i][0]] = 1;
        }

        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(vertices[i] + " ");
        }
        System.out.println();


        for (int i = 0; i < size; i++) {
            System.out.print(vertices[i] + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }

        dfs(vertices, adjMat, 0, size);
        System.out.println();
        bfs(vertices, adjMat, 0, size);
    }
}
