// 프로그래머스 Lv.1
// [카카오 인턴] 키패드 누르기

import java.util.HashMap;

public class Practice049 {
    static HashMap<Integer, int[]> key = new HashMap<>(); // 핸드폰 번호마다의 좌표값 대입
    static int[] rIdx = new int[]{3,0}; // 오른손 초기좌표
    static int[] lIdx = new int[]{3,2}; // 왼손 초기좌표

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        final String right = "369"; // 오른손으로 누르는 버튼
        final String left = "147"; // 왼손으로 누르는 버튼
        // 전화번호 좌표값 세팅
        key.put(1, new int[]{0, 0});
        key.put(2, new int[]{0, 1});
        key.put(3, new int[]{0, 2});
        key.put(4, new int[]{1, 0});
        key.put(5, new int[]{1, 1});
        key.put(6, new int[]{1, 2});
        key.put(7, new int[]{2, 0});
        key.put(8, new int[]{2, 1});
        key.put(9, new int[]{2, 2});
        key.put(0, new int[]{3, 1});

        String LorR = ""; // 누르는 손 결정

        for (int i = 0; i < numbers.length; i++) {
            if(left.contains(Integer.toString(numbers[i]))) { // 왼손으로 누르는 버튼이면
                LorR = "L";
            } else if(right.contains(Integer.toString(numbers[i]))) { // 오른손으로 누르는 버튼
                LorR = "R";
            } else { // 가운데 버튼이면 거리가 가까운 손으로 누르기
                if(rDist(numbers[i]) > lDist(numbers[i])) {
                    LorR = "L";
                } else if (rDist(numbers[i]) < lDist(numbers[i])) {
                    LorR = "R";
                } else { // 거리도 같으면 주 손으로 누르기
                    LorR = hand;
                }
            }
            if(LorR.equals("right")) { // 손에 따라 정답업데이트 및 좌표값 수정
                answer += "R";
                rIdx = key.get(numbers[i]);
            } else {
                answer += "L";
                lIdx = key.get(numbers[i]);
            }
        }
        return answer;
    }
    // 아래는 거리 구하는 메서드
    public static int rDist(int num) {
        return Math.abs(key.get(num)[0] - rIdx[0]) + Math.abs(key.get(num)[1] - rIdx[1]);
    }
    public static int lDist(int num) {
        return Math.abs(key.get(num)[0] - lIdx[0]) + Math.abs(key.get(num)[1] - lIdx[1]);
    }

    public static void main(String[] args) {
        System.out.println(solution((new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}), "right"));

    }
}
/*
[학습내용]
if - else if - else 의 결과물이 계속 반복되는 패턴이면
해당 결과물을 변수로 받은 후 마지막에 한번에 처리하면 가독성이 좋아짐.
 */