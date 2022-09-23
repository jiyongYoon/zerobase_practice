// 프로그래머스 Lv.1 [1차] 다트 게임
// https://school.programmers.co.kr/learn/courses/30/lessons/17682

package Practice;

public class Practice143 {
  public static int first;
  public static int second;
  public static int third;

  public static int solution(String dartResult) {

    first = 1;
    second = 1;
    third = 1;

    int idx = 0;

    int[] num = new int[3];
    String[] arr = new String[3];

    int cnt = 0;

    while(idx < dartResult.length()) {
      int start = idx;
      idx++;
      if(Character.isDigit(dartResult.charAt(idx))) {
        idx++;
      }
      num[cnt] = Integer.parseInt(dartResult.substring(start, idx));
      start = idx;
      while(idx < dartResult.length() && !Character.isDigit(dartResult.charAt(idx))) {
        idx++;
      }
      arr[cnt] = (dartResult.substring(start, idx));
      cnt++;
    }

    int a = cal(num[0], arr[0], 1);
    int b = cal(num[1], arr[1], 2);
    int c = cal(num[2], arr[2], 3);

    return (first * a) + (second * b) + (third * c);
  }

  public static int cal(int num, String s, int idx) {
    int result = num;
    if(s.charAt(0) == 'D') {
      result = result * result;
    } else if(s.charAt(0) == 'T') {
      result = result * result * result;
    }

    if(s.length() == 2) {
      if(s.charAt(1) == '*') {
        if(idx == 1) {
          first = first * 2;
        } else if(idx == 2) {
          first = first * 2;
          second = second * 2;
        } else {
          second = second * 2;
          third = third * 2;
        }
      } else if(s.charAt(1) == '#') {
        if(idx == 1) {
          first = first * -1;
        } else if (idx == 2) {
          second = second * -1;
        } else {
          third = third * -1;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    String dartResult = "1D2S3T*";
    System.out.println(solution(dartResult));
  }
}
