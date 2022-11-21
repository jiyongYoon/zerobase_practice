// 프로그래머스 Lv.1 푸드 파이터 대회
// https://school.programmers.co.kr/learn/courses/30/lessons/134240

package Practice;

public class Practice163 {
    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int times = food[i] / 2;
            for (int j = 0; j < times; j++) {
                sb.append(i);
            }
        }

        sb.append("0");

        int idx = sb.length() - 2;

        String copyString = sb.toString();

        while(idx >= 0) {
            sb.append(copyString.charAt(idx));
            idx--;
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));
    }

}
