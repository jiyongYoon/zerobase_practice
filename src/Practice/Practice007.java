package Practice;

import java.util.Scanner;

public class Practice007 {
//    Q7. 정수를 로마 숫자 표기로 변환하는 프로그램
//    <로마숫자 표기방법>
//    0) I=1, V=5, X=10, L=50, C=100, D=500, M=1000
//    1) 큰 기호에서 작은 기호 방향으로 작성(XI, VI, II, ...)
//    2) 다음의 경우 예외
//      I는 V와 X 앞에 올 수 있다. (IV:4, IX:9)
//      X는 L과 C 앞에 올 수 있다. (XL:40, XC:90)
//      C는 D와 M 앞에 올 수 있다. (CD:400, CM:900)
    public static void main(String[] args) {
        String result = "";
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int inputInt = sc.nextInt();

        int i = 0;
        while (inputInt > 0) {
            while(inputInt >= values[i]) {
                inputInt -= values[i];
                result += roman[i];
            }
            i++;
        }
        System.out.println(result);
    }
}
/*
        [학습내용]
        ... 모르겠음...
 */