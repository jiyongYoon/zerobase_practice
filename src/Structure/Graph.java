package Structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 인접 행렬을 이용한 그래프 구현
// vertex에 데이터들을 쭉 넣어놓고 행렬을 통해 간선을 표현함
class MyGraphMatrix {
    char[] vertices; // 노드 배열
    int[][] adjMat; // 간선 정보 배열
    int elemCnt; // data가 들어온 개수

    public MyGraphMatrix() {
    }

    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    // 가득 찼는지 확인
    public boolean isFull() { // 실제 들어온 데이터 개수랑 노드 개수랑 같으면
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) { // 가득 찼으면
            System.out.println("Full"); // 더이상 못채움
            return;
        }
        // 들어올 데이터를 elemCnt를 인덱스로 하는 노드에 넣기
        this.vertices[this.elemCnt++] = data;
    }

    // 간선 정보
    // 만약 1-2가 이어져있다면 (1,2), (2,1) 배열에 1 할당
    public void addEdge(int x, int y) {
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }
    // 방향이 있는 간선이라면 일방향만 넣기
    public void addDirectedEdge(int x, int y) {
        this.adjMat[x][y] = 1;
    }
    // 간선 삭제
    public void deleteEdge(int x, int y) {
        this.adjMat[x][y] = 0;
        this.adjMat[y][x] = 0;
    }

    public void deleteDirectedEdge(int x, int y) {
        this.adjMat[x][y] = 0;
    }

    public void printAdjacentMatrix() {
        System.out.print("  ");
        for (char item : this.vertices) {
            System.out.print(item + " ");
        }
        System.out.println();

        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + " "); // 첫번째 노드부터 루프 돌면서
            for (int j = 0; j < this.elemCnt; j++) { // 각 노드로 이어진 간선정보 표시
                System.out.print(this.adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 넓이 우선 탐색
    public void bfs(int start) {
        boolean[] visited = new boolean[this.elemCnt]; // 방문여부 체크할 배열
        Queue<Integer> queue = new LinkedList<>(); // 큐

        queue.offer(start); // 시작점 큐에 넣기
        visited[start] = true; // 방문 체크
        // 큐가 빌 때까지
        while(!queue.isEmpty()) {
            int curId = queue.poll(); // 하나 꺼내서
            System.out.print(this.vertices[curId] + " "); // 출력
            // 간선 정보 배열 돌면서
            for(int i = 0; i < this.elemCnt; i++) {
                // 간선이 연결되어 있고 방문을 안했을 경우
                if(this.adjMat[curId][i] == 1 && visited[i] == false) {
                    queue.offer(i); // 큐에 넣기
                    visited[i] = true; // 방문 체크
                }
            }
        }
    }
    // 깊이 우선 탐색
    public void dfs(int start) {
        boolean[] visited = new boolean[elemCnt]; // 방문여부 체크할 배열
        Stack<Integer> stack = new Stack<>(); // 스택

        stack.push(start); // 시작점 스택에 넣기
        visited[start] = true; // 방문 체크

        while(!stack.isEmpty()) { // 스택이 빌 때까지
            int curId = stack.pop(); // 하나 꺼내서
            System.out.print(this.vertices[curId] + " "); // 출력
            // 간선 정보 배열 돌면서
            for(int i = 0; i < elemCnt; i++) {
                // 간선이 연결되어 있고 방문을 안했을 경우
                if(this.adjMat[curId][i] == 1 && visited[i] == false) {
                    stack.push(i); // 스택에 넣기
                    visited[i] = true; // 방문 체크
                }
            }
        }
    }
}





// 인접 리스트를 이용한 그래프 구현
// 링크를 위한 노드 클래스
    class Node {
        int id;
        Structure.Node next;

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }
}

class MyGraphList {
    char[] vertices;
    Node[] adjList; // 간선 정보를 넣을 노드 배열
    int elemCnt; // 데이터 있는 노드 개수

