package Structure;
// 단일 연결 리스트
class SinglyNode {
    int data;
    SinglyNode next;

    SinglyNode() {} // 기본생성자
    SinglyNode(int data, SinglyNode next) {
        this.data = data;
        this.next = next;
    }
}

class SinglyLinkedList {
    SinglyNode head; // 맨 앞을 가리키는 변수

    SinglyLinkedList() {}
    SinglyLinkedList(SinglyNode node) { // 맨 처음 생성시 해당 노드를 head에 할당
        this.head = node;
    }

    // 연결리스트 비어있는지 확인
    public boolean isEmpty() {
        if(this.head == null) {
            return true;
        }
        return false;
    }
    // 연결리스트 맨 뒤에 데이터 추가
    public void addData(int data) {
        if(this.head == null) { // head가 가리키는게 없으면
            this.head = new SinglyNode(data, null); // head에 새 노드 추가
        } else { // head가 있으면
            SinglyNode cur = this.head; // head노드를 cur에 담아서
            while(cur.next != null) { // 다음이 없을때까지 돌려
                cur = cur.next;
            }
            cur.next = new SinglyNode(data, null); // 맨 끝에 새 노드 추가
        }
    }
    // 연결리스트에 beforeData가 있으면 그 앞에 데이터 추가
    public void addData(int data, Integer beforeData) {
        if(this.head == null) {
            this.head = new SinglyNode(data, null);
        } else if (beforeData == null) { // beforeData 없으면
            SinglyNode cur = this.head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = new SinglyNode(data, null); // 맨 끝에 새 노드 추가
        } else {
            SinglyNode cur = this.head;
            SinglyNode prev = cur;
            // 마지막 데이터 삭제 후 이전 링크의 next를 null로 바꾸기 위해서
            // cur을 따라다닐 prev
            while(cur != null) {
                if (cur.data == beforeData) { // beforeData 발견
                    if(cur == this.head) { // 거기가 head면 head에 새 노드 추가 및 할당
                        this.head = new SinglyNode(data, this.head);
                    } else { // 아니면 따라오던 prev의 다음에 새 노드 추가 및 할당
                        prev.next = new SinglyNode(data, cur);
                    }
                    break;
                }
                prev = cur; // prev와 cur 이동
                cur = cur.next;
            }
        }
    }
    // 연결리스트 맨 뒤에 데이터 삭제
    public void removeData() {
        if(this.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        SinglyNode cur = this.head;
        SinglyNode prev = cur;

        while(cur.next != null) { //  리스트 맨 끝으로 이동
            prev = cur;
            cur = cur.next;
        }

        if(cur==this.head) { // 노드가 head 하나밖에 없었을 경우
            this.head = null; // head 할당 없애기
        } else {
            prev.next = null; // 그 전 노드의 next 할당 없애기
        }
    }
    // data가 있으면 그 데이터를 지우기
    public void removeData(int data) {
        if(this.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        SinglyNode cur = this.head; // 처음부터 탐색
        SinglyNode prev = cur;
        while(cur != null) {
            if(cur.data == data) { // 지우고자 하는 데이터가 있으면
                if(cur==this.head) { // 그 데이터가 head면
                    this.head = cur.next; // head에 이 다음 노드 할당
                } else { // 그 데이터가 head가 아니면
                    prev.next = cur.next; // 다음 노드(cur.next)를 전 노드의 next에 할당
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    // 연결리스트에서 데이터 찾기
    public boolean findData(int data) {
        if(this.isEmpty()) {
            System.out.println("Empty");
        }

        SinglyNode cur = this.head;
        while(cur!=null) {
            if(cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    // 연결리스트의 모든 데이터 출력
    public void showData() {
        if(this.isEmpty()) {
            System.out.println("Empty");
        }

        SinglyNode cur = this.head;
        while(cur!=null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

public class SinglyList {
    public static void main(String[] args) {
        //Test code
        SinglyLinkedList myList = new SinglyLinkedList(new SinglyNode(1, null));

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();

        System.out.println(myList.findData(5));
        System.out.println(myList.findData(10));

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData();
    }
}
