package Practice;

import java.util.ArrayList;
public class Practice014 {
    //    Q14. M x N 행렬 정보가 2차원 정수형 배열matrix에 주어지면
//    나선형 모양으로 출력하기.
//    1->2->3
//          |
//    4->5  6
//    |     |
//    7<-8<-9
    public static void print(int[][] matrix) {
        // M x N 행렬이라고 한다면
        int idxm = matrix[0].length; // 열의 개수
        int idxn = matrix.length; // 행의 개수
        int currentcnt = 0; // 원소의 개수
        int a = 0; // 카운트
        ArrayList<Integer> arr = new ArrayList<>(); // 출력을 위해 숫자들을 받아 놓을 리스트

        while (true) {
            // 오른쪽으로
            for (int i = 0; i < idxm - (2 * a); i++) {
                arr.add(matrix[a][i + a]);
                currentcnt++;
            }
            if (currentcnt == idxm * idxn) {
                break;
            }
            // 아래로
            for (int i = 0; i < idxn - 1 - (2 * a); i++) {
                arr.add(matrix[i + 1 + a][idxm - 1 - a]);
                currentcnt++;
            }
            if (currentcnt == idxm * idxn) {
                break;
            }
            // 왼쪽으로
            for (int i = 0; i < idxm - 1 - (2 * a); i++) {
                arr.add(matrix[idxn - 1 - a][idxm - 2 - i - a]);
                currentcnt++;
            }
            if (currentcnt == idxm * idxn) {
                break;
            }
            // 위쪽으로
            for (int i = 0; i < idxn - 2 - (2 * a); i++) {
                arr.add(matrix[idxn - 2 - i - a][a]);
                currentcnt++;
            }
            if (currentcnt == idxm * idxn) {
                break;
            }
            a++;
        }
        //출력을 모아서 하도록 수정함.
        int[] printarr = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            printarr[i] = arr.get(i);
        }
        for (int i = 0; i < printarr.length-1; i++) {
            System.out.print(printarr[i] + ", ");
        }
        System.out.println(printarr[printarr.length-1]);
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print(arr1);
        int[][] arr2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        print(arr2);
        int[][] arr3 = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        print(arr3);
        int[][] arr4 = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}};
        print(arr4);
    }

    // 해설풀이
    public static ArrayList<Integer> solution(int[][] matrix2) {
        ArrayList<Integer> result = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix2.length - 1;
        int colStrat = 0;
        int colEnd = matrix2[0].length - 1;

        while(rowStart <= rowEnd && colStrat <= colEnd) {
            // 오른쪽으로
            for (int i = colStrat; i < colEnd; i++) {
                result.add(matrix2[rowStart][i]);
            }
            rowStart++;
            // 아래로
            for (int i = rowStart; i < rowEnd; i++) {
                result.add(matrix2[i][colEnd]);
            }
            colEnd--;
            // 왼쪽으로
            if(rowStart<=rowEnd) {
                for (int i = colEnd; i >= colStrat; i--) {
                    result.add(matrix2[rowEnd][i]);
                }
            }
            rowEnd--;
            // 위쪽으로
            if (colStrat <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix2[i][colStrat]);
                }
            }
            colStrat++;
        }
        return result;
    }
}

/*
[학습내용]
1) 사람의 관점으로 움직이는 변수가 있으면 그 변수를 ++, -- 해주면 더 직관적임.
2) 다차원 배열의
   행의 길이 = 객체이름.length
   열의 길이 = 객체이름[0].length
 */
