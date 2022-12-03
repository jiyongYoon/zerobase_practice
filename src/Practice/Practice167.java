// 프로그래머스 Lv.1 햄버거 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/133502

package Practice;

import java.util.Arrays;
import java.util.Stack;

public class Practice167 {
    public static int solution(int[] ingredient) {
        if(ingredient.length < 3) {
            return 0;
        }

        final int[] burger = {1, 2, 3, 1};
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        while(idx < ingredient.length) {
            stack.add(ingredient[idx++]);

            if(stack.size() >= 4) {
                int first = stack.elementAt(stack.size() - 4);
                int second = stack.elementAt(stack.size() - 3);
                int third = stack.elementAt(stack.size() - 2);
                int fourth = stack.elementAt(stack.size() - 1);

                int[] check = {first, second, third, fourth};

                if (Arrays.equals(check, burger)) {
                    answer++;
                    for (int i = 0; i < 4; i++) {
                        stack.pop();
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient));
    }
}
