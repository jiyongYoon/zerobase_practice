package Practice;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Practice022 {
//    미니과제5) 달력 출력 프로그램
//    Scanner, 조건문, 반복문을 통한 달력 계산 프로그램.
//    1) 입력받은 년도와 월을 통한 달력 생성
//    2) 날짜는 LocalDate클래스 이용 (Calender와 Date클래스도 이용 가능)

    static void printCal() {
        // <입력받기>
        System.out.println("[달력 출력 프로그램]");
        Scanner sc = new Scanner(System.in);
        System.out.print("달력의 년도를 입력해주세요. (yyyy): ");
        String year = sc.nextLine();
        System.out.print("달력의 월을 입력해주세요. (mm): ");
        String month = sc.nextLine();
        String day = "01";
        String calDate = year+"-"+month+"-"+day;
        System.out.println();

        // <로직부분>
        // 입력한 년,월의 마지막 날짜 구하기 => lastday
        YearMonth tday = YearMonth.from(LocalDate.parse(calDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        int lastday = tday.lengthOfMonth();
        // 마지막날까지의 숫자행렬 => printday[]
        int[] printday = new int[lastday];
        for (int i = 0; i < printday.length; i++) {
            printday[i] = i+1;
        }
        // LocalDate로 입력한 년,월의 1일의 요일 구하기 => dayoftheweek
        LocalDate weekdate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        DayOfWeek dayoftheweek = weekdate.getDayOfWeek();
        int weekidx = 0; // 요일을 가리키는 위치(인덱스)
        switch (dayoftheweek) {
            case SUNDAY -> weekidx = 0;
            case MONDAY -> weekidx = 1;
            case TUESDAY -> weekidx = 2;
            case WEDNESDAY -> weekidx = 3;
            case THURSDAY -> weekidx = 4;
            case FRIDAY -> weekidx = 5;
            case SATURDAY -> weekidx = 6;
            default -> System.out.println();
        }

        //<출력부분>
        // 달력형태 출력하기
        System.out.printf("[%s년 %s월]\n", year, month);
        System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
        // 첫행(공백과 함께) 출력하기
        int printpoint = weekidx; // 첫행 시작점
        for (int i = 0; i < printpoint; i++) { // 공백 출력
            System.out.printf("  \t");
        }
        int continueInt=0; // while문을 돌기 위한 변수
        for (int i = 0; i < 7-weekidx; i++) { // 첫행 나머지 출력
            System.out.printf("%02d\t", printday[i]);
            continueInt++;
        }
        System.out.println();
        // 나머지행, 마지막날까지 출력
        while(continueInt<lastday) {
            for (int i = 0; i < 7; i++) { // 한 줄에 7개씩 출력
                    System.out.printf("%02d\t", printday[continueInt]);
                    continueInt++;
                    if(continueInt==lastday) {break;}
                }
                System.out.println();
            }
        }

    public static void main(String[] args) {
        printCal();
    }

//    static void studyLocalDateClass() {
//        LocalDate date = LocalDate.now();
//        System.out.println(date);
//        System.out.println("오늘은 " + date.getYear()+1 + "년 "+ date.getMonthValue() +"월 " + date.getDayOfMonth() + "일 " + date.getDayOfWeek() + "입니다.");
//        System.out.printf("오늘은 %d년 %d월 %d일 %s입니다.\n", date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getDayOfWeek());
//        LocalDate date2 = LocalDate.of(2021, 04, 13);
//        System.out.println("승재 출생일은 " + date2.getYear() + "년 "+ date2.getMonthValue() +"월 " + date2.getDayOfMonth() + "일 " + date2.getDayOfWeek() + "입니다.");
//
//        Period period = Period.between(date2, date);
//        System.out.println(period);
//        System.out.printf("승재는 지금 %d년, %d월, %d일 만큼 살았습니다. 총 %d일입니다.\n", period.getYears(), period.getMonths(), period.getDays(), ChronoUnit.DAYS.between(date2, date)+1);
//        LocalTime time = LocalTime.now();
//        System.out.println(time);
//    }
}
/*
달력 출력 프로그램
[학습내용]
날짜 및 시간과 관련된 클래스는 해당 클래스 import 후 바로 메서드로 호출 가능.
1) LocalDate 클래스=> 날짜, LocalTime 클래스=> 시간, LocalDateTime 클래스=> 날짜및시간
   메서드 1. now(): 현재
         2. of(): 파라미터에 입력한 시점
         3. get___(): 년도(Year), 월(Month=영어로, MonthValue=숫자로), 일(DayOfMonth=숫자로), 요일(DayOfWeek=영어로),
            시간, 분, 초, 나노초 등을 각각 불러올 수 있음.
2) Period 클래스: 차이 계산
   메서드 between(시작, 끝)
3) YearMonth 클래스
   해당 월의 날짜 구하기:
   YearMonth tday = YearMonth.from(LocalDate.parse(calDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
   int lastday = tday.lengthOfMonth();

 [추가학습]
 www.tcpschool.com/java/java_time_localDateTime
 java119.tistory.com/52
 */