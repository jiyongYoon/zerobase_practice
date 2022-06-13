package Practice;//2차원 배열을 90도로 돌리는 프로그램
// 1, 2, 3, 4, 5
// 6, 7, 8, 9, 10
// 를
// 6, 1
// 7, 2
// 8, 3
// 9, 4
//10, 5 이렇게

public class Practice038 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        int[][] arr90 = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int r = arr.length - 1 - i; // 행과 열을 바꾸는 부분
                arr90[j][r] = arr[i][j];
            }
        }

        for (int[] item2:arr90) {
            for (int item:item2) {
                System.out.print(item + "  ");
            }
            System.out.println();
        }
    }
}
