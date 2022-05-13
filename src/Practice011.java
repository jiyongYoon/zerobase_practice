public class Practice011 {
//    Q11. 정수형 오름차순 데이터 배열 nums. 중복들을 제거하는 프로그램 작성.
//         이때, 추가 배열 사용하지 않고 배열 nums만 활용하여 작성.
//    <입출력예시> 1, 1, 2 => 1, 2 / 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4 => 0, 1, 2, 3, 4

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int Index1 = 0;
        int Index2 = 1;
        // 비교하기
        while(Index2<nums.length) {
            if(nums[Index1]!=nums[Index2]) { // 다르면 수정하기
                Index1++;
                nums[Index1]=nums[Index2];
            } // 같으면 아무것도 안하고
            Index2++; // 비교 후에는 인덱스2를 하나 증가해주기
        }
        // 출력하기
        for (int i = 0; i < Index1+1; i++) {
            if (i < Index1) {
                System.out.print(nums[i]+", "); //
            } else {
                System.out.println(nums[i]);
            }

        }

    }
}

