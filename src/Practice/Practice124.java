// 프로그래머스 Lv.1 신고 결과 받기
// https://school.programmers.co.kr/learn/courses/30/lessons/92334

package Practice;

import java.util.*;

public class Practice124 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashSet<String> set = new HashSet<>(Arrays.asList(report));

        HashSet<String> banId = new HashSet<>();

        HashMap<String, Integer> hm = new HashMap<>();
        for (String item : set) {
            String[] arr = item.split(" ");
            hm.put(arr[1], hm.getOrDefault(arr[1], 0) + 1);
            if(hm.get(arr[1]) >= k) {
                banId.add(arr[1]);
            }
        }

        ArrayList<String> mailList = new ArrayList<>();
        for (String item : set) {
            String[] arr = item.split(" ");
            for(String ban : banId) {
                if(arr[1].equals(ban)) {
                    mailList.add(arr[0]);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            for (int j = 0; j < mailList.size(); j++) {
                if(id_list[i].equals(mailList.get(j))) {
                    answer[i] += 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        solution(id_list, report, k);
    }
}
