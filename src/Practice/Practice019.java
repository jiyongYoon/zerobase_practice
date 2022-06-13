package Practice;

import java.util.Scanner;

public class Practice019 {
//    미니과제2) 결제 금액 캐시백 계산 프로그램
//    Scanner 입력함수와 조건문 사용
//    캐시백은 결제 금액의 10%, 단위는 백원단위, 한 건의 포인트는 최대 300원.
    static void cashBack() {
        int cashbackunit = 100; // 캐시백 단위
        double cashbackper = 0.1; // 캐시백 비율
        int maxcashback = 300; // 캐시백 최대금액

        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요. (금액):");
        Scanner sc = new Scanner(System.in);
        int pay = sc.nextInt();

        int cashcount = (int)(((double)pay) / (cashbackunit/cashbackper)); // 캐시백 지급단위 카운트
        int maxcount = maxcashback / cashbackunit; // 최대 카운트
        int realcashback = cashcount * cashbackunit; // 실제 캐시백 금액

//        if(cashback>=0 && cashback<100) {
//            System.out.println("결제 금액은 " + pay + "원이고, 캐시백은 0원 입니다.");
//        } else if (cashback>=100 && cashback<200) {
//            System.out.println("결제 금액은 " + pay + "원이고, 캐시백은 100원 입니다.");
//        } else if (cashback>=200 && cashback<300) {
//            System.out.println("결제 금액은 " + pay + "원이고, 캐시백은 200원 입니다.");
//        } else {
//            System.out.println("결제 금액은 " + pay + "원이고, 캐시백은 300원 입니다.");
//        }

        if(cashcount>=maxcount) {
            System.out.println("결제 금액은 " + pay + "원이고, 캐시백은 "+maxcashback+"원 입니다.");
        } else {
            System.out.println("결제 금액은 " + pay + "원이고, 캐시백은 "+realcashback+"원 입니다.");
        }
    }

    public static void main(String[] args) {
        cashBack();
    }
}

/*
캐시백 결제 프로그램
[학습내용]
- 필요한 변수값을 매번 입력받을 필요는 없지만 수정이 필요한 경우에는 해당 변수의 값을 선언하고 맨 위로 빼서 수정을 용이하게 할 수 있음.
  이후 내부적으로 계산에 필요한 변수값은 아래쪽에 선언하여 구별해주면 더 좋을듯.
- if와 else-if, else.
  else-if를 많이 사용하기 보다는, if / else 로 큰 덩어리의 규칙을 발견하면 코드가 더 말끔해질 수 있어보임.
  (else-if로 나눌만한 규칙이 그 전에 다른 변수와 과정들을 통해 미리 계산을 해둘 수 있으면 가능해짐)
  // 23~28번 줄이 33번 줄로 줄어들 수 있었음.
 */
