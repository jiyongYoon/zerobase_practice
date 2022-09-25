// 프로그래머스 Lv.1 모의고사
// https://school.programmers.co.kr/learn/courses/30/lessons/42840

package Practice;

import java.util.Arrays;

public class Practice144 {
  public static int[] solution(int[] answers) {
    int[] answer = {};

    int[] s1 = {1,2,3,4,5};
    int[] s2 = {2,1,2,3,2,4,2,5};
    int[] s3 = {3,3,1,1,2,2,4,4,5,5};

    int[] cnt = new int[3];

    for (int i = 0; i < answers.length; i++) {
      if(answers[i] == s1[i%5]) { cnt[0]++; }
      if(answers[i] == s2[i%8]) { cnt[1]++; }
      if(answers[i] == s3[i%10]) { cnt[2]++; }
    }

    int a = cnt[0];
    int b = cnt[1];
    int c = cnt[2];

    if(a > b && a > c) {
      return new int[]{1};
    } else if(b > a && b > c) {
      return new int[]{2};
    } else if(c > a && c > b) {
      return new int[]{3};
    } else if(a == b && a > c) {
      return new int[]{1, 2};
    } else if(a == c && a > b) {
      return new int[]{1, 3};
    } else if(b == c && b > a) {
      return new int[]{2, 3};
    } else if(a == b && b == c) {
      if(a == 0) {
        return answer;
      } else {
        return new int[]{1, 2, 3};
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] answer = {1, 3, 2, 4, 2};
    System.out.println(Arrays.toString(solution(answer)));
  }
}
