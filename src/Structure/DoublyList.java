package Structure;

class DoublyNode {
    // 양방향이라 이전 노드를 가리키는 prev 변수도 생성
    int data;
    DoublyNode next;
    DoublyNode prev;

    DoublyNode() {}
    DoublyNode(int data, DoublyNode next, DoublyNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList {
    // 리스트의 마지막 부분을 가리키는 tail 변수도 생성
    DoublyNode head;
    DoublyNode tail;

    DoublyLinkedList() {}
    DoublyLinkedList(DoublyNode node) {
        this.head = node;
        this.tail = node;
    }
    // 비어있는지 확인
    public boolean isEmpty() {
        if(this.head == null) {
            return true;
        }
        return false;
    }
    // beforeData가 있을 때, 그 앞에 데이터 추가하기
    public void addData(int data, Integer beforeData) {
        if(this.head == null) { // head가 비어있을 때
            this.head = new DoublyNode(data, null, null); // 새 노드 추가해서 head에 할당
            this.tail = this.head; // tail도 같은 노드 할당
        } else if(beforeData == null) { // beforeData가 없을 때
            this.tail.next = new DoublyNode(data, null, this.tail); // tail 다음에 새 노드(next는 null, prev는 이전꼬리)
            this.tail = this.tail.next; // tail에 이전 tail의 다음인 새 노드 할당
        } else { // beforeData가 있을 때
            DoublyNode cur = this.head; // head부터
            DoublyNode pre = cur; // cur을 따라다니는 prev
            while(cur != null) { // 다음이 없을떄까지
                if(cur.data == beforeData) { // beforeData가 있는 경우
                    if(cur == this.head) { // 그게 head인 경우
                        this.head = new DoublyNode(data, this.head, null); // head에 새 노드(next는 기존 head, prev는 null) 생성
                        this.head.next.prev = this.head; // head의 다음노드(원래 head였던 노드)의 prev는 새로 추가한 노드(새로운 head) 할당
                    } else { // 중간 혹은 끝인 경우
                        pre.next = new DoublyNode(data, cur, pre); // pre의 다음에(혹은 맨 뒤에) 새 노드(next는 cur(원래 pre의 다음이었던 것), prev는 pre) 생성
                        cur.prev = pre.next; // cur.prev(원래 pre의 다음이었던 것의 prev)에 pre.next(이전의 다음, 즉 새노드) 할당
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }
    // 데이터 삭제
    public void removeData(int data) {
        if(this.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        DoublyNode cur = this.head;
        DoublyNode pre = cur;

        while(cur != null) {
            if(cur.data == data) { // 지우려는 데이터가 있고
                if(cur == this.head && cur == this.tail) { // 그게 head이자 tail일때
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) { // 그게 head일때
                    this.head = cur.next; // head에는 현재의 다음을 할당
                    this.head.prev = null; // head의 prev는 할당할게 없음
                } else if (cur == this.tail) { // 그게 tail일때
                    this.tail = this.tail.prev; // tail에 현재의 이전을 할당
                    this.tail.next = null; // tail의 next는 할당할게 없음
                } else { // 중간이면
                    pre.next = cur.next; // 이 전의 next를 현재의 다음노드로 할당
                    cur.next.prev = pre; // 현재의 다음(지우려는 노드 다음)의 prev를 이 전으로 할당
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }
    // 데이터 출력
    public void showData() {
        if(this.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        DoublyNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    // 데이터 역순 출력
    // 꼬리를 가리키는 변수가 있기 때문에 역순 출력이 가능
    public void showDataFromTail() {
        if(this.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        DoublyNode cur = this.tail;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();
    }
}

public class DoublyList {
}
