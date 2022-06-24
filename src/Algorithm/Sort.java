package Algorithm;

import java.util.Arrays;

public class Sort {
    // 버블정렬
    // 인접한 두 값을 비교하여 큰(작은) 값을 뒤(앞)로 보내는 작업을 반복
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    // 삽입정렬
    // 앞(뒤)과 비교하면서 자신보다 작은(큰) 수가 나올때까지 이동하는 것을 반복
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if(arr[j] < arr[j-1]) {
                    while(arr[j]<arr[j-1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = tmp;
                    }
                }
            }
        }
    }

    // 선택정렬
    // 가장 작은(큰) 수를 배열 맨 앞(뒤)로 보내는 작업을 반복
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
    // 퀵 정렬
    // 기준 값을 가운데로 설정한 후 기준값보다 작은 값은 왼쪽으로, 큰 값은 오른쪽으로 이동하는 것을 반복
    // 양쪽 포인터가 기준값에 모이게 되면 종료
    // 나누어진 파티션 안에서 퀵정렬 재귀호출 반복

    // 퀵정렬 재귀호출 시작
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    // 퀵정렬할 배열과 시작점, 끝점 매개변수
    public static void quickSort(int[] arr, int start, int end) {
        // 뒤쪽 파티션의 시작점을 받아옴
        int part2Start = partition(arr, start, end);
        // 각 파티션에 배열원소가 1개뿐인 경우 더이상 정렬할 필요가 없음
        // 왼쪽 파티션에 배열원소가 1개 이상 있을 경우
        if(start < part2Start - 1) {
            quickSort(arr, start, part2Start - 1); // 퀵정렬 재귀호출
        }
        // 오른쪽 파티션에 배열원소가 1개 이상 있을 경우
        if(part2Start < end) {
            quickSort(arr, part2Start, end); // 퀵정렬 재귀호출
        }
    }
    // 파티션 나누는 메서드
    public static int partition(int[] arr, int start, int end) {
        // 기준값은 배열의 가운데 위치한 값
        int pivot = arr[(start + end) / 2];
        // 왼쪽에서 시작하는 인덱스가 오른쪽에서 시작하는 인덱스보다 작은 동안 반복
        while(start <= end) {
            while(arr[start] < pivot) { start++; } // 기준값보다 작으면 인덱스 이동
            while(arr[end] > pivot) { end--; } // 기준값보다 크면 인덱스 이동
            // 둘 다 멈춘 곳은 기준값보다 왼쪽-큰 값, 오른쪽-작은 값
            // 왼쪽 인덱스가 오른쪽 인덱스보다 작거나 같으면
            if(start <= end) {
                swap(arr, start, end); // 스왑
                start++; // 인덱스 하나씩 이동
                end--;
            }
        }
        // 기준값 인덱스를 리턴하며, 이 값은 다음 파티션때 뒷 배열의 첫 인덱스가 됨.
        return start;
    }
    // 자리 바꿔주는 메서드
    public static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static void main(String[] args) {
        // test code
        int[] arr = {3, 5, 2, 7, 1, 4};
        bubbleSort(arr);
        System.out.println("버블 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        insertionSort(arr);
        System.out.println("삽입 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        selectionSort(arr);
        System.out.println("선택 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        quickSort(arr);
        System.out.println("퀵 정렬: " + Arrays.toString(arr));
    }
}
