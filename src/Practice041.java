// 요세푸스 문제
// n명을 원탁에 앉히고 1번부터 k번째 앉아있는 사람을 한명씩 제외
// 제외된 사람의 번호가 요세푸스 수열

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Practice041 {
    public static ArrayList yp(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i+1);
        }

        ArrayList<Integer> arr = new ArrayList<>();

        while(q.isEmpty()!=true) {
            for (int i = 0; i < k-1; i++) {
                q.add(q.poll());
            }
            arr.add(q.poll());
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(yp(5,2));
        System.out.println(yp(7,3));
    }
}
