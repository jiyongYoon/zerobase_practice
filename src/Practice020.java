import java.util.Scanner;

public class Practice020 {
//    미니과제3) 놀이동산 입장권 계산 프로그램
//    나이, 입장시간, 우대사항 등에 따라 달라지는 입장료 계산
//    입력내용은 나이, 입장시간, 국가유공자 여부, 복지카드 여부 순으로 입력
//    1) 3세 미만이면 무료 입장
//    2) 복지카드와 국가유공자의 경우 일반 할인 적용
//    3) 13세 미만이면 특별 할인 적용
//    4) 17시 이후에 입장하면 특별 할인 적용

    static void calculator() {
        System.out.println("[입장권 계산]");
        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력해주세요. (숫자): ");
        int age = sc.nextInt();
        System.out.print("입장시간을 입력해주세요. (숫자): ");
        int time = sc.nextInt();
        System.out.print("국가유공자 여부를 입력해주세요. (y/n): ");
        String nmerit = sc.next();
        System.out.print("복지카드 여부를 입력해주세요. (y/n): ");
        String bcard = sc.next();
        int result = 0;

        if(age<3) {
            result = 0;
        } else {
            if(age<13 || time>=17) {
                result = 4000;
            } else if(nmerit.equals("y") || bcard.equals("y")) {
                result = 8000;
            } else {
                result = 10000;
            }
        }
        System.out.println("입장료: "+result);
    }

    public static void main(String[] args) {
        calculator();
    }
}
/*
[학습내용]
가장 큰 조건부터 최우선으로 설정.
입장료 등의 가격은 가장 낮은 금액부터, else, else ... else는 기본 입장료.
 */
