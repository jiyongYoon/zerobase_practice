import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Practice002 {
    public static void main(String[] args) {
//        Q2. 아스키 코드 중 알파벳에 대해서, 사용자가 입력한 알파벳의 대-소문자를 바꾸는 프로그램 작성.
//        <아스키코드의 특징>
//        1. 7비트로 구성
//        2. 총 128개의 문자로 구성(출력 불가능한 제어문자 33개, 출력 가능한 문자 95개)
//        3. 출력 가능한 문자 95개는 52개의 영문 알파벳 대소문자, 10개의 숫자, 32개의 특수문자, 1개의 공백문자.
//           48~57 -> "0"~"9", 65~90 -> "A"~"Z", 97~122 -> "a"~"z"
        Scanner sc = new Scanner(System.in);
        System.out.print("알파벳을 입력하세요: ");
        String a = sc.next();

        byte[] ascii = a.getBytes(StandardCharsets.US_ASCII);

        if(ascii[0]>64 && ascii[0]<91) {
            System.out.println((Character.toString(ascii[0] + 32)));
        } else if(ascii[0]>96 && ascii[0]<123) {
            System.out.println(Character.toString((ascii[0] - 32)));
        } else {
            System.out.println("알파벳이 아닙니다.");
        }
    }
}
/*
      [다른풀이]
      char input = sc.next().charAt(0); // 객체.charAt(index)는 객체의 인덱스에 위치한 문자를 찾음.
      int output = 0;
      int step = (int)'a' - (int)'A'; // 대-소문자 차이
      if (input>= 'a' && input <= 'z') {
            output = (int)input - step;
            System.out.println((char)output);
      } else if (input >= 'A' && input <= 'Z') {
            output = (int)input + step;
            System.out.println((char)output);
      } else {
            System.out.println("알파벳이 아닙니다.");
      }

      [학습내용]
      1. 문자를 ASCII로 받으려면 byte[] 형태의 객체에 받는다.
         이때의 메서드는 객체.getBytes(StandardCharsets.US_ASCII)다.
         배열 형태로 받기 때문에 문자 여러개를 받을 수도 있다.
      2. ASCII를 다시 문자로 변환하려면 Character.toString(변수) 메서드를 사용한다.
      3. 문자를 1개만 핸들링할땐 형변환만으로도 가능하다.
         char a = 'a' 일때, (int)a 는 97이 됨.
         int b = 97 일때, (char)b 는 'a'가 됨.

      [관련링크]
      문자 -> ASCII: https://www.delftstack.com/ko/howto/java/how-to-convert-character-to-ascii-numeric-value-in-java/
      ASCII -> 문자: https://www.delftstack.com/ko/howto/java/java-ascii-to-char/

*/