    public MyGraphList() {}
    public MyGraphList(int size) {
        this.vertices = new char[size];
        this.adjList = new Node[size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Full");
            return;
        }
        this.vertices[elemCnt++] = data;
    }

    // 간선 정보 추가
    // 새 노드를 만들어서 기존에 x가 가리키고 있던 걸 가리키게 하고, 그 노드를 x가 가리키게 함
    // (y도 마찬가지로)
    public void addEdge(int x, int y) {
        this.adjList[x] = new Node(y, this.adjList[x]);
        this.adjList[y] = new Node(x, this.adjList[y]);
    }

    public void addDirectedEdge(int x, int y) {
        this.adjList[x] = new Node(y, this.adjList[x]);
    }

    public void printAdjacentList() {
        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + ": ");

            Node cur = this.adjList[i];
            while (cur != null) {
                System.out.print(this.vertices[cur.id] + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
    // 넓이 우선 탐색
    public void bfs(int start) {
        boolean[] visited = new boolean[elemCnt]; // 방문여부 체크할 배열
        Queue<Integer> queue = new LinkedList<>(); // 큐

        queue.offer(start); // 시작점 큐에 넣기
        visited[start] = true; // 방문 체크
        // 큐 빌 때까지
        while(!queue.isEmpty()) {
            int curId = queue.poll(); // 하나 꺼내서
            System.out.print(this.vertices[curId] + " "); // 출력
            // 이 노드를 cur에 넣고
            Node cur = this.adjList[curId];
            while(cur != null) { // 간선이 없을때까지, 즉 링크가 끊어질때까지
                if(visited[cur.id] == false) { // 방문을 하지 않은곳에
                    queue.offer(cur.id); // 큐에 넣고
                    visited[cur.id] = true; // 방문 체크
                }
                cur = cur.next; // 다음 노드로 이동
            }
        }
    }
    // 깊이 우선 탐색
    public void dfs(int start) {
        boolean[] visited = new boolean[elemCnt]; // 방문여부 체크할 배열
        Stack<Integer> stack = new Stack<>(); // 스택

        stack.push(start); // 시작점 스택에 넣기
        visited[start] = true; // 방문 체크
        // 스택 빌 때까지
        while(!stack.isEmpty()) {
            int curId = stack.pop(); // 하나 꺼내서
            System.out.print(this.vertices[curId] + " "); // 출력
            // 이 노드를 cur에 넣고
            Node cur = this.adjList[curId];
            while(cur != null) { // 간선이 없을때까지, 즉 링크가 끊어질때까지
                if(visited[cur.id] == false) { // 방문을 하지 않은곳에
                    stack.push(cur.id); // 스택에 넣고
                    visited[cur.id] = true; // 방문 체크
                }
                cur = cur.next; // 다음 노드로 이동
            }
        }
    }
}

public class Graph {
    public static void main(String[] args) {
        // 인접 행렬을 이용한 그래프 출력
        MyGraphMatrix grMatrix = new MyGraphMatrix(4);

        grMatrix.addVertex('A');
        grMatrix.addVertex('B');
        grMatrix.addVertex('C');
        grMatrix.addVertex('D');

        grMatrix.addEdge(0, 1);
        grMatrix.addEdge(0, 2);
        grMatrix.addEdge(1, 2);
        grMatrix.addEdge(1, 3);
        grMatrix.addEdge(2, 3);
        grMatrix.printAdjacentMatrix();

/*
  A B C D
A 0 1 1 0
B 1 0 1 1
C 1 1 0 1
D 0 1 1 0
 */

        System.out.println();

        // 인접 리스트를 이용한 그래프 출력
        MyGraphList grList = new MyGraphList(4);

        grList.addVertex('A');
        grList.addVertex('B');
        grList.addVertex('C');
        grList.addVertex('D');

        grList.addEdge(0, 1);
        grList.addEdge(0, 2);
        grList.addEdge(1, 2);
        grList.addEdge(1, 3);
        grList.addEdge(2, 3);
        grList.printAdjacentList();

/*
A: C B
B: D C A
C: D B A
D: C B
 */
    }
}