package Structure;
import java.util.LinkedList;
import java.util.Queue;

// 트리의 노드가 될 객체 구현
class TreeNode {
    char data;
    TreeNode left;
    TreeNode right;

    public TreeNode(char data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
// 트리 클래스에는 부모노드인 head 추가
class BinaryTree {
    TreeNode head;

    BinaryTree() {} // 기본 생성자
    BinaryTree(char[] arr) { // 문자배열 길이만큼 노드배열 생성
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new TreeNode(arr[i], null, null); // 데이터 입력
        }
        // 이진트리기 때문에 leftIdx, rightIdx는 노드배열에서 각 노드의 *2 +@ 인덱스로 표현됨.
        for (int i = 0; i < arr.length; i++) {
            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;
            // 배열을 벗어나지 않는 범위내에서. 즉, 자식노드가 있으면
            if(leftIdx < arr.length) {
                nodes[i].left = nodes[leftIdx];
            }

            if(rightIdx < arr.length) {
                nodes[i].right = nodes[rightIdx];
            }
        }
        this.head = nodes[0]; // 헤드는 노드0번으로 지정. (루트 노드)
    }
    // [ 프리오더 ]
    // A B D H I E J C F G
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " "); // 출력하고 자식노드로 내려감
        this.preOrder(node.left);
        this.preOrder(node.right);
    }
    // [ 인오더 ]
    // H D I B J E A F C G
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        this.inOrder(node.left);
        System.out.print(node.data + " "); // 왼쪽 자식노드가 없을 때부터 출력
        this.inOrder(node.right);
    }
    // [ 포스트 오더 ]
    // H I D J E B F G C A
    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data + " "); // 오른쪽 자식노드가 없을 때부터 출력
    }
    // [ 레벨 오더 ]
    // A B C D E F G H I J
    public void levelOrder(TreeNode node) {
        // 트리의 레밸 순서로 출력해야 하니 해당 레밸의 노드를 큐에 넣어줌
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        // 큐가 빌때까지
        while(!queue.isEmpty()) {
            // 큐에서 하나씩 꺼냄
            TreeNode cur = queue.poll();
            // 출력
            System.out.print(cur.data + " ");
            // 왼쪽, 오른쪽 노드가 있을때마다 큐에 하나씩 추가
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
            // 이렇게 되면 같은 레밸 노드가 모두 꺼내지고 나서
            // 그 다음 레밸 노드들이 순차적으로 나오게 됨
        }
    }
}

public class Tree {
    public static void main(String[] args) {
        // Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(bt.head);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(bt.head);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(bt.head);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(bt.head);
        System.out.println();
    }
}
