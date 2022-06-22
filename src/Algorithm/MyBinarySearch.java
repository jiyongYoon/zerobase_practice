package Algorithm;

import java.util.Arrays;

public class MyBinarySearch {
    // 반복문 구조
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid]==target) {
                return mid;
            } else if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 재귀호출 구조
    public static int binarySearch2(int[] arr, int target) {
        return binarySearch2(arr, target, 0, arr.length - 1);
    }
    public static int binarySearch2(int[] arr, int target, int left, int right) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if(arr[mid]==target) {
            return mid;
        } else if(arr[mid] < target) {
            return binarySearch2(arr, target, mid + 1, right);
        } else {
            return binarySearch2(arr, target, left, mid - 1);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 10, 15, 20, 30, 50, 100};
        System.out.println(Arrays.toString(arr));
        System.out.println("bns1] key: 15 -> Idx: " + binarySearch(arr, 15));
        System.out.println("bns1] key: 3 -> Idx: " + binarySearch(arr, 3));
        System.out.println("bns2] key: 15 -> Idx: " + binarySearch2(arr, 15));
        System.out.println("bns2] key: 3 -> Idx: " + binarySearch2(arr, 3));
        System.out.println("== Java 기본제공 이진탐색 ==");
        System.out.println("bns] key: 15 -> Idx: " + Arrays.binarySearch(arr, 15));
        System.out.println("bns] key: 3 -> Idx: " + Arrays.binarySearch(arr, 3));
    }
}
