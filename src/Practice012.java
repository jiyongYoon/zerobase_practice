import java.util.Arrays;

public class Practice012 {
//    Q12. 주어진 nums 배열에서 두번 나타나는 모든 정수의 배열을 반환하는 프로그램 작성.
//        - nums배열은 [1,n]범위의 정수로 이루어져 있음.
//        - 각 정수는 한번 또는 두번만 나타날 수 있음.
//        - 반환을 위한 메모리 공간 외에 추가적인 배열 사용은 하지 않음.
    public static void solution(int[] nums) {
        int cnt = 0; // 두번 나타나는 수의 개수. 출력시 인덱스로 활용.
        int idx1 = 0;
        int idx2 = 1;

        Arrays.sort(nums); // 오름차순 정렬
        while(idx2<nums.length) {
            if(nums[idx1]==nums[idx2]) { // 같으면 배열 수정 후 카운트 하나 추가
                nums[cnt]=nums[idx2];
                cnt++;
            }  // 다르면 아무것도 안함
            idx1++;
            idx2++; // 비교 후에는 인덱스들을 하나 증가해주기
        }

        // 출력하기
        for (int i = 0; i < cnt; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        solution(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        solution(new int[]{1, 1, 2});
        solution(new int[]{1 ,3 ,1 ,3 ,5, 5});
    }
}
