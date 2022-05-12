import java.util.HashMap;
import java.util.Scanner;

public class Practice006 {
//    Q6. 로마 숫자 표기를 정수형으로 변환하는 프로그램
//    <로마숫자 표기방법>
//    0) I=1, V=5, X=10, L=50, C=100, D=500, M=1000
//    1) 큰 기호에서 작은 기호 방향으로 작성(XI, VI, II, ...)
//    2) 다음의 경우 예외
//      I는 V와 X 앞에 올 수 있다. (IV:4, IX:9)
//      X는 L과 C 앞에 올 수 있다. (XL:40, XC:90)
//      C는 D와 M 앞에 올 수 있다. (CD:400, CM:900)
//    <입출력 예시>
//    III=3, IV=4, VI=6, XIII=13, XXVI=26, MCMXCIV=1994

    public static void main(String[] args) {

        HashMap<String, Integer> romeMap = new HashMap<>();
        romeMap.put("I", 1);
        romeMap.put("V", 5);
        romeMap.put("X", 10);
        romeMap.put("L", 50);
        romeMap.put("C", 100);
        romeMap.put("D", 500);
        romeMap.put("M", 1000);
        int sum = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("로마 숫자를 입력하세요: ");
        String inputStr = sc.next();
        String[] inputArr = inputStr.split("");

        for (int i = 0; i < inputArr.length-1; i++) {
            if(romeMap.get(inputArr[i])<romeMap.get(inputArr[i+1])) {
                sum -= romeMap.get(inputArr[i]);
            } else {
                sum += romeMap.get(inputArr[i]);
            }
        }
        sum += romeMap.get(inputArr[inputArr.length-1]);
        System.out.println(sum);
    }
}
/*
        [학습내용]
        1) 규칙은 있지만 if, case로 표현을 다 하기 애매한 것은 Map을 통해서 접근. (로마 숫자 표기 등)
        2) 문제에 규칙이 있다면 그 규칙을 코드로 표현하는 것으로 접근.
        3) 로마 숫자는 앞뒤를 비교해 앞 숫자가 적으면 빼고, 앞 숫자가 크면 더하면서 진행하고, 맨 마지막 숫자를 더해주는 것이 법칙.
 */