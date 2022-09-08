// 프로그래머스 Lv.1 체육복
// https://school.programmers.co.kr/learn/courses/30/lessons/42862

/*
전체 학생 수 n
체육복 도난 당한 번호 lost
여벌 체육복 가진 학생 번호 reserve
 */

package Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice140 {
  public static int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;

    Arrays.sort(reserve);
    ArrayList<Integer> possible = new ArrayList<>();
    boolean[] lostStudent = new boolean[n + 1];

    for (int i = 0; i < lost.length; i++) {
      lostStudent[lost[i]] = true;
    }
    for (int i = 0; i < reserve.length; i++) {
      if(lostStudent[reserve[i]]) {
        lostStudent[reserve[i]] = false;
      } else {
        possible.add(reserve[i]);
      }
    }

    for (int i = 0; i < possible.size(); i++) {
      if(possible.get(i) - 1 >= 0 && lostStudent[possible.get(i) - 1]) {
        lostStudent[possible.get(i) - 1] = false;
      } else {
        if(possible.get(i) + 1 <= n && lostStudent[possible.get(i) + 1]) {
          lostStudent[possible.get(i) + 1] = false;
        }
      }
    }

    for (int i = 0; i < lostStudent.length; i++) {
      if(!lostStudent[i]) {
        answer++;
      }
    }

    return answer - 1;
  }

  public static void main(String[] args) {
    int n = 7;
    int[] lost = {2, 3, 4};
    int[] reserve = {1, 2, 3, 6};

//    int n = 8;
//    int[] lost = {5, 6, 7, 8};
//    int[] reserve = {4, 7};
    System.out.println(solution(n, lost, reserve));
  }
}
