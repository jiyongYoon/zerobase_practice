package Practice;

import java.util.Scanner;

public class Practice016 {
//    깜짝미니과제 1. 아래 조건에 맞는 프로그램 구현
//    1) 숫자만 입력하고 그 외에 입력은 없음.
//    2) 입력은 Scanner와 nextInt 사용.
//    3) 1을 입력하면 회원관리 메뉴를 선택했습니다 출력
//       2을 입력하면 과목관리 메뉴를 선택했습니다 출력
//       3을 입력하면 수강관리 메뉴를 선택했습니다 출력
//       4을 입력하면 결제관리 메뉴를 선택했습니다 출력
//       5을 입력하면 과목관리 메뉴를 선택했습니다 출력
//       그 외를 입력하면 입력값이 정확하지 않습니다 출력
    static void startMenu() {
        System.out.println("<<<<[메뉴선택]>>>>");
        System.out.println("1. 회원 관리");
        System.out.println("2. 과목 관리");
        System.out.println("3. 수강 관리");
        System.out.println("4. 결제 관리");
        System.out.println("5. 종료");
    }

    public static void main(String[] args) {
        startMenu();
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴를 선택하세요: ");
        int selMenu = sc.nextInt();
        switch(selMenu) {
            case 1:
                System.out.println("회원 관리 매뉴를 선택했습니다.");
                break;
            case 2:
                System.out.println("과목 관리 매뉴를 선택했습니다.");
                break;
            case 3:
                System.out.println("수강 관리 매뉴를 선택했습니다.");
                break;
            case 4:
                System.out.println("결제 관리 매뉴를 선택했습니다.");
                break;
            case 5:
                System.out.println("프로그램을 종료합니다.");
                break;
            default:
                System.out.println("입력값이 정확하지 않습니다.");

        }
        startMenu();
    }
}
