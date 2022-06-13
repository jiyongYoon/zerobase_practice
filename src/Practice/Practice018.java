package Practice;

public class Practice018 {
//    미니과제1) 구구단 출력
//    1) 다중 반복문과 format함수 이용.
//    2) 1~9단까지 표시
    static void printDan() {
        System.out.println("[구구단 출력]");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
//                System.out.print(String.format("%02d x %02d = %02d \t", j, i, i*j));
                System.out.printf("%02d x %02d = %02d \t", j, i, i*j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printDan();
    }
}
/*
[학습내용]
String.format 메서드에서
1) 빈공간을 0으로 채우는 방법: %0
2) 간격을 tab키만큼 띄우는 방법: \t
3) System.out.print(String.format()); == System.out.printf();
 */