// 프로그래머스 Lv.1 3진법 뒤집기
// https://school.programmers.co.kr/learn/courses/30/lessons/68935

package Practice;

public class Practice141 {
  public static int solution(int n) {
    int answer = 0;

    StringBuffer sb = new StringBuffer();
    while(n > 0) {
      int tmp = n % 3;
      sb.append(tmp);
      n = n / 3;
    }
    int idx = sb.length() - 1;
    int i = 0;
    while(idx >= 0) {
      answer += Math.pow(3, i) * Integer.parseInt(String.valueOf(sb.charAt(idx)));
      i++;
      idx--;
    }
    return answer;
  }

  public static void main(String[] args) {
    int n = 45;
    System.out.println(solution(n));
  }
}
