// 프로그래머스 Lv.1 성격유형 검사하기
// https://school.programmers.co.kr/learn/courses/30/lessons/118666

package Practice;

public class Practice146 {
  public static String solution(String[] survey, int[] choices) {
    String answer = "";

    int[] RT = new int[2];
    int[] CF = new int[2];
    int[] JM = new int[2];
    int[] AN = new int[2];

    for (int i = 0; i < choices.length; i++) {
      if(choices[i] == 4) {
        continue;
      }

      char addChar = 0;
      int addPoint = 0;

      if (choices[i] < 4) {
        addChar = survey[i].charAt(0);
        addPoint = 4 - choices[i];
      } else {
        addChar = survey[i].charAt(1);
        addPoint = choices[i] - 4;
      }

      switch (addChar) {
        case 'R' -> RT[0] += addPoint;
        case 'T' -> RT[1] += addPoint;
        case 'C' -> CF[0] += addPoint;
        case 'F' -> CF[1] += addPoint;
        case 'J' -> JM[0] += addPoint;
        case 'M' -> JM[1] += addPoint;
        case 'A' -> AN[0] += addPoint;
        case 'N' -> AN[1] += addPoint;
      }
    }

    answer += (RT[0] >= RT[1]) ? "R" : "T";
    answer += (CF[0] >= CF[1]) ? "C" : "F";
    answer += (JM[0] >= JM[1]) ? "J" : "M";
    answer += (AN[0] >= AN[1]) ? "A" : "N";

    return answer;
  }

  public static void main(String[] args) {

  }
}
