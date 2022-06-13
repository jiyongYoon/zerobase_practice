package Practice;

import java.util.Scanner;

public class Practice001 {
    public static void main(String[] args) {
//        Q1. 입력된 정수 자료형의 숫자를 거꾸로 변환하는 프로그램 작성
//        12345 -> 54321, -12345 -> -54321, 100 -> 1, 0 -> 0
        int inputInt;
        int outputInt = 0;
        int m = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        inputInt = sc.nextInt();
        // 부호관련
        if (inputInt < 0) {
            inputInt = inputInt * -1;
            m = m * -1;
        }
        // 숫자를 역으로 가져올 때는 나머지 이용
        while (inputInt > 0) {
            int r = inputInt % 10;
            inputInt = inputInt / 10;
            outputInt = outputInt * 10 + r;
        }
        System.out.println(outputInt * m);
    }
}
//       1. 숫자를 거꾸로 가져올 땐 나머지를 이용한다.
//       2. 배열이 아닌 정수를 순차적으로 받을 땐 자리수를 올리기 위해 *10을 사용한다.
