package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 투포인터 연습문제 2
// nums 배열 3개의 합이 0이 되는 모든 숫자세트 출력
public class Practice080 {
    public static ArrayList<ArrayList<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    ArrayList<Integer> answer = new ArrayList<>();
                    answer.add(nums[i]);
                    answer.add(nums[left]);
                    answer.add(nums[right]);
                    answer.sort(Comparator.naturalOrder());
                    if(!(result.contains(answer))) {
                        result.add(answer);
                    }
                    left++;
                    right--;
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
    /*
    [다른풀이]
    정렬 후 겹치는 원소는 건너뛰는 부분이 인상적임.
    public static ArrayList<ArrayList<Integer>> solution(int nums[]) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(i==0 || i > 0 && nums[i] != nums[i - 1]) {
                int p1 = i + 1;
                int p2 = nums.length - 1;
                int sum = 0 - nums[i];

                while(p1 < p2) {
                    if (nums[p1] + nums[p2] == sum) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[p1], nums[p2])));

                        while(p1 < p2 && nums[p1] == nums[p1 + 1]) {
                            p1++;
                        }
                        while(p1 < p2 && nums[p2] == nums[p2 - 1]) {
                            p2--;
                        }
                        p1++;
                        p2--;
                    } else if(nums[p1] + nums[p2] < sum) {
                        p1++;
                    } else {
                        p2--;
                    }
                }
            }
        }
        return result;
    }
     */

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution(nums));

        nums = new int[]{1, -7, 6, 3, 5, 2};
        System.out.println(solution(nums));
    }
}
