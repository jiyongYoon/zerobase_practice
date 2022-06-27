// 그리디 알고리즘
// 거스름돈 동전 최소개수 구하기

import java.util.TreeMap;

public class Practice081 {
    public static void solution(int pay, int price) {
        final int[] change = {500, 100, 50, 10};
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int changeMoney = pay - price;
        int cnt = 0; // 총 몇개 동전으로 거스름돈을 주는지

        for (int i = 0; i < change.length; i++) {
            int tmp = changeMoney / change[i];
            tm.put(change[i], tm.getOrDefault(change[i], 0) + tmp);
            changeMoney %= change[i];
            cnt += tmp;
        }

        System.out.println("거스름 돈: " + (pay - price));
        System.out.println("거슬러 주는 동전 개수: " + cnt);
        for (int i = 0; i < tm.size(); i++) {
            System.out.print(change[i] + ": " + tm.get(change[i]));
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int pay = 10000;
        int price = 8500;
        solution(pay, price);
    }
}

/*
[학습내용]
HashMap에서 .getOrDefault(key, value)를 value 위치에 놓으면
해당 키의 값을 가져오거나, 없으면 Default(value)를 가져온다는 뜻.
if - else 문을 사용하지 않을 수 있음.
 */
