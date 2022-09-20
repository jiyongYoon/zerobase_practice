// 프로그래머스 Lv.1 최소직사각형
// https://school.programmers.co.kr/learn/courses/30/lessons/86491

package Practice;

public class Practice142 {
  public static int solution(int[][] sizes) {

    int max1 = 0;
    int max2 = 0;

    for (int i = 0; i < sizes.length; i++) {
      int a = Math.max(sizes[i][0], sizes[i][1]);
      int b = Math.min(sizes[i][0], sizes[i][1]);

      max1 = Math.max(a, max1);
      max2 = Math.max(b, max2);
    }

    return max1 * max2;
  }

  public static void main(String[] args) {

  }
}
