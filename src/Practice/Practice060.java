package Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
// 제로베이스 선형 연습문제 재도전 필요

public class Practice060 {
    public static int lIdx = 1;
    public static int rIdx = 1;

    public static int[] solution(String[] gems) {
        int[] result = new int[2];
        int maxVal = 0; // 최대 인덱스값
        int minVal = 0; // 최소 인덱스값
        int size = maxVal - minVal; // 결과 길이
        HashSet<String> gemSet = new HashSet<>(Arrays.asList(gems));
        String[] gemStr = gemSet.toArray(String[]::new);
        HashMap<String, Integer> curgemMap = new HashMap<>();
//        for (int i = 0; i < gemStr.length; i++) {
//            curgemMap.put(gemStr[i],-1);
//        }

        while(rIdx != gems.length) {
            if(curgemMap.containsKey(gems[rIdx])) { // 키가 있으면
                curgemMap.put(gems[rIdx],rIdx);
            } else { // 키가 없으면
                curgemMap.put(gems[rIdx],rIdx); // 키, 값 추가
            }

            rIdx++;



        }


        return result;
    }

    public static void main(String[] args) {

    }
}
