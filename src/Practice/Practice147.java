// 프로그래머스 Lv.2 괄호 회전하기
// https://school.programmers.co.kr/learn/courses/30/lessons/76502

package Practice;

import java.util.Stack;

public class Practice147 {
  static final char[] right = {']', '}', ')'};
  static final char[] left = {'[', '{', '('};
  public static int solution(String s) {
    if(s.length() % 2 == 1) {
      return 0;
    }
    StringBuilder sb = new StringBuilder(s);

    int answer = 0;
    for (int i = 0; i < s.length(); i++) {
      Stack<Character> stack = new Stack<>();
      boolean breakFlag = false;

      for (int j = 0; j < s.length(); j++) {
        char cur = sb.charAt(j);
        if(cur == left[0] || cur == left[1] || cur == left[2]) {
          stack.add(cur);
        } else {
          if (stack.isEmpty()) {
            breakFlag = true;
          } else {
            char compare = stack.peek();
            if (cur == right[0]) {
              if (compare == left[0]) {
                stack.pop();
              } else {
                breakFlag = true;
              }
            } else if (cur == right[1]) {
              if (compare == left[1]) {
                stack.pop();
              } else {
                breakFlag = true;
              }
            } else if (cur == right[2]) {
              if (compare == left[2]) {
                stack.pop();
              } else {
                breakFlag = true;
              }
            }
          }
        }
        if(breakFlag) {
          break;
        }
      }
      if(!breakFlag) {
        answer++;
      }
      char tmp = sb.charAt(0);
      sb.append(tmp);
      sb.deleteCharAt(0);
    }
    return answer;
  }

  public static void main(String[] args) {
    String s = "([{)}]";
    System.out.println(solution(s));
  }
}
