// 프로그래머스 Lv.2 주차요금 계산
// https://school.programmers.co.kr/learn/courses/30/lessons/92341

/*
fees = {기본시간, 기본요금, 단위시간, 단위요금}
records = {{시각(HH:MM) 차량번호(0000) 내역(IN/OUT)}, ...}
    1. 시각을 기준으로 오름차순
    2. 같은 번호가 나갔다가 다시 들어올 수 있음

차량번호가 작은 자동차부터 청구할 주차요금 return

1. 아이디어
차량 별 주차요금은 TreeMap 에 {차량번호 : 요금}으로 등록
주차 중 요금 계산은 HashMap 에 {차량번호 : 주차한 총시간}으로 등록하고
OUT시 요금을 TreeMap에 추가하기
==> 23:59분에 남아있는 차를 체크하기 어려움.
==> 클래스 만들어서 큐에 넣자.

==> 안된다. 남아있는 차는 배열로 체크하자.
 */

package Practice;

import java.util.*;

public class Practice139 {
    static int basicTime;
    static int basicFee;
    static int perTime;
    static int perFee;

    static TreeMap<String, Integer> tm;


    public static int[] solution(int[] fees, String[] records) {
        tm = new TreeMap<>();
        HashMap<String, String> hm = new HashMap<>();

        boolean[] parkingCarSlot =  new boolean[9999];
        int parkingCarCnt = 0;

        basicTime = fees[0];
        basicFee = fees[1];
        perTime = fees[2];
        perFee = fees[3];

        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String carNum = st.nextToken();
            String inAndOut = st.nextToken();

            if(inAndOut.equals("IN")) {
                int parkingCarNumber = Integer.parseInt(carNum);
                parkingCarSlot[parkingCarNumber] = true;
                parkingCarCnt++;

                hm.put(carNum, time);
            } else {
                int parkingCarNumber = Integer.parseInt(carNum);
                parkingCarSlot[parkingCarNumber] = false;
                parkingCarCnt--;

                int parkingTime = chargeTime(hm.get(carNum), time);
                if(tm.containsKey(carNum)) {
                    tm.put(carNum, tm.get(carNum) + parkingTime);
                } else {
                    tm.put(carNum, parkingTime);
                }
            }
        }

        for (int i = 0; i < parkingCarSlot.length; i++) {
            if(parkingCarSlot[i]) {
                String curCarNum = i + "";
                if(curCarNum.length() == 1) {
                    curCarNum = "000" + curCarNum;
                } else if(curCarNum.length() == 2) {
                    curCarNum = "00" + curCarNum;
                } else if(curCarNum.length() == 3) {
                    curCarNum = "0" + curCarNum;
                }

                int parkingTime = chargeTime(hm.get(curCarNum), "23:59");
                if(tm.containsKey(curCarNum)) {
                    tm.put(curCarNum, tm.get(curCarNum) + parkingTime);
                } else {
                    tm.put(curCarNum, parkingTime);
                }
            }
        }

        int[] answer = new int[tm.size()];
        int idx = 0;

        for (Map.Entry<String, Integer> entry : tm.entrySet()) {
            int totalTime = entry.getValue();
            answer[idx] =chargeFee(totalTime);
            idx++;
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static int chargeFee(int parkingTime) {
        if(parkingTime <= basicTime) {
            return basicFee;
        }

        int result = basicFee;
        parkingTime = parkingTime - basicTime;
        double tmp = (double)parkingTime / (double)perTime;
        int realtime = (int)Math.ceil(tmp);
        result += realtime * perFee;

        return result;
    }

    public static int chargeTime(String inTime, String outTime) {
        int inHour = Integer.parseInt(inTime.substring(0, 2));
        int inMinute = Integer.parseInt(inTime.substring(3, 5));

        int outHour = Integer.parseInt(outTime.substring(0, 2));
        int outMinute = Integer.parseInt(outTime.substring(3, 5));

        int parkingH = outHour - inHour;
        if(outMinute < inMinute) {
            outMinute = outMinute + 60;
            parkingH--;
        }
        int parkingM = outMinute - inMinute;

        int parkingTime = parkingH * 60 + parkingM;

        return parkingTime;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(solution(fees, records));
    }
}
