package Practice;

import java.util.Arrays;

// Q2. 양의 정수 배열이 주어졌을 때, 해당 배열로 만들 수 있는 순열 중
//     주어진 배열보다 한 단계 전의 배열(현재 데이터보다 이전의 큰 수)을 출력
//     단, 한번의 swap으로 출력 가능한 큰 수를 출력.
//     <입출력 예시>
//     3,2,1 -> 3,1,2  /  1,9,4,7,6 -> 1,9,4,6,7  /  1,1,2,3 -> 1,1,2,3
public class Practice027 {
    void swap(int[] arr) {
        int idx = -1; // 바꿀 위치

        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {
                idx = i - 1;
                break;
            }
        }

        if(idx == -1) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = arr.length-1; i > idx; i--) {
            if(arr[i] < arr[idx] && arr[i] != arr[i-1]) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Practice027 p = new Practice027();
        p.swap(new int[]{3,2,1});
        p.swap(new int[]{1,9,4,7,6});
        p.swap(new int[]{1,1,2,3});
        p.swap(new int[]{5,7,3,4,5,8});
    }
}
/*
[학습내용]
Arrays.toString(__)은 배열을 String 으로 바꾸는 것.
매개변수에는 배열형태면 다 들어올 수 있으며,
출력 시 배열처럼 '생긴' [ , , , ] String 형태로 출력됨.
 */