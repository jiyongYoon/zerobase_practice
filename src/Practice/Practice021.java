package Practice;

import java.util.Random;
import java.util.Scanner;

public class Practice021 {
//    미니과제4) 주민등록번호 생성 프로그램
//    Scanner와 Random클래스 사용
//    1) 입력값은 생년, 월, 일, 성별과 임의의 번호를 통해서 생성
//    2) 임의의 번호는 Random함수의 nextInt()함수를 통해서 생성
//    총 13자리 중 1-2는 생년, 3-4는 월, 5-6은 일,
//    7은 성별(2000년 미만은 남자1, 여자2 / 2000년 이상은 남자3, 여자4), 8-13은 임의번호

    static void pnum() {
        System.out.println("[주민등록번호 계산]");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("출생년도를 입력해 주세요. (yyyy): ");
            int year = sc.nextInt();
            if(year<1000) {
                System.out.println("출생년도를 잘못 입력하였습니다. \n재시작해주세요.");
                break;
            }
            System.out.print("출생월을 입력해 주세요. (mm): ");
            int month = sc.nextInt();
            if(month<1 || month>12) {
                System.out.println("출생월을 잘못 입력하였습니다. \n재시작해주세요.");
                break;
            }
            System.out.print("출생일을 입력해 주세요. (dd): ");
            int day = sc.nextInt();
            if(day<1 || day>31) {
                System.out.println("출생일을 잘못 입력하였습니다. \n재시작해주세요.");
                break;
            }
            System.out.print("성별을 입력해 주세요. (m/f): ");
            String gender = sc.next();
            if(gender.equals("m") || gender.equals("f")) {
            } else {
                System.out.println("성별을 잘못 입력하였습니다. \n재시작해주세요.");
                break;
            }

            int[] result = new int[13];
            //출생년도
            result[0] = (year / 10) % 10;
            result[1] = year % 10;
            //출생월
            result[2] = (month / 10);
            result[3] = month % 10;
            //출생일
            result[4] = (day / 10);
            result[5] = day % 10;
            //성별
            if (gender.equals("m")) {
                if (year < 2000) {
                    result[6] = 1;
                } else {
                    result[6] = 3;
                }
            } else {
                if (year < 2000) {
                    result[6] = 2;
                } else {
                    result[6] = 4;
                }
            }
            //임의 수
            Random random = new Random();
            for (int i = 7; i < 13; i++) {
                result[i] = random.nextInt(10);
            }
            //출력
            for (int i = 0; i < 6; i++) {
                System.out.print(result[i]);
            }
            System.out.print("-");
            for (int i = 6; i < 13; i++) {
                System.out.print(result[i]);
            }
            break;
        }
    }

    public static void main(String[] args) {
        pnum();
    }
}
/*
[학습내용]
랜덤숫자 추출하기
1) Random 클래스
   Random random = new Random(); <- import 필요
   int a = random.nextInt(범위); <- 범위 안의 정수 1개 랜덤 생성
   double d = random.nextDouble(); / boolean b = random.nextBoolean(); <- 실수, 불리언도 가능
2) Math 클래스
   Object의 자식 클래스이기 때문에 따로 import 할 필요 없음
   Math.random();은 실수형의 0.0~1.0 사이의 무작위 값 리턴
   *정수로 활용하는 방법*
   (int)(Math.random()*10); -> 0~10 사이의 무작위 정수값 리턴
 */