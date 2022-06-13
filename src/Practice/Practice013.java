package Practice;

import java.util.ArrayList;
import java.util.Comparator;

public class Practice013 {
//    Q13. 정렬된 정수형 배열 arr.
//    1) arr, k, x가 주어짐
//    2) k는 개수, x는 기준 값
//    3) x와 절대 값 차이 기준으로 가까운 수를 k 개수 만큼 정렬된 순서로 출력할 것
//    4) 절대 값 차이가 같을 때는 숫자가 작은 것을 먼저 출력할 것
//    <입출력 예시>
//        arr                    k     x       출력
//    1,2,3,4,5               /  4  /  3  / 1,2,3,4
//    1,2,3,4,5,6,7,8,9,10    /  5  /  5  / 3,4,5,6,7
//    2,4                     /  1  /  3  / 2
//    2,4                     /  3  /  3  / 2,4

    public static void solution(int[] arr, int k, int x) {
        ArrayList<Integer> outArr = new ArrayList<>(); // 출력할 배열 받기
//        ArrayList<Integer> abArr = new ArrayList<>(); // 절대값 작은숫자부터 넣을 배열 // 없어도 될듯
        int center = 0; // 절대값이 위치한 인덱스

        // center의 위치 잡기
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]<=x && arr[i+1]>x) {
                center = i;
                break;
            }
        }

        int ca; // 왼쪽 값의 절대값
        int cb; // 오른쪽 값의 절대값
        int a = 0; // 왼쪽 카운터
        int b = 0; // 오른쪽 카운터

        // 절대값 작은 수부터 배열 받아오기
        for (int i = 0; i < arr.length; i++) {
            if(center-a>=0 && center+1+b<arr.length) {
                ca = x - arr[center - a];
                cb = arr[center + 1 + b] - x;
                // 절대값이 왼쪽 값이 작은 경우
                if (ca < cb && center - a >= 0) {
                    outArr.add(arr[center - a]);
                    if (center - a > 0) {
                        a++;
                    } else {
                        while(center - b >= 0) {
                            b++;
                            outArr.add(arr[center + b]);
                            if(center+b==arr.length) {break;}
                        }
                        break;
                    }
                // 절대값이 같은 경우
                } else if (ca == cb && center - a >= 0) {
                    outArr.add(arr[center - a]);
                    if (center - a > 0) {
                        a++;
                    } else {
                        while(center - b >= 0) {
                            b++;
                            outArr.add(arr[center + b]);
                            if(center+b==arr.length) {break;}
                        }
                        break;
                    }
                // 절대값이 오른쪽 값이 작은 경우
                } else if (ca > cb && center - b >= 0) {
                    outArr.add(arr[center + 1 + b]);
                    if (center - b > 0) {
                        b++;
                    } else {
                        while(center - a >= 0) {
                            a++;
                            outArr.add(arr[center - 1 - a]);
                            if(center+a==arr.length) {break;}
                        }
                        break;
                    }
                } else {break;}
            } else {break;}
        }

        // 출력하기
        outArr.sort(Comparator.naturalOrder());
        System.out.println(outArr);
    }

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5}, 4, 3);
        solution(new int[]{1, 2, 3, 4, 5, 6 ,7 ,8 ,9 ,10}, 5, 5);
        solution(new int[]{2, 4}, 1, 3);
        solution(new int[]{2, 4}, 3, 3);
    }
}
