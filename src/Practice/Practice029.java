package Practice;// Q4. (조건에 맞는 수인지 판별하기) 행복한 수 찾기
//     행복한 수는 각 자리수를 제곱한 것을 더하는 과정을 반복했을때, 1 로 끝나는 수가 나오는 수.
//     1에 도달하지 못하면 같은 수열이 반복되게 됨.
//     행복한 수가 맞다면 true, 아니라면 false를 반환.
//     <입출력 예시>
//     19 => true, 2 => false, 61 => false

import java.util.ArrayList;
public class Practice029 {
    ArrayList<Integer> list = new ArrayList<>(); // 제곱의 합을 담아놓을 리스트
    int sum; // 제곱의 합
    void recur(int n) {
        if(list.size()>0&&n%10==1) { // 리스트에 1개 이상의 값이 들어가 있고, 1로 끝나는 수라면
            System.out.println(true);  // true 반환
            return;
        } else if(list.contains(n)) {   // 리스트에 기존에 들어가있던 sum이 있다면
            System.out.println(false);  // false 반환
            return;
        }
        this.list.add(sum);  // 리스트 업데이트
        sum = 0; // 제곱의 합 초기화
        while(n>0) { // 제곱의 합 구하기
            int remain = n%10;
            sum += remain*remain;
            n = n/10;
        }
        recur(sum); // 재귀함수
        this.list.clear(); // 다음 연산을 할때 리스트 초기화
    }

    public static void main(String[] args) {
        Practice029 p = new Practice029(); // 메서드가 static이 아니라 객체 생성하여 접근
        p.recur(19);
        p.recur(2);
        p.recur(61);
    }
}
/*
[학습내용]
내가 재귀함수로 문제를 풀다니!
재귀함수는 큰 그림과, 종료조건, 문제정의가 가장 중요함!!
 */