package Practice;

import java.util.LinkedHashMap;
import java.util.Random;

public class Practice023 {
//    과제6. 가상 대선 당선 시뮬레이션 프로그램
//    1) 총 1만표 진행
//    2) 각 투표수의 결과는 4명의 대선주자들이 동일한 비율로 랜덤하게 발생
//       (단, 당선자는 동률이 안됨)
//    3) 임의번호는 Random 함수의 nextInt()함수를 통해서 생성

    static void vote(int people) { // 유권자 수 입력받음

        //후보등록 (후보 추가만 하면 나머지는 자동으로)
        LinkedHashMap<Integer, String> int_name = new LinkedHashMap<>();
        int_name.put(1, "이재명");
        int_name.put(2, "윤석열");
        int_name.put(3, "심상정");
        int_name.put(4, "안철수");

        //투표진행
        //각 후보 투표함
        int[] votebox = new int[int_name.size()+1];
        Random random = new Random();
        while (votebox[0] < people) {
            int voteInt = random.nextInt(1, int_name.size()+1);
            for (int i = 1; i <= int_name.size(); i++) {
                if(voteInt==i) {
                    votebox[0]++; // 진행 투표수
                    votebox[i]++; // 기호별 투표수
                }
            }

//            switch (voteInt) {
//                case 1:
//                    votebox[0]++; // 진행 투표수
//                    votebox[1]++; // 기호별 투표수
//                    break;
//                case 2:
//                    votebox[0]++;
//                    votebox[2]++;
//                    break;
//                case 3:
//                    votebox[0]++;
//                    votebox[3]++;
//                    break;
//                case 4:
//                    votebox[0]++;
//                    votebox[4]++;
//                    break;
//                default:
//                    System.out.println("무효표입니다.");
//            }
            //투표진행상황 출력
            System.out.printf("[투표진행율]: %.2f%%, %d명 투표 => %s\n", ((double)votebox[0]) / ((double)people) * ((double)100), votebox[0], int_name.get(voteInt));
            for (int i = 1; i <= int_name.size(); i++) {
                System.out.printf("[기호:%d] %s: %05.2f%%, (투표수: %d)\n", i, int_name.get(i), (((double)votebox[i])/((double)people)*100), votebox[i]);
            }
        }
        //당선인출력
        int elected = 0;
        for (int i = 1; i <= int_name.size(); i++) {
            if(votebox[i]>elected) {
                elected = votebox[i];
            }
        }

        int re = 0;
        for (int i = 1; i <= int_name.size() ; i++) {
            if(elected == votebox[i]) {
                re++;
                System.out.printf("[투표결과] 당선인: %s\n", int_name.get(i));
                if(re>1) {
                    System.out.println("당선자가 2명 이상이라 재투표가 필요합니다.");
                }
            }
        }
    }

    public static void main(String[] args) {
//        vote(10000);
        vote(2);
        vote(4);
    }
}

/*
가상 대선투표 당선 시뮬레이션
[학습내용]
1) String Format
%5.2f => 실수형, 글자공간 5개 점유, 소수점 3째자리에서 반올림하여 2째자리까지만 표현.
         *글자공간은 .과 소수점 아래도 포함한다!!*
%02d => 정수형, 두자리까지 점유, 빈 공간을 0으로 채움.
2) LinkedHashMap: 순서가 상관있는 Map
   역시 제네릭스 사용 가능.
 */