package Practice;// Q1. 파스칼의 삼각형에서 행의 수가 입력으로 주어졌을 때, 파스칼의 삼각형을 출력하기.
//     규칙 1) 첫 번째 줄에는 1이 온다
//     규칙 2) 그 다음 줄은 바로 위의 왼쪽 숫자와 오른쪽 숫자를 더한다.
//            1
//          1   1
//        1   2   1
//      1   3   3   1

import java.util.ArrayList;
import java.util.Scanner;

public class Practice026 {
    static void pascalFor() {
        Scanner sc = new Scanner(System.in);
        System.out.print("파스칼 삼각형의 행의 수를 입력하세요: ");
        int l = sc.nextInt();

        ArrayList<ArrayList<Integer>> lineArr = new ArrayList<>();

        for (int i = 0; i < l; i++) { // 행
        ArrayList<Integer> idxArr = new ArrayList<>();

            for (int j = 0; j <= i; j++) { // 인덱스
                if (j == 0 || j == i) {
                    idxArr.add(1);
                } else {
                    int x = lineArr.get(i-1).get(j-1);
                    int y = lineArr.get(i-1).get(j);
                    idxArr.add(x+y);
                }
            }
            lineArr.add(idxArr);
        }
        for (int i = 0; i < lineArr.size(); i++) {
            System.out.println(lineArr.get(i));
        }

    }
    public static void main(String[] args) {
        pascalFor();
    }
}
/*
[학습내용]
1. ArrayList 안에 또 ArrayList가 들어갈 수 있음.
 */

