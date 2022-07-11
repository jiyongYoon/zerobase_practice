package Practice;

import java.util.ArrayList;

// 주어진 이진탐색트리에서 N번째로 작은 수 구하기
// 입력트리: 5, 3, 6, 2, 4, null, null, 1
// N: 3
// 결과: 3
class P66Node {
    int key;
    P66Node left;
    P66Node right;

    public P66Node(int key, P66Node left, P66Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    P66Node head;

    BinarySearchTree() {}
    BinarySearchTree(int key) {
        this.head = new P66Node(key, null, null);
    }
    // 노드 추가 메서드 (직접 사용하는 메서드)
    public void addNode(int key) {
        // 아래 노드 추가 메서드를 호출하여 위치를 찾아서 키 값 추가
        this.head = this.addNode(this.head, key);
    }
    // 노드 추가 메서드 (직접 사용하는 메서드는 아님)
    public P66Node addNode(P66Node cur, int key) {
        if(cur == null) { // 만약 현재위치에 아무것도 없으면
            return new P66Node(key, null, null); // 새 노드 추가
        }
        // 키 값이 현재 키 값보다 작으면
        if(key < cur.key) {
            cur.left = addNode(cur.left, key); // 현재의 왼쪽에 새 노드 추가
        } else { // 키 값이 현재 키 값보다 크면
            cur.right = addNode(cur.right, key); // 현재의 오른쪽에 새 노드 추가
        }
        // 재귀로 그 위치에 아무것도 없을때까지 계속 자식노드로 내려감
        return cur;
        // 추가한 노드 반환
    }
}

public class Practice066 {
    public static void solution(Integer[] data, int n) {
        BinarySearchTree bst = new BinarySearchTree(data[0]);

        for (int i = 1; i < data.length; i++) {
            if(data[i] == null) {
                continue;
            }

            bst.addNode(data[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(bst.head, list);
        System.out.println(list.get(n-1));
    }

    // 인오더
    public static void inOrder(P66Node p66Node, ArrayList list) {
        if(p66Node == null) {
            return;
        }

        inOrder(p66Node.left, list); // 가장 왼쪽 리프노드까지 가서
        list.add(p66Node.key); // 노드의 키 값 리스트에 추가
        inOrder(p66Node.right, list); // 그 다음 오른쪽 리프노드로 넘어가기
    }

    public static void main(String[] args) {
        Integer[] data = {5, 3, 6, 2, 4, null, null, 1};
        int n = 3;
        solution(data, n);
    }
}
