package Structure;
import java.util.ArrayList;
class MinHeap {
    ArrayList<Integer> heap; // 힙을 담을 리스트

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); // 더미 데이터
    }

    // 데이터 추가 메서드
    public void insert(int data) {
        // 1. 힙 리스트에 데이터 추가
        // 최소힙은 맨 마지막 노드에 데이터 추가
        heap.add(data);
        // 2. 정렬
        // 부모 노드보다 작으면 위로 올리기 반복
        int cur = heap.size() - 1; // 현재 인덱스는 마지막(사이즈 - 1)
        // cur>1은 부모노드가 있다는 뜻 && cur/2 는 부모노드의 인덱스
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parentVal = heap.get(cur / 2); // 부모의 값을 담을 변수
            heap.set(cur / 2, data); // 부모노드에 현재값 추가
            heap.set(cur, parentVal); // 현재노드에 부모값 추가

            cur /= 2; // 현재 위치는 기존 부모노드 인덱스로
        }
    }

    // 데이터 삭제 메서드
    public Integer delete() {
        if(heap.size() == 1) {
            System.out.println("Empty");
            return null;
        }
        // 삭제할 target은 루트노드 값
        int target = heap.get(1);
        // 1. 마지막 위치 노드를 최상위 노드로 위치시킴
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1); // 마지막 노드 없애기
        // 2. 자식 노드 중 작은 값과 비교하여 부모노드가 더 크면 자리 교체 반복
        int cur = 1;
        while(true) {
            int leftIdx = cur * 2; // 왼쪽 자식노드
            int rightIdx = cur * 2 + 1; // 오른쪽 자식노드
            int targetIdx = -1; // 초기화

            if(rightIdx < heap.size()) { // 오른쪽 자식노드가 있다면 좌 우, 작은 값으로 교체
                targetIdx = (heap.get(leftIdx) < heap.get(rightIdx)) ? leftIdx : rightIdx;
            } else if(leftIdx < heap.size()) { // 왼쪽 자식노드가 있다면 좌로 교체 (오른쪽 자식노드는 위 케이스에서 걸림)
                targetIdx = leftIdx;
            } else { // 자식노드 없으면 끝
                break;
            }

            if(heap.get(cur) < heap.get(targetIdx)) { // 만약 현재 값이 바꿀 자식노드 값보다 작으면
                break; // 안움직여도 됨
            } else { // 자식노드 값보다 크면 값 스와핑
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx; // cur은 자식노드 위치로 변경하여 반복
            }
        }
        return target;
    }

    // levelOrder로 출력 (bfs)
    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

// 최대 힙
class MaxHeap {
    ArrayList<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); // 더미 데이터
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        // 최소힙에서 부등호방향만 바뀜.
        // 즉, 부모노드가 자식노드보다 작으면 변경 (루트노드가 커야되니까)
        while (cur > 1 && heap.get(cur / 2) < heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    // 루트노드 삭제 메서드
    public Integer delete() {
        if(heap.size() == 1) {
            System.out.println("Empty");
            return null;
        }
        // 루트노드 특정
        int target = heap.get(1);
        // 루트노드에 맨 마지막 노드값 가져오기
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        // 자식 노드 중 큰 값과 비교하여 부모노드가 더 작으면 자리 교체 반복
        int cur = 1;
        while(true) {
            int leftIdx = cur * 2; // 왼쪽 자식노드
            int rightIdx = cur * 2 + 1; // 오른쪽 자식노드
            int targetIdx = -1; // 초기화

            if(rightIdx < heap.size()) { // 오른쪽 자식노드가 있다면 좌, 우 중 큰 노드값 선택
                targetIdx = (heap.get(leftIdx) > heap.get(rightIdx)) ? leftIdx : rightIdx;
            } else if(leftIdx < heap.size()) { // 왼쪽 자식노드가 있다면 왼쪽 노드값
                targetIdx = leftIdx;
            } else { // 자식노드가 없으면 끝
                break;
            }

            if(heap.get(cur) > heap.get(targetIdx)) { // 자식노드보다 부모노드가 큰 경우
                break; // 끝
            } else { // 자식노드가 부모노드보다 큰 경우 선택했던 노드 값이랑 스와핑
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx; // 자식노드로 인덱스 변경하여 계속 내려감
            }
        }
        return target;
    }

    // levelOrder로 출력 (bfs)
    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Heap {
    public static void main(String[] args) {
        // MinHeap Test code
        MinHeap minHeap = new MinHeap();
        System.out.println("== 데이터 삽입 ==");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree();
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree();
        minHeap.insert(20);
        minHeap.printTree();
        minHeap.insert(30);
        minHeap.printTree();

        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();

        // MaxHeap Test code
        MaxHeap maxHeap = new MaxHeap();
        System.out.println("== 데이터 삽입 ==");
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(10);
        maxHeap.printTree();
        maxHeap.insert(50);
        maxHeap.insert(60);
        maxHeap.insert(70);
        maxHeap.printTree();
        maxHeap.insert(20);
        maxHeap.printTree();
        maxHeap.insert(30);
        maxHeap.printTree();

        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제: " + maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제: " + maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제: " + maxHeap.delete());
        maxHeap.printTree();
    }
}
