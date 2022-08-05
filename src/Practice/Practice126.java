// 프로그래머스 Lv.1 폰켓몬
// https://school.programmers.co.kr/learn/courses/30/lessons/1845

package Practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Practice126 {

    public static int solution(int[] nums) {
        int pickCnt = nums.length / 2;

        HashMap<Integer, Integer> hm = new HashMap<>();
        int typeCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                typeCnt++;
                hm.put(nums[i], 1);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if(set.size() >= pickCnt) {
            return pickCnt;
        } else {
            return set.size();
        }
    }
}
