// 프로그래머스 Lv. 1 로또의 최고 순위와 최저 순위
// https://school.programmers.co.kr/learn/courses/30/lessons/77484

package Practice;

public class Practice145 {

  public static int[] solution(int[] lottos, int[] win_nums) {
    int a = 0;
    int b = 0;

    for (int i = 0; i < lottos.length; i++) {
      for (int j = 0; j < win_nums.length; j++) {
        if(lottos[i] == win_nums[j]) {
          a++;
        }
      }
    }
    for (int i = 0; i < lottos.length; i++) {
      if(lottos[i] == 0) {
        b++;
      }
    }
    int[] returnArr = {6, 6, 5, 4, 3, 2, 1};
    return new int[]{returnArr[a + b], returnArr[a]};
  }

  public static void main(String[] args) {
    int[] lottos = {44, 1, 0, 0, 31, 25};
    int[] win_nums = {31, 10, 45, 1, 6, 19};
    System.out.println(solution(lottos, win_nums));
  }
}
